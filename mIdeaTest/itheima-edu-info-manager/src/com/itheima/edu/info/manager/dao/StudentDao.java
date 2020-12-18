package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

public class StudentDao implements BaseStudentDao {

    private static Student[] arrStu = new Student[5];
    static {
        Student stu1 = new Student("001","zhangsan","23","11.23");
        Student stu2 = new Student("002","lisi","24","11.23");
        Student stu3 = new Student("003","wangwu","25","11.23");
        arrStu[0]=stu1;
        arrStu[1]=stu2;
        arrStu[2]=stu3;
    }

    public boolean addStu(Student student) {
        int index = -1;

        for (int i = 0; i < arrStu.length; i++) {
            if (arrStu[i] == null) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        } else {
            arrStu[index] = student;
            return true;
        }

    }

    public Student[] findAllStudent() {
        return arrStu;

    }

    public void deleteStudentById(String id) {
        int index = getIndex(id);
        arrStu[index] = null;


    }

    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < arrStu.length; i++) {
            Student stu = arrStu[i];
            if (stu != null && stu.getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateStudentById(String id, Student student) {
        int index = getIndex(id);
        arrStu[index] = student;
    }
}
