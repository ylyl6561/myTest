package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class OtherStudentDao implements BaseStudentDao {

    private static ArrayList<Student> arrStu = new ArrayList<>();

    //    private static Student[] arrStu = new Student[5];
    static {
        Student stu1 = new Student("001", "zhangsan", "23", "11.23");
        Student stu2 = new Student("002", "lisi", "24", "11.23");
        Student stu3 = new Student("003", "wangwu", "25", "11.23");
        arrStu.add(stu1);
        arrStu.add(stu2);
        arrStu.add(stu3);
    }

    @Override
    public boolean addStu(Student student) {
        arrStu.add(student);
        return true;

    }
    public Student[] findAllStudent() {
         return arrStu.toArray(new Student[10]);
    }

    public void deleteStudentById(String id) {
        int index = getIndex(id);
        arrStu.remove(index);


    }

    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < arrStu.size(); i++) {
            Student stu = arrStu.get(i);
            if (stu != null && stu.getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateStudentById(String id, Student student) {
        int index = getIndex(id);
        arrStu.set(index, student);
    }
}
