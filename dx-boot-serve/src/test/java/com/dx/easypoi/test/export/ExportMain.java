package com.dx.easypoi.test.export;

import com.dx.easypoi.test.bean.UserExam;
import com.dx.easypoi.test.bean.Subject;
import com.dx.util.AjaxResult;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaojian
 * @Description
 * @createTime 2021/11/26
 */
public class ExportMain {

    public static void main(String[] args) {

        List<UserExam> userExamList = new ArrayList<>();
        List<Subject> subjectList1 = new ArrayList<>();
        Subject subject1 = new Subject("语文",88);
        subjectList1.add(subject1);
        Subject subject2 = new Subject("数学",100);
        subjectList1.add(subject2);
        UserExam userExam1 = new UserExam("张三", "qz001", subjectList1);
        userExamList.add(userExam1);

        List<Subject> subjectList2 = new ArrayList<>();
        Subject subject3 = new Subject("语文",97);
        subjectList2.add(subject3);
        Subject subject4 = new Subject("数学",64);
        subjectList2.add(subject4);
        UserExam userExam2 = new UserExam("李四", "qz001", subjectList2);
        userExamList.add(userExam2);

        XSSFWorkbook xssfWorkbook = CustomerExportUtil.getXSSFWorkbook(userExamList,"学生考试成绩表");
        AjaxResult ajaxResult = CustomerExportUtil.exportExcel(xssfWorkbook, "学生考试成绩表");

    }

}
