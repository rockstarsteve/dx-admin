package com.dx.open.controller;

import com.dx.util.AjaxResult;
import com.dx.sys.entity.SysUser;
import com.dx.sys.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
    public Object getList(String message){
        log.info("请求后台数据！");
        long a = 796412193754198016L;
        Map map = new HashMap();
        map.put("longData", a);
        map.put("stringLongData", "796412193754198016");
        System.out.println(message);
        return AjaxResult.success(map);
    }

    @ApiOperation(value = "获取数据", notes = "获取数据")
    @PostMapping("/openApi/insetData")
    public Object insetData(){
        log.info("请求后台数据！");
        List<SysUser> sysUsers = sysUserService.loadUsersByUsername("12");
        return sysUsers;
    }

    @RequestMapping(value="/openApi/push",produces="text/event-stream;charset=utf-8")
    @ResponseBody
    public String push() {
        log.info("被调用了。。。。。。");
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3" + r.nextInt() +"\n\n";
    }
    @RequestMapping(value = "/openApi/sseTest", method = RequestMethod.GET)
    public String getSSEView () {
        return "sseTest";
    }


    //生命周期初始化回调方法
    @PostConstruct
    public void init(){
        List<SysUser> sysUsers = sysUserService.loadUsersByUsername("12");
        System.out.println("进行了bean对象的初始化了！！！");
    }



}
