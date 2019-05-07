package com.springboot_thread.controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot_thread.dto.AlarmDto;
import com.springboot_thread.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlarmController {

    @Autowired
    AlarmService alarmService;

    @GetMapping("/getAlarm/{alarmId}")
    public AlarmDto getAlarm(@PathVariable("alarmId") Integer alarmId){
        AlarmDto alarmDto = alarmService.selectAlarm(alarmId);
        return alarmDto;
    }

    @PostMapping("/insertAlarm")
    public String insertAlarm(@RequestBody JSONObject jsonObject){
        int i = alarmService.insertAlarm(jsonObject.toJavaObject(AlarmDto.class));
        if (i > 0) {
            return "成功";
        } else {
            return "失败";
        }
    }
}
