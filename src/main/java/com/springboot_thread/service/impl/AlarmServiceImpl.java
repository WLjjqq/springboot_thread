package com.springboot_thread.service.impl;

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
}
