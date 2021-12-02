package com.dx.easypoi.export;

import com.dx.easypoi.bean.Stem;
import com.dx.easypoi.bean.Subject;
import com.dx.easypoi.bean.Student;
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

        List<Subject> subjectList = new ArrayList<>();
        List<Stem> stemList = new ArrayList<>();
        Stem stem1 = new Stem("简答题",34);
        Stem stem2 = new Stem("作文",53);
        stemList.add(stem1);
        stemList.add(stem2);

        List<Stem> stemList2 = new ArrayList<>();
        Stem stem3 = new Stem("算数",23);
        Stem stem4 = new Stem("填空题",32);
        Stem stem5 = new Stem("大题",53);
        stemList2.add(stem3);
        stemList2.add(stem4);
        stemList2.add(stem5);

        Subject subject1 = new Subject("语文",98,stemList);
        subjectList.add(subject1);
        Subject subject2 = new Subject("数学",76,stemList2);
        subjectList.add(subject2);
        Student student1 = new Student("tom","1398499498","男", 98,subjectList);


        List<Subject> subjectList2 = new ArrayList<>();

        List<Stem> stemList3 = new ArrayList<>();
        Stem stem6 = new Stem("简答题",21);
        Stem stem7 = new Stem("作文",24);
        stemList3.add(stem6);
        stemList3.add(stem7);

        List<Stem> stemList4 = new ArrayList<>();
        Stem stem8 = new Stem("算数",32);
        Stem stem9 = new Stem("填空题",43);
        Stem stem10 = new Stem("大题",47);
        stemList4.add(stem8);
        stemList4.add(stem9);
        stemList4.add(stem10);

        Subject subject3 = new Subject("语文",55,stemList3);
        subjectList2.add(subject3);
        Subject subject4 = new Subject("数学",83,stemList4);
        subjectList2.add(subject4);
        Student student2 = new Student("miller","15555555555","女", 78,subjectList2);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);


//        XSSFWorkbook xssfWorkbook = CustomerExportUtil.getXSSFWorkbook(studentList,"学生考试成绩表");
//        AjaxResult ajaxResult = CustomerExportUtil.exportExcel(xssfWorkbook, "学生考试成绩表");

        XSSFWorkbook xssfWorkbook = CustomerExportUtil.getXSSFWorkbook2(studentList,"学生考试成绩表");
        AjaxResult ajaxResult = CustomerExportUtil.exportExcel(xssfWorkbook, "学生考试成绩表");

    }

}
