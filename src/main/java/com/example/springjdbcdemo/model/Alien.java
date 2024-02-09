package com.example.springjdbcdemo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Alien {
    private int aid;
    private String name;
    private String tech;

    public void setAid(int aid){
        this.aid = aid;
    }
    public int getAid(){
        return aid;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setTech(String tech){
        this.tech = tech;
    }
    public String getTech(){
        return tech;
    }
    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
