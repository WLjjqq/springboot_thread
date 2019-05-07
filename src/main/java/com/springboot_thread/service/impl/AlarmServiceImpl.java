package com.springboot_thread.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.springboot_thread.dto.AlarmDto;
import com.springboot_thread.mapper.AlarmMapper;
import com.springboot_thread.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlarmServiceImpl implements AlarmService {

    @Autowired
    AlarmMapper alarmMapper;
    @Override
    public AlarmDto selectAlarm(Integer alarmId) {
        return alarmMapper.selectAlarm(alarmId);
    }

    @Override
    public int insertAlarm(AlarmDto alarmDto) {
        return alarmMapper.insertAlarm(alarmDto);
    }


}
