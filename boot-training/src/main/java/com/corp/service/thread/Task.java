package com.corp.service.thread;

import com.corp.service.policy.PolicyHandler;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class Task implements Runnable{

    private  int num;
    public Task(int i){
        this.num = i;
    }
    public void run(){
        System.out.println("执行当前任务的线程是：" + Thread.currentThread().getName());
        System.out.println("我是任务：" + num + "我在执行...");
    }


    public static void main(String[] args) {
        ThreadPoolExecutor exePool = new ThreadPoolExecutor(5,20,20000,new PolicyHandler());
        exePool.execute(new Task(1));
        Object c = new Object();
        //c.wait();
    }


}
