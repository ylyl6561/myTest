package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.util.Scanner;
//测试1
//develper branch
public class StudentController {
    private StudentService studentService = new StudentService();
    private Scanner sc = new Scanner(System.in);


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
//                    System.out.println("删除学生");
                    deleteStudentById();
                    break;
                case "3":
                    System.out.println("修改学生");
                    break;
                case "4":
//                    System.out.println("查看学生");
                    findAllStudent();
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

    public void deleteStudentById() {
//        调用业务员中的isExists判断该学生是否存在
        String id;

//        如果不存在则循环输入id
//        如果存在调用业务员中的deleteStudentById方法
        while (true) {
            System.out.println("请输入学生id");
            id = sc.next();
            boolean exists = studentService.isExists(id);

            if (exists) {
                break;
            } else {
                System.out.println("该学生信息不存在，请重新输入");
            }
        }
        studentService.deleteStudentById(id);
        System.out.println("删除成功");
    }


    public void findAllStudent() {
//        1. 调用业务员中的获取方法，得到学生对象数组
        Student[] arrStu = studentService.findAllStudent();

//        2.判断数组的内存地址，是否为null
        if (arrStu == null) {
            System.out.println("查无信息，请添加后重试");
            return;

        }
        System.out.println("学号\t姓名\t年龄\t生日");
//        3.遍历数组，获得学生信息并打印在控制台上
        for (int i = 0; i < arrStu.length; i++) {
            Student student = arrStu[i];
            if (student == null) {
                break;
            } else {
                System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getAge() + "\t" + student.getBirthday());
            }

            System.out.println();
        }

    }


    public void addStu() {

        String id;

        while (true) {
            System.out.println("请输入学生id");
            id = sc.next();
            boolean flag = studentService.isExists(id);
            if (flag) {
                System.out.println("学号已被占用，请重新输入");
            } else {
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

        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");

        }


    }
}
