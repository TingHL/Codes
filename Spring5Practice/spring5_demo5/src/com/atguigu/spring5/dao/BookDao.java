package com.atguigu.spring5.dao;

import com.atguigu.spring5.entity.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);

    void delete(String id);

    void updateBook(Book book);

    //查询记录数
    int selectCount();

    Book findBookInfo(String id);

    List<Book> findAllBook();

    void batchAddBook(List<Object[]> batchArgs);

    //批量修改
    void batchUpdate(List<Object[]> batchArgs);

    void batchDelete(List<Object[]> batchArgs);
}
