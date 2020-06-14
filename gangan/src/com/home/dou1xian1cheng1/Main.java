package com.home.dou1xian1cheng1;

import java.io.FileInputStream;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    /**Lambda表达式
     *
     * 让实现接口变得更简单,接口只有一个方法才能用
     * <p>
     * 函数式编程思想,理解为把匿名内部类除了参数和方法体其他全删了,然后在参数方法体中间加->
     * <p>
     * 例子  Thread(() -> System.out.println("Lambda表达式"))  Thread()里面第一个()是传入函数的参数,->后面是方法
     */
   /* static interface MyMath {
        int sum(int a, int b);
    }

    public static void print(MyMath m, int a, int b) {//print里面就是匿名内部类去掉参数方法以外加->
        System.out.println(m.sum(a, b));
    }


    public static void main(String[] args) {
    *//*  //例子1: 匿名内部类
        print(new MyMath() {
            @Override
            public int sum(int a, int b) {
                return 0;
            }
        }, 100, 200);
        //例子1:替换成Lambda表达式
        print((int a, int b) -> { return a + b; }, 100, 200);
        *//*

        //例子2:匿名内部类法
      *//*  Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        });
        t.start();*//*
        //例子2:Lambda表达式
       *//* Thread t=new Thread(() -> System.out.println("Lambda表达式"));
        t.start();*//*
    }
*/
/**
 *
 */



    /**线程池  :容纳多个线程的容器,池中的线程可以多次使用
     * 创建线程过程:
     * 1. 创建线程(耗时多)
     * 2. 创建任务
     * 3. 执行任务
     * 4. 关闭线程(耗时多)
     *   比如线程池有1234  出现任务123456,线程池会以1234的顺序使用,如果123正在用,4闲,来了4任务,刚好1线程开始空闲,会使用1不会用4线程
     */


    /**
     * 带返回值的线程-----Callable(第三种线程实现方法)
     * 使用流程
     * 1.实现接口             static class MyCallable implements Callable<Integer>
     * 2.重写call方法         @Override
     public Integer call() throws Exception {
     * 3.在 main方法主线程中,  Callable<Integer> c=new MyCallable();
     *                       FutureTask<Integer>  task=new FutureTask<>(c):
     *                       new  Thread(task).start();
     * 其他方法:
     *  使用get方法会让主线程等待,肯定会让子线程执行完再进行主线程
     *  isDone  判断线程是否执行完毕
     *  cancel  传入true取消线程,返回值为布尔类型
     */
   /* public static void main(String[] args) {
        Callable<Integer> c=new MyCallable();
        FutureTask<Integer>  task=new FutureTask<>(c);
        new  Thread(task).start();
        try {
            Integer j=task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <10 ; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( Thread.currentThread().getName());
        }
    }
    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(100);
            for (int i = 0; i <10 ; i++) {
                System.out.println( Thread.currentThread().getName());
            }
            return null;
        }
    }
*/


/**  线程六大状态
 * NEW
 尚未启动的线程处于此状态。
 * RUNNABLE
 在Java虚拟机中执行的线程处于此状态。
 * BLOCKED
 被阻塞等待监视器锁定的线程处于此状态。(排队状态)
 * WAITING
 无限期等待另一个线程执行特定操作的线程处于此状态。(休眠状态)
 * TIMED_WAITING
 正在等待另一个线程执行最多指定等待时间的操作的线程处于此状态。
 * TERMINATED
 已退出的线程处于此状态。
 */


    /**
     * 多线程通信问题
     * API Object类  notify()与wait() 唤醒方法与等待方法
     * 生产者与消费者问题
     */
   /* public static void main(String[] args) {
        Food f = new Food();
        new Cook(f).start();
        new Waiter(f).start();
    }

    //厨师
    static class Cook extends Thread{
        private Food f;
        public Cook(Food f) {
            this.f = f;
        }

        @Override
        public void run() {
            for(int i=0;i<100;i++){
                if(i%2==0){
                    f.setNameAndSaste("老干妈小米粥","香辣味");
                }else{
                    f.setNameAndSaste("煎饼果子","甜辣味");
                }
            }
        }
    }
    //服务生
    static class Waiter extends Thread{
        private Food f;
        public Waiter(Food f) {
            this.f = f;
        }
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                f.get();
            }
        }
    }
    //食物
    static class Food{
        private String name;
        private String taste;

        //true 表示可以生产
        private boolean flag = true;

        public synchronized void setNameAndSaste(String name,String taste){
            if(flag) {
                this.name = name;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.taste = taste;
                flag = false;
                this.notifyAll();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public synchronized void get(){
            if(!flag) {
                System.out.println("服务员端走的菜的名称是:" + name + ",味道:" + taste);
                flag = true;
                this.notifyAll();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/


    /**
     * 线程死锁
     * a,b分别去俩试衣间,a突然想去b试衣间,b也突然想去a试衣间,互相卡着就是死锁
     * 解决方法: 在任何有可能导致锁产生的方法里,不要再调用其他产生锁的方法
     */
  /*  //罪犯
    static class Culprit {
        public synchronized void say(Police p) {
            System.out.println("你放我我放人质");
            p.fun();
        }

        public synchronized void fun() {
            System.out.println("罪犯放了,人质也放了");
        }
    }

    //警察
    static class Police {
        public synchronized void say(Culprit c) {
            System.out.println("你放人质我放你");
            c.fun();
        }

        public synchronized void fun() {
            System.out.println("罪犯跑了,人质救了");
        }
    }

    public static void main(String[] args) {
        Culprit culprit = new Culprit();
        Police police = new Police();
        culprit.say(police);
        new MyThread(culprit, police).start();
    }

    static class MyThread extends Thread {
        private Culprit c;
        private Police p;

        public MyThread(Culprit c, Police p) {
            this.c = c;
            this.p = p;
        }

        @Override
        public void run() {
            p.say(c);
        }
    }
*/

    /**
     * 公平锁与非公平锁
     * 公平锁: 排队,先来先到,比如线程1先到,之后的票不会出现其他线程
     * 但是java抢占式抢资源,之前三种都是非公平锁
     */
   /* public static void main(String[] args) {
        Runnable run = new Ticket();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }

    static class Ticket implements Runnable {
        private int count = 10;
        private Object object = new Object();
        private Lock l = new ReentrantLock(true);// 就像参数fair一样,参数设置为true就是公平锁,默认为false

        @Override
        public void run() {
            l.lock();
            System.out.println("买票开始");
            while (true) {
                if (count > 0) {

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count--;
                    System.out.println("余票" + count + Thread.currentThread().getName());
                } else {
                    break;
                }
            }
            l.unlock();
        }
    }
*/


    /**
     * 显示锁Lock
     * 同步代码块同步方法是隐式锁,显示锁比隐式锁更方便更像锁
     */
   /* public static void main(String[] args) {
        Runnable run = new Ticket();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }

    static class Ticket implements Runnable {
        private int count = 10;
        private Object object = new Object();
        private Lock l = new ReentrantLock();

        @Override
        public void run() {
            l.lock();
            while (true) {
                if (count > 0) {
                    System.out.println("买票开始");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count--;
                    System.out.println("余票" + count + Thread.currentThread().getName());
                } else {
                    break;
                }
            }
            l.unlock();
        }
    }*/


    /**线程不安全
     * 解决方法二: 同步方法 如下面 sale,如果没有静态修饰锁就是this,如果有修饰static锁就是类名.class,如Ticket
     注意看锁对象
     */
   /* public static void main(String[] args) {
        Runnable run = new Ticket();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }
    static class  Ticket implements Runnable {
        private int count = 10;
        private Object object = new Object();
        @Override
        public void run() {
            while (true) {
                boolean b = sale();
                if (!b) {
                    break;
                }
            }
        }
        public synchronized boolean sale() {   //在方法返回值前面加synchronized变成同步方法
            if (count > 0) {
                System.out.println("买票开始");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                System.out.println("余票" + count + Thread.currentThread().getName());
                return true;
            }
            return false;
        }
    }*/


    /**
     * 解决线程不安全
     * 方法一: 线程同步:同步代码块 synchronized(锁对象){}
     * 任何对象都可以作为锁对象存在,比如下面对象object
     */
    /*public static void main(String[] args) {
        Runnable run = new Ticket();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }

    static class Ticket implements Runnable {
        private int count = 10;
        private Object object = new Object();
        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    if (count > 0) {
                        System.out.println("买票开始");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        count--;
                        System.out.println("余票" + count+Thread.currentThread().getName());
                    }else {
                        break;
                    }
                }
            }
        }
    }
*/


    /**线程不安全
     * 多个线程调用一个变量
     *在本例子卖票出现负数,判定添加就是大于0,出现不合逻辑情况,就是线程不安全,
     */
  /*  public static void main(String[] args) {
        Runnable run = new Ticket();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }
    static class Ticket implements Runnable {
        private int count = 10;
        @Override
        public void run() {
            while (count > 0) {
                System.out.println("买票开始");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                System.out.println("余票"+count);
            }
        }
    }
*/


/**
 * 通过加标记来实现线程固定时间中断
 *//*
// 线程中断
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