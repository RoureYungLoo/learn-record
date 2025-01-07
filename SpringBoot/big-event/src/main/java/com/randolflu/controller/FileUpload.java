package com.randolflu.controller;

import com.randolflu.pojo.Result;
import com.randolflu.utils.AliOSSUtil;
import com.randolflu.utils.ThreadLocalUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
//@CrossOrigin

public class FileUpload {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {

        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String basePath = "C:\\Users\\RuoYang\\Desktop\\images\\";
        String filename = UUID.randomUUID().toString() + suffix;
        String fullPath = basePath + filename;

        file.transferTo(new File(fullPath));

        // return Result.success(fullPath);
        return Result.success("http://localhost:85/"+filename);
    }

    @PostMapping("/uploadoss")
    public Result<String> uploadOss(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        String userId = String.valueOf(ThreadLocalUtil.getThreadLocal("id"));
        String objectName = userId + "-" + UUID.randomUUID().toString() + suffix;
        String objectURL = "";

        try {
            objectURL = AliOSSUtil.uploadFile(objectName, file.getInputStream());
            return Result.success(objectURL);

        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }
}
