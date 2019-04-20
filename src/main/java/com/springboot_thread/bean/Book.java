package com.springboot_thread.bean;

import lombok.Data;

/**
 * 作用：
 */
@Data
public class Book {
    private Integer id;
    private String bookName;
    private String author;
    private Integer stock;
    private Integer tId;
}
