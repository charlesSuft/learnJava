package com.example.demo.thread.state;


/**
 * sleep模拟网络延时，放大了发生问题的可能性
 */
public class BlockSleep01 {

    public static void main(String[] args) {
        // 一份资源
        com.example.demo.thread.Web12306 web = new com.example.demo.thread.Web12306();
        // 多个代理
        new Thread(web,"sir1").start();
        new Thread(web,"sir2").start();
        new Thread(web,"sir3").start();
        new Thread(web,"sir4").start();
    }

}

class Web12306 implements Runnable{

    // 票数
    private int ticketNums = 99;
    @Override
    public void run() {// run方法不能抛出异常
        while (true) {
            if (ticketNums < 0) {
                break;
            }
            // 模拟网络延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" +  ticketNums--);
        }
    }
}
