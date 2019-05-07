package com.springboot_thread.service;

import com.springboot_thread.dto.AlarmDto;

public interface AlarmService {

    /**
     * 查询一个报警信息
     * @param alarmId
     * @return
     */
    AlarmDto selectAlarm(Integer alarmId);

    /**
     * 插入报警信息
     * @param alarmDto
     * @return
     */
    int insertAlarm(AlarmDto alarmDto);
}
