package com.springboot_thread.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 作用：
 */
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        /*for (String s : list) {
            if ("3".equals(s)) {
                list.remove(s);  //在list中 用foreach删除的话，会报ConcurrentModificationException异常  同时修改异常
                break;
            }
            System.out.println("删除list后："+s);
        }*/

        //使用iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("3".equals(next)) {
                //list.remove(next);
                iterator.remove();
            }
        }
        System.out.println(list);
        List<Book> list_book = new ArrayList<Book>();
        Book book=new Book(1,"aa","a",2,1);
        Book book1=new Book(2,"bb","b",2,1);
        Book book2=new Book(3,"cc","c",2,1);
        list_book.add(book2);
        list_book.add(book1);
        list_book.add(book);
        Collections.sort(list_book);
        for (Book book3 : list_book) {
            System.out.println(book3);
        }
    }


}
