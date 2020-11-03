package com.atguigu.spring5.dao;

import com.atguigu.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{
//    注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加的方法
    @Override
    public void add(Book book) {
        //1.SQL语句
        String sql="insert into t_book values(?,?,?)";
        //2.调用方法实现
        Object[] args={book.getUserId(),book.getUsername(),book.getUstatus()};
        //int update=jdbcTemplate.update(sql,book.getUserId(),book.getUsername(),book.getUstatus());
        int update=jdbcTemplate.update(sql,args);
        System.out.println("update数据库影响行数："+update);
    }

    @Override
    public void delete(String id) {
        String sql="delete from t_book where user_id=?";
        int update=jdbcTemplate.update(sql,id);
        System.out.println("update数据库影响的行数："+update);
    }

    @Override
    public void updateBook(Book book) {
        String sql="update t_book set username=?,ustatus=? where user_id=?";
        Object[] args={book.getUsername(),book.getUstatus(),book.getUserId()};
        int update=jdbcTemplate.update(sql,args);
        System.out.println("update数据库影响的行数："+update);
    }

    @Override
    public int selectCount() {
        String sql="select count(*) from t_book";
        Integer count=jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }

    @Override
    public Book findBookInfo(String id) {
        String sql="select * from t_book where user_id=?";
        Book book=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Book>(Book.class),id);
        return book;
    }

    @Override
    public List<Book> findAllBook() {
        String sql="select * from t_book";
        List<Book> bookList =jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql="insert into t_book values(?,?,?)";
        int[] ints=jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdate(List<Object[]> batchArgs) {
        String sql="update t_book set username=?,ustatus=? where user_id=?";
        int[] ints=jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDelete(List<Object[]> batchArgs) {
        String sql="delete from t_book where user_id=?";
        int[] update=jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(update));
    }
}

