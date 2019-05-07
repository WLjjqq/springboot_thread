package com.springboot_thread.mapper;

import com.springboot_thread.bean.Alarm;
import com.springboot_thread.dto.AlarmDto;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;


@Mapper
@MapperScan("AlarmMapper")
public interface AlarmMapper {

    /**
     * 查询一条报警信息
     * @param alarmId
     * @return
     */
    AlarmDto selectAlarm(@Param("alarmId") Integer alarmId);

    /**
     * 插入一条报警信息
     * @param alarmDto
     * @return
     */
    int insertAlarm(AlarmDto alarmDto);
}
