package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

public class StudentDao {

    Student[] arrStu = new Student[5];

    public boolean addStu(Student student) {
        int index = -1;

        for (int i = 0; i < arrStu.length; i++) {
            if(arrStu[i]==null){
                index = i;
                break;
            }
        }

        if(index == -1){
            return  false;
        }else{
            arrStu[index] = student;
            return true;
        }

    }

    public Student[] findAllStudent() {
        return arrStu;

    }
}
