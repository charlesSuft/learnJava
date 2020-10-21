package com.example.demo.thread.state;

/**
 *
 */
public class BlockJoin02 {

    public static void main(String[] args) {
        System.out.println("baba and son buy smock de gushi");
        new Thread(new Father()).start();
    }
}

class Father extends Thread {
    @Override
    public void run() {
        System.out.println("baba: want to smoke, but no have");
        System.out.println("baba: my son to buy");
        Thread t  = new Thread(new Son());
        t.start();
        try {
            t.join();//father被阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("son: lost!");
        }
        System.out.println("baba: somke");
    }
}

class Son extends Thread {
    @Override
    public void run() {
        System.out.println("son: to buy");
        System.out.println("son: play 10s");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + "s......");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("son: buy smoke!");
        System.out.println("son: go home");
    }
}
