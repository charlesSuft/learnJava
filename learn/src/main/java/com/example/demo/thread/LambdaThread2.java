package com.example.demo.thread;

/**
 * 多线程 lambda简化
 */
public class LambdaThread2 {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("learn lambda!")).start();

        new Thread(() -> System.out.println("laugh...")).start();
    }
}
