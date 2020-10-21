package com.example.demo.thread.function;

/**
 * 其它方法
 * isAlive:线程是否还活着
 * Thread.currentThread(): 当前线程
 * setName: 设置线程名--代理
 * getName: 获取线程名--代理
 */
public class InfoTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().isAlive());
        // 设置名称： 真实角色 + 代理角色
        MyInfo info = new MyInfo("flane");
        new Thread(info).start();

        Thread t = new Thread(info);
        t.setName("dog");
        t.start();
    }
}

class MyInfo implements Runnable {

    private String name;

    public MyInfo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + name);
    }
}
