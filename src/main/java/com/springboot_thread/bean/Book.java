package com.springboot_thread.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * 作用：
 */
@Data
public class Book implements Comparable<Book>{
    private Integer id;
    private String bookName;
    private String author;
    private Integer stock;
    private Integer tId;

    public Book() {
    }

    public Book(Integer id, String bookName, String author, Integer stock, Integer tId) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.stock = stock;
        this.tId = tId;
    }

    @Override
    public int compareTo(Book o) {
        return this.id-o.id; //升序
        //return o.id-this.id;  降序
    }
}
