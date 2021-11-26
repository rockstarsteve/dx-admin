package com.dx.easypoi.test.bean;

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
public class UserExam {

    private String name;

    private String id;

    private List<Subject> sbujectList;

}
