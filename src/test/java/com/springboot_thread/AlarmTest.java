package com.springboot_thread;

import com.springboot_thread.dto.AlarmDto;
import com.springboot_thread.mapper.AlarmMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlarmTest {

    @Autowired
    AlarmMapper alarmMapper;

    @Test
    public void test(){
        AlarmDto alarmDto = alarmMapper.selectAlarm(1);
        System.out.println(alarmDto);
    }
}
