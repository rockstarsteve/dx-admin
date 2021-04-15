package com.dx;

import java.io.File;
import java.util.Scanner;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/25
 */
public class DirList {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //TODO 可以将path修改为写死的路径
        System.out.print("请输入你要查询文件夹的树结构: ");
        String path = sc.nextLine();
//        String path = "E:\\dev\\bank-ql\\PM\\05.接口文档\\齐鲁银行素材";

        File dir = new File(path);
        //判断填写的路径是否正确
        if (!dir.exists() || !dir.isDirectory())
            System.out.println("路径不存在");
        else {
            System.out.println("\n 整个 “" + dir.getPath() + "”  路径的树结构是：");
            listDirectories(dir, "  ");
        }
    }

    private static void listDirectories(File dir, String indent) {
        File[] dirs = dir.listFiles();
        for (File f : dirs) {
            //输出文件夹或者文件的名称
            if (f.isDirectory()) {
                System.out.println(indent + f.getName());
                listDirectories(f, indent + "    ");
            } else {
                System.out.println(indent + " " + f.getName());
            }
        }
    }
}
