package org.example.controller;

import org.example.pojo.Result;
import org.example.utils.AliOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class LoadController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoadController.class);

    @Autowired
    AliOSSUtils aliOSSUtils;
/*    @PostMapping("/upload")
    public Result getFile(String username, Integer age, MultipartFile image) throws IOException {
        log.info("收到文件：{}",image);

        String originalFilename = image.getOriginalFilename();

        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String fileName = UUID.randomUUID().toString()+extname;

        image.transferTo(new File("D:\\image\\"+fileName));



        return Result.success();

    }*/

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {

        log.info("图片名称：{}",image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("图片上传成功，访问路径：{}",url);

        return Result.success((Object) url);

    }

}
