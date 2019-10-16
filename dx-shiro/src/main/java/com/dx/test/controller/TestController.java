package com.dx.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dx.test.bean.TestBean;
import com.dx.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 枚举类型的测试
 * @author: yaoj
 * @Date: 2018/8/1 21:56
 * 版权所有：Copyright 2018 by 文理电信
 */
@Slf4j
@RestController
@RequestMapping
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * 测试插入
     * @return
     */
    @RequestMapping("/insert")
    public Object insert(TestBean testBean){

        boolean insert = testService.save(testBean);
        return insert;
    }

    /**
     * 测试删除
     * @return
     */
    @RequestMapping("/delete/{id}")
    public Object delete(@PathVariable String id){
        boolean b = testService.removeById(id);
        return b;
    }

    /**
     * 测试插入
     * @return
     */
    @RequestMapping("/update")
    public Object update(TestBean testBean){
        boolean update = testBean.updateById();
        return update;
    }


    /**
     * 测试list查询
     * @return
     */
    @RequestMapping("/getList")
    public List<TestBean> getList(){
        QueryWrapper<TestBean> testBeanQueryWrapper = new QueryWrapper<>();
        testBeanQueryWrapper.eq("name","张三");
        //testBeanQueryWrapper.between("is_del",0,1);
        //testBeanQueryWrapper.like("name","1000");
        List<TestBean> testBeanList = testService.list(testBeanQueryWrapper);
        return testBeanList;
    }

    /**
     * 测试查询
     * @return
     */
    @RequestMapping("/get/{id}")
    public Object get(@PathVariable String id){
        TestBean testBean = testService.getById(id);
        return testBean;
    }


}
