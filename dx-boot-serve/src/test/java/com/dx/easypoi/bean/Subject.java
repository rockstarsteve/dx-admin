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
public class Subject {


    private String subjectName;

    private int score;

    //一个科目下有多个题干
    private List<Stem> stemList;

}
