package com.springboot_thread.service.impl;

import com.springboot_thread.service.MyAsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 作用：
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
