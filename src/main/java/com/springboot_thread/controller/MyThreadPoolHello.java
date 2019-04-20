package com.springboot_thread.controller;

import com.springboot_thread.service.MyAsyncService;
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
    private MyAsyncService myAsyncService;

    @RequestMapping("/yield")
    public String submit(){
        logger.info("start submit");

        //执行两个线程。测试yield()
        myAsyncService.executeAsync1();
        myAsyncService.executeAsync2();
        logger.info("end submit");

        return "success";
    }
}
