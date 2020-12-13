package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.util.Scanner;

public abstract class BaseStudentController {
    private StudentService studentService = new StudentService();
    private Scanner sc = new Scanner(System.in);
    String id;

    //    开启学生管理系统，并显示学生管理系统菜单
    public final void start() {
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
//                    System.out.println("修改学生");
                    updateStudentById();
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

    private final void updateStudentById() {
        String updateId = inputStudentId();
        Student student = inputStudentInfo(updateId);

        studentService.updateStudentById(updateId,student);
        System.out.println("更新成功");
    }

    public final void deleteStudentById() {
        String deleteId = inputStudentId();
        studentService.deleteStudentById(deleteId);
        System.out.println("删除成功");
    }

    public final void findAllStudent() {
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
                continue;
            } else {
                System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getAge() + "\t" + student.getBirthday());
            }

            System.out.println();
        }

    }

    public final void addStu() {

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
        Student student = inputStudentInfo(id);
        boolean result = studentService.addStu(student);

        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    public final String inputStudentId(){
        while(true){
            System.out.println("请输入学生id");
            id = sc.next();
            boolean exists = studentService.isExists(id);
            if(exists){
                break;
            }else {
                System.out.println("该学生信息不存在，请重新输入");
            }
        }
        return id;
    }
//开闭原则：对扩展内容开放，对修改内容关闭.
    public abstract Student inputStudentInfo(String id);
}
