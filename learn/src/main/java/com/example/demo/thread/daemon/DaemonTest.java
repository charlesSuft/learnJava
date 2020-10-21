package com.example.demo.thread.daemon;

/**
 * 守护线程：是为用户线程服务的，jvm 停止 不用等待守护线程执行完毕
 * 默认情况下，都是用户线程，jvm等待所有的用户线程执行完毕，否则不会停
 */
public class DaemonTest {

    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread t = new Thread(god);
        t.setDaemon(true);//将用户线程调整为守护线程
        t.start();
        new Thread(you).start();
    }

}

class You implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 365*100; i++) {
            System.out.println("happy life...");
        }
        System.out.println("game over");
    }
}

class God implements Runnable {
    @Override
    public void run() {
        for (;true;) {
            System.out.println("good bless you...");
        }
    }
}
