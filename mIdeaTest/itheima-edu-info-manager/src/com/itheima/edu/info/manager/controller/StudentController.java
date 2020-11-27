package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {

    //    开启学生管理系统，并显示学生管理系统菜单
    public void start() {

        Scanner sc = new Scanner(System.in);
        System.out.println("--------欢迎来到 <学生> 管理系统--------");
        System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");

        lo:
        while (true) {
            String choice = sc.next();

            switch (choice) {
                case "1":
//                    System.out.println("添加学生");
                    addStu();
                    break;
                case "2":
                    System.out.println("删除学生");
                    break;
                case "3":
                    System.out.println("修改学生");
                    break;
                case "4":
                    System.out.println("查看学生");
                    break;
                case "5":
                    System.out.println("感谢您使用学生管理系统，再见！");
                    break lo;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }

        }


    }

    public void addStu() {
        StudentService studentService = new StudentService();
        Scanner sc = new Scanner(System.in);
        String id;

        while (true){
            System.out.println("请输入学生id");
             id = sc.next();
            boolean flag = studentService.isExists(id);
            if(flag){
                System.out.println("学号已被占用，请重新输入");
            }else{
                break;
            }

        }
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



        boolean result = studentService.addStu(student);

        if(result){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");

        }



    }
}
