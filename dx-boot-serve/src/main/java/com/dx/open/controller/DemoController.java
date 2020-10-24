package com.dx.open.controller;

import com.dx.common.util.AjaxResult;
import com.dx.sys.entity.SysUser;
import com.dx.sys.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    private ISysUserService sysUserService;

    @ApiOperation(value = "前后端接口", notes = "查看前后端是否通")
    @PostMapping("/openApi/getList")
    public Object getList(){
        log.info("请求后台数据！");
        return AjaxResult.success("请求成功！");
    }

    @ApiOperation(value = "获取数据", notes = "获取数据")
    @PostMapping("/openApi/insetData")
    public Object insetData(){
        log.info("请求后台数据！");
        List<SysUser> sysUsers = sysUserService.loadUsersByUsername("12");
        return sysUsers;
    }

}
