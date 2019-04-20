package com.springboot_thread;

import com.springboot_thread.bean.Book;
import com.springboot_thread.mapper.BookMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.springboot_thread.mapper")
public class SpringbootThreadApplicationTests {

    @Resource
    BookMapper  bookMapper;
    @Test
    public void contextLoads() {
        Book book = bookMapper.getBookById(1);
        System.out.println(book);
    }

}
