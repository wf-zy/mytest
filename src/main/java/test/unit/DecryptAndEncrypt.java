package test.unit;

import cn.hutool.crypto.digest.MD5;
import cn.hutool.crypto.symmetric.AES;

/**
 * 加解密
 * @Author xiongyong
 * @Date 2022/4/24
 */

public class DecryptAndEncrypt {

    public static void main(String[] args) {

/*
        System.out.println(AesUtils.encrypt("123456"));

        System.out.println(AesUtils.decrypt("MBTcue42OVNdXZMBsyyEDA=="));*/


        byte[] digest = MD5.create().digest("1234444444");
        AES aes = new AES("ECB", "PKCS5Padding",
                // 密钥，可以自定义
                digest);

        // 加密为16进制表示
        String encryptBase64 = aes.encryptBase64("123456","UTF-8");
        System.out.println(encryptBase64);

        // 解密
        String decryptStr = aes.decryptStr(encryptBase64);
        System.out.println(decryptStr);
    }
}
