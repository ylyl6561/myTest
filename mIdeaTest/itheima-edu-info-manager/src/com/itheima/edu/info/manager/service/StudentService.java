package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.BaseStudentDao;
import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.factory.StudentDaoFactory;

public class StudentService {
//    private OtherStudentDao studentDao = new OtherStudentDao();
    /*通过学生库管工厂类，获取库管对象*/
    BaseStudentDao studentDao = StudentDaoFactory.getStudentDao();
    public boolean addStu(Student student) {

        return studentDao.addStu(student);
    }

    public boolean isExists(String id) {
        Student[] stus = studentDao.findAllStudent();

        boolean exists = false;
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if(student != null && id.equals(student.getId())){
                exists = true;
                break;
            }

        }
        return exists;

    }

    public Student[] findAllStudent() {
//        1. 调用库对象的findAllStudent学生对象数组
        Student[] allStudent = studentDao.findAllStudent();
//        2.判断数组中是否有学生信息（有：返回地址。没有返回null）
//        思路: 数组中只要存在一个不是null的元素，那就代表有学生信息
        boolean flag = false;
        for (int i = 0; i < allStudent.length; i++) {
            if(allStudent[i] != null){
                flag=true;
                break;
            }
        }

        if(flag){
            return allStudent;

        }else {
            return null;
        }

    }

    public void deleteStudentById(String id) {
        studentDao.deleteStudentById(id);

    }

    public void updateStudentById(String id, Student student) {
        studentDao.updateStudentById(id,student);
    }
}
