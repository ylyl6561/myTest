package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController extends BaseStudentController {
    private Scanner sc = new Scanner(System.in);

//开闭原则：对扩展内容开放，对修改内容关闭.
    @Override
    public Student inputStudentInfo(String id){
        System.out.println("请输入学生名字");
        String name = sc.next();
        System.out.println("请输入学生年龄");
        String age = sc.next();
        System.out.println("请输入学生生日");
        String birthday = sc.next();
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setBirthday(birthday);
        return student;
    }
}
