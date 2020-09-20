package com.dx.open.controller;

import com.dx.common.util.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: com.dx.open.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/17
 */
@RestController
@Slf4j
public class DemoController {

    @PostMapping("/openApi/getList")
    public Object getList(){
        log.info("请求后台数据！");
        return AjaxResult.success("请求成功！");
    }

}
