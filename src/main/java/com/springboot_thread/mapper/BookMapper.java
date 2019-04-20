package com.springboot_thread.mapper;

import com.springboot_thread.bean.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper {
    Book getBookById(@Param("bookId") Integer id);
}
