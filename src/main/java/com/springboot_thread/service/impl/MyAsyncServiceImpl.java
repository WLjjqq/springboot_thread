package com.springboot_thread.service.impl;

import com.springboot_thread.service.MyAsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 作用：join():指等待t线程终止。
 * 在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，主线程往往将于子线程之前结束，
 * 但是如果主线程处理完其他的事务后，
 * 需要用到子线程的处理结果，也就是主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()方法了。
 */
@Service
public class MyAsyncServiceImpl implements MyAsyncService {
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
