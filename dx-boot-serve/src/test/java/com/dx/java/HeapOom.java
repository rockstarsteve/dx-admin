package com.dx.java;

import java.util.ArrayList;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/04/13
 */
public class HeapOom {

    // 100kb
//    byte[] bytes = new byte[1024 * 100];

    // 1G
    byte[] bytes = new byte[1024 * 1024*1024];

    public static void main(String[] args) {

//        ArrayList<Object> list = new ArrayList<>();
//        while (true) {
//            list.add(new Temp());
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<Object> list = new ArrayList<>();
        while (true) {
            list.add(new HeapOom());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
