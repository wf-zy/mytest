package test.test;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.DescribeRegionsRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeRegionsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

import java.util.List;

/**
 * @Author xiongyong
 * @Date 2021/4/8
 */

public class TestEcs {

    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<accessKeyId>", "<accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);

        DescribeRegionsRequest request = new DescribeRegionsRequest();
        request.setRegionId("cn-hangzhou");

        try {
            DescribeRegionsResponse response = client.getAcsResponse(request);

            List<DescribeRegionsResponse.Region> regions = response.getRegions();
            regions.forEach(region -> {
                System.out.println(region.getRegionId());
            });
            System.out.println(new Gson().toJson(response));
        } catch (Exception e) {
            e.printStackTrace();
        }



    }






}
