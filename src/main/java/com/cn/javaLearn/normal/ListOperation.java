package com.cn.javaLearn.normal;

import com.cn.javaLearn.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @program: javaLearn
 * @description: list测试类
 * @author: liyan
 * @create: 2024-05-26 16:29
 **/
public class ListOperation {

   protected transient int count =0;

    public void sot() {
        System.out.println("sot:"+count);
    }


    public void add() {
        count++;
    }



    public void ListBySort() {

        Student s1 = new Student(11,"小李");
        Student s2 = new Student(10,"小张");
        Student s3 = new Student(12,"小王");
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAge()> o2.getAge()) {
                    return 1;
                } else if (o1.getAge() < o2.getAge())  {
                    return -1;
                }
                return 0;
            }
        });
        // 排序后
        students.forEach(o -> System.out.println(o.getAge()+" -- "+o.getUserName()));

        students.sort(Comparator.comparingInt(Student:: getAge).reversed());
        students.forEach(o -> System.out.println(o.getAge()+" -- "+o.getUserName()));

        Vector<String> vector = new Vector<>();
        vector.add("s");

    }

    public static void main(String[] args) {
        ListOperation listOper = new ListOperation();
        listOper.sot();
        listOper.add();
        listOper.sot();
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.addAndGet(1);
        synchronized (listOper){
            System.out.println(11);
        }

    }


}


