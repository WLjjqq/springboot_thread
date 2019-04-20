package com.springboot_thread.service.impl;

import com.springboot_thread.service.YieldAsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 作用：③yield():暂停当前正在执行的线程对象，并执行其他线程。
 * yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。
 * 因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
 * 但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
 *
 * sleep()和yield()的区别
 *              sleep()使当前线程进入停滞状态，所以执行sleep()的线程在指定的时间内肯定
 *         不会被执行；yield()只是使当前线程重新回到可执行状态，所以执行yield()的线程有可能在进入到可执行
 *         状态后马上又被执行。sleep 方法使当前运行中的线程睡眼一段时间，进入不可运行状态，这段时间的长短
 *         是由程序设定的，yield 方法使当前线程让出 CPU 占有权，但让出的时间是不可设定的。实际上，yield()
 *         方法对应了如下操作：先检测当前是否有相同优先级的线程处于同可运行状态，如有，则把 CPU  的占有权
 *         交给此线程，否则，继续运行原来的线程。所以yield()方法称为“退让”，它把运行机会让给了同等优先级
 *         的其他线程另外，sleep 方法允许较低优先级的线程获得运行机会，但 yield()  方法执行时，当前线程仍
 *         处在可运行状态，所以，不可能让出较低优先级的线程些时获得 CPU 占有权。在一个运行系统中，如果较高
 *         优先级的线程没有调用 sleep 方法，又没有受到 I\O 阻塞，那么，较低优先级线程只能等待所有较高优先
 *         级的线程运行结束，才有机会运行。
 */
@Service
public class YieldAsyncServiceImpl implements YieldAsyncService {
    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync1() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("" + Thread.currentThread().getName() + "-----" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i ==30) {
                Thread.currentThread().yield();
            }
        }
    }

    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync2() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("" + Thread.currentThread().getName() + "-----" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i ==30) {
                Thread.currentThread().yield();
            }
        }
    }
}
