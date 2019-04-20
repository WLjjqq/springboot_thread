package com.springboot_thread.thread;

/**
 * 作用：出现了线程安全问题，卖出了不存在的票和3个线程共同卖出一张票。
 * Thread-0--->正在卖第:1张票
 * Thread-2--->正在卖第:0张票
 * Thread-1--->正在卖第:-1张票
 * 原理：
 *      t0线程抢到了cpu的执行权，进入到run方法中，执行到if的时候，睡了。失去了cpu的执行权。被t1抢到了。
 *      同理。t1抢到后也睡眠了。t0睡醒了。抢到cpu执行权，开始卖票。卖的是1. ticket--后  为0.不执行了。
 *      t2也睡醒了。因为已经进入了。就卖第0张票。
 *      t1也睡醒了。同理也是进入到if中，卖第-1张票。
 *
 *      三个卖同一张票。 t0,t1,t2同时执行到卖第100张票。这个时候ticket--还没有执行。
 *
 */
public class TicketThread{
    public static void main(String[] args) {
        RunnableTicket runnableTicket = new RunnableTicket();
        Thread thread1 = new Thread(runnableTicket);
        Thread thread2 = new Thread(runnableTicket);
        Thread thread3 = new Thread(runnableTicket);
        thread1.start();
        thread2.start();
        thread3.start();

    }


}

 class RunnableTicket implements Runnable{
    private int ticket=100;
    @Override
    public void run() {
        //使用死循环，让卖票重复执行
        while (true) {
            if (ticket > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //票存在，卖票 ticket--
                System.out.println(Thread.currentThread().getName() + "--->正在卖第:" + ticket + "张票");
                ticket--;
            }
        }
    }
}
