package com.dx.easypoi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yaojian
 * @Description
 * @createTime 2021/11/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String studentName;

    private String phone;

    private String sex;

    private int score;

    //一个次考试有多个学生参加
    private List<Subject> subjectList;

}
