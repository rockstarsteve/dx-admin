package com.dx.sys.controller;


import com.dx.common.util.AjaxResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author rockstarsteve
 * @since 2020-06-11
 */
@ApiModel("后台管理登录模块")
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @ApiOperation(value = "获取数据", notes = "请将数据展示到前台")
    @GetMapping("/ok")
    public Object get(){
        return AjaxResult.success(new StringBuilder("调用没问题"));
    }

}

