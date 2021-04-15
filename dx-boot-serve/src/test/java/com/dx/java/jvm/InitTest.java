package com.dx.java.jvm;

import org.junit.Test;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/04/08
 */
class Father {

    static {
        System.out.println("Father   static.... ");
    }

    public Father() {
        System.out.println("father初始化。。。。");
    }

}

class Children extends Father {

    static {
        System.out.println("Children   static.... ");
    }

    public Children() {
        System.out.println("children初始化。。。。");
    }

}


public class InitTest {

    @Test
    public void extTest() {

//        Father father = new Father();
//        System.out.println(father);

        Children children = new Children();
        System.out.println(children);

    }

}
