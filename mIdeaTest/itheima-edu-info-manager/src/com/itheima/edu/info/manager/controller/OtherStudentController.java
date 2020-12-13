package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class OtherStudentController extends BaseStudentController {
    private Scanner sc = new Scanner(System.in);

    @Override
    public Student inputStudentInfo(String id) {
        System.out.println("请输入学生名字");
        String name = sc.next();
        System.out.println("请输入学生年龄");
        String age = sc.next();
        System.out.println("请输入学生生日");
        String birthday = sc.next();
        Student student = new Student(id, name, age, birthday);
        return student;
    }
}
