package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.StudentDao;
import com.itheima.edu.info.manager.domain.Student;

public class StudentService {
    private StudentDao studentDao = new StudentDao();
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
}
