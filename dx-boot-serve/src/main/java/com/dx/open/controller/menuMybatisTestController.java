package com.dx.open.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dx.sys.entity.SysMenu;
import com.dx.sys.service.ISysMenuService;
import com.dx.util.AjaxResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "3.mybatis plus测试类")
@RestController
@RequestMapping("/openApi/menu")
@ApiSort(2)
public class menuMybatisTestController {

    @Autowired
    private ISysMenuService studentList;


    @ApiOperation(value = "获取菜单分页列表", notes = "测试查询菜单的列表信息的方法")
    @ApiImplicitParams(
            value =
                    {
                            @ApiImplicitParam(paramType = "body", name = "pageSize", value = "分页"),
                    }
    )
    @PostMapping(value = "/selectList")
    public AjaxResult selectList() {


        IPage<SysMenu> sysMenuList = studentList.selectMenuPage();

        return AjaxResult.success(sysMenuList);
    }

}
