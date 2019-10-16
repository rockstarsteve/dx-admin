package com.dx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: com.dx
 * 主函数入口
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/21
 */
@SpringBootApplication
@Controller
public class DxBootApplication  {

    @ResponseBody
    @GetMapping("/test")
    public String test(){
        return "test ok";
    }

    public static void main(String[] args) {
        SpringApplication.run(DxBootApplication.class, args);
    }

}
