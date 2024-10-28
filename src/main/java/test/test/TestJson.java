package test.test;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import com.alibaba.fastjson.JSONObject;

/**
 *  openapi签名
 * @Author xiongyong
 * @Date 2021/9/10
 */

public class TestJson {

    public static void main(String[] args) {

        JSONObject bizContent = new JSONObject();
      //  bizContent.put("pipeline_exec_name", "wf-696e5a1a-90ca-479e-8e5c-c5b6763bea2d-xvtvb");

        bizContent.put("artifactUrlNew","http://192.168.35.91:80/artifactory/wq-generic-release-local//hepcore-hep-core1.0V202101.1.1.zip");
        bizContent.put("artifactUrlOld","http://192.168.35.91:80/artifactory/wq-generic-release-local//hepcore-hep-core1.0V202101.1.19.zip");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("app_id", "mrrslagsefxmfmsh");
        jsonObject.put("method", "checkArtifactVersion");
        jsonObject.put("charset", "utf-8");
        jsonObject.put("format", "MD5");
        jsonObject.put("timestamp", System.currentTimeMillis());
        jsonObject.put("version", "1");
        jsonObject.put("biz_content", bizContent.toJSONString());
        jsonObject.put("app_key", "9d0b45dd635646859eb53a7a3a3e149");
        DigestAlgorithm digestAlgorithm = DigestAlgorithm.MD5;
        String sign = SecureUtil.signParams(digestAlgorithm, jsonObject, "&", "=", true).toUpperCase();

        System.out.println(sign);
        System.out.println(bizContent.toJSONString());
        System.out.println(jsonObject.getString("timestamp"));


    }
}
