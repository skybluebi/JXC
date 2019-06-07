package com.priduct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                deadlock.method1();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                deadlock.method2();
//            }
//        }).start();
        new Thread(() -> {

            synchronized (deadlock) {
                System.out.println("before");
                deadlock.notifyAll();
                try {
                    deadlock.wait();//wait后面的代码不会执行，获得到锁后从此处开始执行
                    System.out.println("waity=");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        new Thread(() -> {
            synchronized (deadlock) {
                System.out.println("2");
                deadlock.notifyAll();
                try {
                    deadlock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }


}

class Deadlock {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            System.out.println("lock1--method1");
            synchronized (lock2) {
                System.out.println("lock2--method1");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println("lock2--method2");
            synchronized (lock1) {
                System.out.println("lock1--method2");
            }
        }
    }
}