package com.springboot_thread.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作用：
 */
@RequestMapping("/AngularJS")
@Controller
public class AngularJSController {

    @GetMapping("/hello")
    public String AngularJs(){
        return "AngularJS_1";
    }
}
