package com.example.demo.thread;

/**
 * 创建线程方式一：
 * 1. 创建：继承Thread + 重写run
 * 2. 启动：创建子类对象，调用start启动,等待调度
 */
public class StartThread extends Thread{

    @Override
    public void run() {
        for (int i=0; i<20; i++) {
            System.out.println("singing");
        }
    }

    public static void main(String[] args) {
        StartThread st = new StartThread();
        st.start();
        for (int i=0; i<20; i++) {
            System.out.println("coding");
        }
    }
}
