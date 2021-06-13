package com.example.restservice;

//Greeting responses a resource. It will serialization and deserialization.
public class Greeting {
    private final long id;
    private final String content;

    public Greeting(long id,String content){
        this.id=id;
        this.content=content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
