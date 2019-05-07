package com.springboot_thread.controller;

import com.springboot_thread.service.JoinAsyncService;
import com.springboot_thread.service.YieldAsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作用：
 */
@RestController
public class MyThreadPoolHello {
    private static final Logger logger = LoggerFactory.getLogger(MyThreadPoolHello.class);

    @Autowired
    private YieldAsyncService yieldAsyncService;

    @RequestMapping("/yield")
    public String yield(){
        logger.info("start yield");

        //执行两个线程。测试yield()
        yieldAsyncService.executeAsync1();
        yieldAsyncService.executeAsync2();
        logger.info("end yield");

        return "success";
    }

    @Autowired
    JoinAsyncService joinService;
    @RequestMapping("/join")
    public String join(){
        logger.info("start join");

        //执行两个线程。测试yield()
        joinService.executeAsync1();
        joinService.executeAsync2();
        logger.info("end join");

        return "success";
    }
}
