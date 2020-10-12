package com.example.demo.thread;

/**
 * 创建线程方式二：
 * 1. 创建：实现Runnable接口 + 重写run
 * 2. 启动：创建实现类对象 + 创建Thread代理对象 + 调用start启动, 等待调度
 * 推荐 避免单继承的局限性
 * 方便共享资源
 */
class RunnableImpl implements Runnable{
    private String name;

    public RunnableImpl(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " run  :  " + i);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        RunnableImpl ri1 = new RunnableImpl("C");
        Thread t1 = new Thread(ri1); // 代理对象
        t1.start();
        new Thread(new RunnableImpl("D")).start();//只使用一次  可以匿名调用
    }
}
