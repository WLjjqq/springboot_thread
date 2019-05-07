package com.springboot_thread.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.springboot_thread.dto.AlarmDto;
import com.springboot_thread.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlarmController {

    @Autowired
    AlarmService alarmService;

    @GetMapping("/getAlarm/{alarmId}")
    public AlarmDto getAlarm(@PathVariable("alarmId") Integer alarmId){
        AlarmDto alarmDto = alarmService.selectAlarm(alarmId);
        return alarmDto;
    }
}
