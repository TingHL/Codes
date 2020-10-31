package com.atguigu.spring5;

/*
使用有参数构造进行属性注入
 */
public class Orders {
    private String oname;
    private String address;

    //有参数构造
    public Orders(String oname, String address) {
        this.oname = oname;
        this.address = address;
    }

    public void ordersTest(){
        System.out.println(oname+"::"+address);
    }
}
