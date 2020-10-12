package com.example.demo.thread;

/**
 * Lambda表达式 简化线程（用一次）的使用
 */
public class LambdaThread {

    // 静态内部类
    static class Test implements Runnable {
        public void run() {
            for (int i=0; i<20; i++) {
                System.out.println("singing");
            }
        }
    }

    public static void main(String[] args) {

        new Thread(new Test()).start();

        // 局部内部类
        class Test2 implements Runnable {
            public void run() {
                for (int i=0; i<20; i++) {
                    System.out.println("singing");
                }
            }
        }

        new Thread(new Test2()).start();

        // 匿名内部类  必须借助接口或者父类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<20; i++) {
                    System.out.println("singing");
                }
            }
        }).start();

        // jdk8 简化 lambda  简化简单的线程类
        new Thread(()-> {
                for (int i=0; i<20; i++) {
                    System.out.println("singing");
                }
        }).start();
    }
}
