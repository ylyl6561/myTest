package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OtherStudentDao {

    private static ArrayList<Student> arrStu = new ArrayList<>();
//    private static Student[] arrStu = new Student[5];
    static {
        Student stu1 = new Student("001","zhangsan","23","11.23");
        Student stu2 = new Student("002","lisi","24","11.23");
        Student stu3 = new Student("003","wangwu","25","11.23");
        arrStu.add(stu1);
        arrStu.add(stu2);
        arrStu.add(stu3);
    }

    public boolean addStu(Student student) {
        arrStu.add(student);
        return true;

    }

    public Student[] findAllStudent() {
        Student[] students = new Student[arrStu.size()];

        students = (Student[]) arrStu.toArray();
        return students;

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
        arrStu.set(index,student);
    }
}
