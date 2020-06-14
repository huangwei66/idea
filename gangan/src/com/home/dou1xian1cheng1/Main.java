package com.home.dou1xian1cheng1;

public class Main {
    /**
     * 线程分为 守护线程
     *
     */

    public static void main(String[] args) {



    }













/*   // 线程中断
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
        for (int i = 0; i < 4; i++) {
            System.out.println("主线程" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { //InterruptedException线程中断异常
                e.printStackTrace();
            }
        }
        t1.interrupt();                       //加标记

    }


    static class MyRunnable implements Runnable {
        @Override
        public void run() {

            for (int i = 0; i < 7; i++) {
                System.out.println("任务" + i);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("看看进来没");
                    return;   //使该线程死亡
                }
            }

        }
    }*/
}