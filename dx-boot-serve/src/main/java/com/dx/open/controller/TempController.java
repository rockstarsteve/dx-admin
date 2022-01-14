package com.dx.open.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiSort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author yaojian
 * @createTime 2022/01/12
 */
@Api(tags = "4.测试控制类")
@RestController
@RequestMapping("/openApi/temp")
@ApiSort(1)
public class TempController {

    @RequestMapping(value = "/select")
    public Map select() {

//        List<Student> studentList = new ArrayList<>();
//        Student tom = new Student("tom", 12);
//        studentList.add(new Student("tom", 12));
//        studentList.add(new Student("miller", 23));

        Map<Integer,String> map = new HashMap();
        map.put(1, "tom");
        map.put(2 , "jack");
        map.put(3 , "miller");

        return map;
    }


}
