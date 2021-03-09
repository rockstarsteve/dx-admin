package com.dx.sys.controller;


import com.dx.util.AjaxResult;
import com.dx.sys.entity.SysUser;
import com.dx.sys.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author rockstarsteve
 * @since 2020-06-11
 */
@Api(tags = "用户管理类")
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @ApiOperation(value = "测试接口", notes = "请将数据展示到前台")
    @PostMapping("/ok")
    @PreAuthorize("@ss.hasPermi('system:menu:query')")
    public Object get(){

        return AjaxResult.success(new StringBuilder("调用没问题"));
    }

    @ApiOperation(value = "获取用户列表数据", notes = "请将数据展示到前台")
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @PostMapping("/getList")
    public Object getList(){
        List<SysUser> list = sysUserService.list();
        return AjaxResult.success(list);
    }


}

