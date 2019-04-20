package com.springboot_thread.thread;
/**
 * 作用：出现了线程安全问题，
 *  使用同步代码块
 */
public class SynchronizedTicketThread{
    public static void main(String[] args) {
        SyncRunnableTicket runnableTicket = new SyncRunnableTicket();
        Thread thread1 = new Thread(runnableTicket);
        Thread thread2 = new Thread(runnableTicket);
        Thread thread3 = new Thread(runnableTicket);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class SyncRunnableTicket implements Runnable{
    private int ticket=100;
    //创建一个锁对象
    Object object = new Object();
    @Override
    public void run() {
        //使用死循环，让卖票重复执行
        while (true) {
            //使用同步代码块
            synchronized (object) {
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
}


