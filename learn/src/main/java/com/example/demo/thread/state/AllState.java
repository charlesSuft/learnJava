package com.example.demo.thread.state;

/**
 * 深度观察线程状态
 */
public class AllState {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("...");
            }
        });
        // 观察状态
        Thread.State state = t.getState();// NEW
        System.out.println(state.toString());

        t.start();
        state = t.getState();// RUNNABLE
        System.out.println(state.toString());

        while (state != Thread.State.TERMINATED) {
            int num = Thread.activeCount();
            System.out.println(num);

            state = t.getState();// BLOCKED TIMED_WAITING TERMINATED
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(state.toString());
        }

        state = t.getState();// TERMINATED
        System.out.println(state.toString());
    }
}
