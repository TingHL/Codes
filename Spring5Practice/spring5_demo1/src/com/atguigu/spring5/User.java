package com.atguigu.spring5;

public class User {
    private String userName;

////声明有参构造就会导致无参构造方法消失
//    public User(String userName) {
//        this.userName = userName;
//    }
//
//    public User(){
//    }

    public void add(){
        System.out.println("add ...");
    }
}
