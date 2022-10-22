package com.xcx.gulimallthirdparty;

import com.aliyun.oss.OSS;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class GulimallThirdPartyApplicationTests {
    @Autowired
    OSS ossClient;
    @Test
    public  void test() throws FileNotFoundException {

//            // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
//            String endpoint = "oss-cn-shanghai.aliyuncs.com";
//            // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
//            String accessKeyId = "LTAI5t8cnYAuFR2z9dN6RFX6";
//            String accessKeySecret = "iWySIFNz0CGr3nsxEW4czwxHZ9p54g";
//            // 填写Bucket名称，例如examplebucket。
        String bucketName = "gulimall-xcx1";
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = "test4.png";
//
//            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//            // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        String filePath= "C:\\Users\\xcx\\Desktop\\wallhaven-4l7opp_1170x2532.png";

        // 创建OSSClient实例。
        InputStream inputStream = new FileInputStream(filePath);
        // 创建PutObject请求。
        ossClient.putObject( bucketName, objectName, inputStream);
        ossClient.shutdown();
        System.out.println("上传成功");

    }
}