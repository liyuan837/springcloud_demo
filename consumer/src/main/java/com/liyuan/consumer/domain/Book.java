package com.liyuan.consumer.domain;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 13:38 2018/3/9
 * @Modified By:
 */
public class Book {
    private Integer id;
    private String bookname;
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
