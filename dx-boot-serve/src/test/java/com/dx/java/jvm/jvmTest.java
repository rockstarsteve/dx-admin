package com.dx.java.jvm;

import lombok.extern.java.Log;
import org.junit.Test;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/04/01
 */

class Demo {

    private static Demo demo = new Demo();

    static int a;
    static int b = 0;

    public Demo() {
        a++;
        b++;
    }


}

@Log
public class jvmTest {

    @Test
    public void main() {
        log.info("Demo.a :" + Demo.a);
        log.info("Demo.b :" + Demo.b);
    }


}
