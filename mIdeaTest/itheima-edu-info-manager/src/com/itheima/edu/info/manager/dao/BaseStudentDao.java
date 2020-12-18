package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

import java.util.ArrayList;

public interface BaseStudentDao {


    public abstract boolean addStu(Student student) ;

    public abstract Student[] findAllStudent();

    public abstract void deleteStudentById(String id) ;

    public abstract int getIndex(String id);

    public abstract void updateStudentById(String id, Student student) ;
}
