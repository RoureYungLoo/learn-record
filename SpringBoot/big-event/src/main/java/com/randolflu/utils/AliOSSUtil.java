package com.randolflu.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.randolflu.config.AliOSSConfig;
import com.randolflu.constants.Schema;

import java.io.FileInputStream;
import java.io.InputStream;

public class AliOSSUtil {
    public static String uploadFile(String objectName, InputStream inputStream) throws Exception {

        /* 要上传的文件 */
        String filePath = "C:\\Users\\RuoYang\\Desktop\\images\\34d54a40-7f9e-4a1c-8728-f9689ce23e77.jpg";

        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(Schema.HTTPS + AliOSSConfig.ENDPOINT, AliOSSConfig.ACCESS_KEY_ID, AliOSSConfig.ACCESS_KEY_SECRET);

        /* 文件URL的格式为 https://BucketName.Endpoint/ObjectName */
        String objectURL = "";
        try {
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(AliOSSConfig.BUCKET_NAME, objectName, inputStream);
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);

            objectURL = Schema.HTTPS + AliOSSConfig.BUCKET_NAME + "." + AliOSSConfig.ENDPOINT + "/" + objectName;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, " + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered " + "a serious internal problem while trying to communicate with OSS, " + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }

        return objectURL;
    }
}