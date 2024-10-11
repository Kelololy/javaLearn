package com.cn.javaLearn.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: javaLearn
 * @description: 学生
 * @author: liyan
 * @create: 2024-05-26 16:16
 **/
@Getter
@Setter
public class Student {

    private int id;
    private String userName;
    private int gender;
    private int age;
    private String address;


    public Student(int age, String userName) {
        this.age =age;
        this.userName=userName;
    }
}
