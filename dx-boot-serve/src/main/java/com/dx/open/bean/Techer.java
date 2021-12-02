package com.dx.open.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Description:
 *
 * @author yaojian
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2021/11/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "老师对象", description = "系统中老师的对象")
public class Techer {

    @ApiModelProperty(value = "老师名称", notes = "这个字段是老师名称")
    private String name;

    @ApiModelProperty(value = "老师的所教科目", notes = "这个字段是老师所教科目")
    private String subject;

    List<Student> studentList;

}
