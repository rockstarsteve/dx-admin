package com.dx.open.controller;

import com.dx.common.util.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "测试类")
@RestController
@Slf4j
public class DemoController {

    @ApiOperation(value = "前后端接口", notes = "查看前后端是否通")
    @PostMapping("/openApi/getList")
    public Object getList(){
        log.info("请求后台数据！");
        return AjaxResult.success("请求成功！");
    }

    @ApiOperation(value = "测试接口1", notes = "测试接口1")
    @PostMapping("/openApi/insetData")
    public Object insetData(){
        log.info("请求后台数据！");
        return AjaxResult.success("请求成功！");
    }

}
