package com.dx.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: com.dx.sys.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/10
 */
@RestController
public class TempController {


    @RequestMapping("/login")
    public Object login() {


        return "ok";
    }


}
