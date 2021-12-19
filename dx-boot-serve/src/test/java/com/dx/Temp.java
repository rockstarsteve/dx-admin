package com.dx;

import java.util.ArrayList;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/04/18
 */
public class Temp {


    public static void main(String[] args) {

        ArrayList list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Object o = new Object();
            System.out.println(o.hashCode());
        }



    }


}
