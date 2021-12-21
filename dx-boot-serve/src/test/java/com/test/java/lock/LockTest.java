package com.test.java.lock;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/04/12
 */
public class LockTest implements Runnable{

    public static final Object a = new Object();
    public static final Object b = new Object();

    boolean  flag = false;

    public LockTest(boolean  f) {
        this.flag = f;
    }

    @Override
    public void run() {
        if (flag){
            synchronized (a) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("test   a    b........");
                }
            }
        }else {
            synchronized (b) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println("test  b    a........");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new LockTest(true)).start();
        new Thread(new LockTest(false)).start();
    }


//    @Test
//    public void deadLockTest() {
//
//    }


}
