package com.dx.modules.file.controller;

import com.dx.base.common.bean.R;
import com.dx.modules.file.bean.Filer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Description: com.dx.modules.file.controller
 *  文件上传
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/11/13
 */
@Slf4j
@RestController
@RequestMapping("/filer")
public class FilerController {


    @Value("${filer.path}")
    String filePath;


    //TODO 保存文件操作
    @PostMapping("/save")
    public R saveFile(String title,String parentId){
        return R.ok();
    }

    @PostMapping("/upload")
    public R uploadFile(@RequestParam("file") MultipartFile file, String parentId){

        if (file.isEmpty()) {
            return R.error("上传失败，请选择文件");
        }

        String fileName = file.getOriginalFilename();

        Filer filer = new Filer();
        filer.setParentId(parentId);
        filer.setName(fileName);




        //先存数据库


        //存文件




        File dest = new File(filePath + fileName);

        try {
            file.transferTo(dest);
            log.info("上传成功");
            return R.ok("上传成功");
        } catch (IOException e) {
            log.error(e.toString(), e);
        }
        return R.error("上传失败");
    }


}
