package com.springboot_thread.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock锁解决线程安全问题。
 *   void lock(): 获取锁。
 *   void unlock():释放锁
 *
 *   使用：
 *      1：在成员位置创建一个ReentrantLock对象
 *      2：在可能h会出现安全问题的代码前调用lock接口中的lock()获取锁。
 *      3：出现安全问题后释放锁。unlock()
 */
public class LockTicketThread{
    public static void main(String[] args) {
        LockRunnableTicket runnableTicket = new LockRunnableTicket();
        Thread thread1 = new Thread(runnableTicket);
        Thread thread2 = new Thread(runnableTicket);
        Thread thread3 = new Thread(runnableTicket);
        thread1.start();
        thread2.start();
        thread3.start();

    }


}

class LockRunnableTicket implements Runnable{
   private int ticket=100;
   Lock lock =new ReentrantLock();
   @Override
   public void run() {
       //使用死循环，让卖票重复执行
       while (true) {
           //在出现安全问题前获取锁。
           lock.lock();
           if (ticket > 0) {
               try {
                   Thread.sleep(10);
                   //票存在，卖票 ticket--
                   System.out.println(Thread.currentThread().getName() + "--->正在卖第:" + ticket + "张票");
                   ticket--;
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }finally {
                   //释放锁
                   lock.unlock();
               }
           }
       }
   }
}
