package com.dx.demoservice.controller;

import com.dx.commonutils.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: com.dx.demoservice.controller
 * 测试controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/7/22
 */
@Api("讲师管理")
@RestController
public class DemoController {

    @ApiOperation(value = "获取数据")
    @GetMapping("findAll")
    public AjaxResult findAllTeacher() {
        //调用service的方法实现查询所有的操作
        return AjaxResult.success(new StringBuilder("已经调用成功了！！！"));
    }
}
