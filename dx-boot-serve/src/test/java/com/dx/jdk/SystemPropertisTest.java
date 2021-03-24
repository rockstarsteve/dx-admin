package com.dx.jdk;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/15
 */
public class SystemPropertisTest {


    static {
        setValue();
    }

    public static void setValue() {
//        System.setProperty("protocolPathProp", "www.test");
    }

    public static void main(String[] args) {

//        Properties properties = System.getProperties();
//        properties.load(inputStream);
//        inputStream.close();
//        System.setProperties(properties);

        System.out.println(System.getProperty("protocolPathProp"));



    }
}
