package com.springboot_thread.service.impl;

import com.springboot_thread.service.JoinAsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 作用：join():指等待t线程终止。
 * 在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，主线程往往将于子线程之前结束，
 * 但是如果主线程处理完其他的事务后，
 * 需要用到子线程的处理结果，也就是主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()方法了。
 */
@Service
public class JoinServiceImpl  implements JoinAsyncService {
    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync1() {
        for (int i = 0; i < 5; i++) {
            Thread.currentThread().setName("测试join方法的第一个线程");
            System.out.println(Thread.currentThread().getName()+i);
            if (i == 2) {
                try {
                    Thread.currentThread().join();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync2() {
        for (int i = 0; i < 5; i++) {
            Thread.currentThread().setName("测试join方法的第二个线程");
            System.out.println("线程："+Thread.currentThread().getName()+i);
        }
    }
}
