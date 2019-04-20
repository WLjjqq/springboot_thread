package com.springboot_thread.thread;

/**
 * 作用：使用同步方法来解决线程安全问题
 *
 */
public class SynchronizedMethodTicketThread{
    public static void main(String[] args) {
        SynchronizedMethodRunnableTicket runnableTicket = new SynchronizedMethodRunnableTicket();
        Thread thread1 = new Thread(runnableTicket);
        Thread thread2 = new Thread(runnableTicket);
        Thread thread3 = new Thread(runnableTicket);
        thread1.start();
        thread2.start();
        thread3.start();

    }


}

class SynchronizedMethodRunnableTicket implements Runnable{
   private static int ticket=100;
   @Override
   public void run() {
       payTicket();
   }

    /*
     * 定义一个同步方法
     * 也是使用锁对象，是this
     * 等同于
     * synchronized(this){
     *
     * }
     */
    public synchronized void payTicket(){
        //使用死循环，让卖票重复执行
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


    /**
     * 静态方法的锁对象是class文件对象
     * synchronize(SynchronizedMethodRunnableTicket.class){
     *
     * }
     */
    public static synchronized void payTicketStatic(){
        //使用死循环，让卖票重复执行
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
