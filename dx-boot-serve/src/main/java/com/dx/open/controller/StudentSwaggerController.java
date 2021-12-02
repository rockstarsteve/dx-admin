package com.dx.open.controller;

import com.dx.open.bean.Student;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Api(tags = "2.学生控制类")
@RestController
@RequestMapping("/openApi/user")
@ApiSort(2)
public class StudentSwaggerController {

    @ApiOperation(value = "测试", notes = "查询当个学生信息")
    @ApiImplicitParams(
            value =
                    {
                            @ApiImplicitParam(paramType = "body", name = "name", value = "用户名"),
                            @ApiImplicitParam(paramType = "body", name = "age", value = "年龄")
                    }
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "ok"),
                    @ApiResponse(code = 500, message = "faild")
            }
    )
    @PostMapping(value = "/select")
    public Student select(@RequestBody Student student) {
        return student;
    }

    @ApiOperation(value = "查询学生列表", notes = "查询学生的列表信息的方法")
    @ApiImplicitParams(
            value =
                    {
                            @ApiImplicitParam(paramType = "body", name = "name", value = "用户名"),
                            @ApiImplicitParam(paramType = "body", name = "age", value = "年龄")
                    }
    )
    @PostMapping(value = "/selectList")
    public List<Student> selectList(@RequestBody Student student) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("tom",23));
        studentList.add(new Student("miller",16));

        return studentList;
    }

}
