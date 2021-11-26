package com.dx.easypoi.test.export;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.dx.easypoi.test.bean.Stem;
import com.dx.easypoi.test.bean.Student;
import com.dx.easypoi.test.bean.Subject;
import com.dx.easypoi.test.util.ExcelUtil;
import com.dx.util.AjaxResult;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * 导出excle工具类
 *
 * @author yaojian
 * @date 2021-11-24
 */
public class CustomerExportUtil {

    private static final Logger log = LoggerFactory.getLogger(CustomerExportUtil.class);

    /**
     * 导出企业招聘学生信息集合的数据
     * @param collect 数据集合
     * @param clazz 导出集合中类的class
     * @param sheetName sheet名称
     * @return
     */
    public static <T> AjaxResult exportExcel(List<T> collect, Class<T> clazz, String sheetName) {
        Workbook wb = null;
        FileOutputStream out = null;
        String filename = "";
        try {
            filename = ExcelUtil.encodingFilename(sheetName);
            out = new FileOutputStream(ExcelUtil.getAbsoluteFile(filename));
            wb = ExcelExportUtil.exportExcel(new ExportParams(null, sheetName), clazz, collect);
            wb.write(out);
        } catch (Exception e) {
            log.error("导出Excel异常{}", e.getMessage());
            throw new RuntimeException("导出Excel失败，请联系管理员！");
        } finally {
            if (wb != null) {
                try {
                    wb.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return AjaxResult.success(filename);
    }


    /**
     * 1.1：导出 XSSFWorkbook
     * 这里需要根据不同的复杂需求进行修改
     *
     * @param students 数据
     * @return
     */
    public static XSSFWorkbook getXSSFWorkbook(List<Student> students, String sheetName) {

        //1.创建XSSFWorkbook，一个XSSFWorkbook对应的Excel文件
        XSSFWorkbook wb = new XSSFWorkbook();

        //单元格样式设置
        XSSFCellStyle alignStyle = wb.createCellStyle();
        alignStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        alignStyle.setVerticalAlignment(VerticalAlignment.CENTER);//水平居中

        //2.在work中添加一个sheet,对应excel文件中的sheet
        XSSFSheet sheet = wb.createSheet(sheetName);
        //3.设置表头，即每个列的列名
        //创建第一行
        XSSFRow row = sheet.createRow(0);
        row.setRowStyle(alignStyle);
        //此处创建一个序列号
        XSSFCell cell = row.createCell(0);
        cell.setCellStyle(alignStyle);
        cell.setCellValue("序号");
        //将列名写入
//        String[] title = {"身份证", "名称"};

        List<String> titleList = new LinkedList<>();
        titleList.add("学生名称");
        titleList.add("学生电话");

        Student student = students.get(0);
        student.getSubjectList().stream().forEach(subject -> {
            titleList.add(subject.getSubjectName());
        });
        String[] title =  titleList.toArray(new String[titleList.size()]);

        for (int i = 0; i < title.length; i++) {
            XSSFCell curcell = row.createCell(i + 1);
            curcell.setCellStyle(alignStyle);
            curcell.setCellValue(title[i]);
        }
        //写入每行的正式数据
        for (int i = 0; i < students.size(); i++) {
            //创建行
            row = sheet.createRow(i + 1);
            //创建序号
            row.createCell(0).setCellValue(i + 1);

            row.createCell(1).setCellValue(students.get(i).getStudentName());
            row.createCell(2).setCellValue(students.get(i).getPhone());
            //动态的列
            List<Subject> subjectList = students.get(i).getSubjectList();
            for (int j = 0; j < subjectList.size(); j++) {
                row.createCell(j + 3).setCellValue(subjectList.get(j).getScore());
            }

        }
        /**
         * 设置单元格宽度
         * 上面的操作已经是生成一个完整的文件了，只需要将生成的流转换成文件即可；
         * 下面的设置宽度可有可无，对整体影响不大
         */
        for (int i = 0; i <= title.length; i++) {
            sheet.setColumnWidth(i, 4000);
        }
        return wb;
    }

    /**
     * 1.1.2：导出 XSSFWorkbook
     * 这里需要根据不同的复杂需求进行修改
     *
     * @param students 数据
     * @return
     */
    public static XSSFWorkbook getXSSFWorkbook2(List<Student> students, String sheetName) {

        //1.创建XSSFWorkbook，一个XSSFWorkbook对应的Excel文件
        XSSFWorkbook wb = new XSSFWorkbook();

        //单元格样式设置
        XSSFCellStyle alignStyle = wb.createCellStyle();
        alignStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        alignStyle.setVerticalAlignment(VerticalAlignment.CENTER);//水平居中

        //2.在work中添加一个sheet,对应excel文件中的sheet
        XSSFSheet sheet = wb.createSheet(sheetName);
        //3.设置表头，即每个列的列名
        //创建第一行
        XSSFRow row = sheet.createRow(0);
        row.setRowStyle(alignStyle);
        //此处创建一个序列号
        XSSFCell cell = row.createCell(0);
        cell.setCellStyle(alignStyle);
        cell.setCellValue("序号");
        //将列名写入
//        String[] title = {"身份证", "名称"};

        List<String> titleList = new LinkedList<>();
        titleList.add("学生名称");
        titleList.add("学生电话");

        Student student = students.get(0);
        student.getSubjectList().stream().forEach(subject -> {
            titleList.add(subject.getSubjectName());
            subject.getStemList().stream().forEach(stem -> {
                titleList.add(stem.getStemName());
            });
        });
        String[] title =  titleList.toArray(new String[titleList.size()]);

        for (int i = 0; i < title.length; i++) {
            XSSFCell curcell = row.createCell(i + 1);
            curcell.setCellStyle(alignStyle);
            curcell.setCellValue(title[i]);
        }
        //写入每行的正式数据
        for (int i = 0; i < students.size(); i++) {
            //创建行
            row = sheet.createRow(i + 1);
            //创建序号
            row.createCell(0).setCellValue(i + 1);

            row.createCell(1).setCellValue(students.get(i).getStudentName());
            row.createCell(2).setCellValue(students.get(i).getPhone());
            //动态的列
            List<Subject> subjectList = students.get(i).getSubjectList();
            int insertNum = 3 ;
            for (int j = 0; j < subjectList.size(); j++) {
                row.createCell(insertNum).setCellValue(subjectList.get(j).getScore());
                insertNum++;
                for (int k = 0; k < subjectList.get(j).getStemList().size(); k++) {
                    row.createCell(k + insertNum).setCellValue(subjectList.get(j).getStemList().get(k).getScore());
                }
                insertNum+=subjectList.get(j).getStemList().size();
            }
        }
        /**
         * 设置单元格宽度
         * 上面的操作已经是生成一个完整的文件了，只需要将生成的流转换成文件即可；
         * 下面的设置宽度可有可无，对整体影响不大
         */
        for (int i = 0; i <= title.length; i++) {
            sheet.setColumnWidth(i, 4000);
        }
        return wb;
    }


    /**
     * 1.2：根据文本和文件全路径导出excel
     * @param xssfWorkbook 文本内容
     * @param sheetName sheet名称
     */
    public static AjaxResult exportExcel(XSSFWorkbook xssfWorkbook, String sheetName) {
        FileOutputStream out = null;
        String filename = null;
        try {
            filename = ExcelUtil.encodingFilename(sheetName);
            out = new FileOutputStream(ExcelUtil.getAbsoluteFile(filename));

            xssfWorkbook.write(out);
        } catch (Exception e) {
            log.error("导出Excel异常{}", e.getMessage());
            throw new RuntimeException("导出Excel失败，请联系管理员！");
        } finally {
            if (xssfWorkbook != null) {
                try {
                    xssfWorkbook.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return AjaxResult.success(filename);
    }

}
