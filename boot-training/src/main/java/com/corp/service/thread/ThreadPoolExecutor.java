package com.corp.service.thread;

import com.corp.service.policy.PolicyHandler;

import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolExecutor implements ThreadPoolService{

    /**
     * 记录当前alive线程数量
     * */
    private AtomicInteger ctl = new AtomicInteger();

    //拒绝策略
    private volatile PolicyHandler handler;

    //核心线程数
    private int poolSize;

    //阻塞队列保存任务
    private final BlockingQueue<Runnable> workQueue;

    private volatile boolean allowThreadTimeOut = false;

    private final long keepAliveTime;

    private ReentrantLock mainLock  = new ReentrantLock();

    private volatile boolean isShutDown = false;

    private volatile long completedTaskCount = 0;


    //花名册，记录当前线程
    private final HashSet<Worker> workers = new HashSet<Worker>();

    public ThreadPoolExecutor(int poolSize, int queueSize, long keepAliveTime, PolicyHandler handler){
        if(poolSize <= 0) throw new IllegalArgumentException("核心线程数不能为0");
        this.poolSize = poolSize;
        this.handler = handler;
        this.keepAliveTime = keepAliveTime;
        if(this.keepAliveTime > 0) allowThreadTimeOut = true;
        this.workQueue = new ArrayBlockingQueue<Runnable>(queueSize);
    }

    public void execute(Runnable task){
        int c = ctl.get();
        if(c<poolSize){
            //if() 创建新的工人 核心线程数
            addWorker(task);
            //return;
        }else if(workQueue.offer(task)){
        }else{
            //拒绝策略
            handler.reject(task,this);
        }

    }

    public boolean addWorker(Runnable r){
        //判断当前线程池是否已经关闭
        ctl.incrementAndGet();
        Worker w = new Worker(r);
        Thread t = w.thread;
        if(t!= null){
            mainLock.lock();
            if(!isShutDown){
                workers.add(w);
                t.start();
            }
            mainLock.unlock();
            return true;
        }
        return  false;
    }

    /**
     * 关闭线程池
     * */
    public void shutDown(){}

    public Runnable getTask(){
        return this.workQueue.poll();
    }

    AtomicInteger counter = new AtomicInteger();

    /**
     * 核心干活的工人
     * */
    class Worker implements Runnable{
        final Thread thread;
        Runnable firstTask;
        public Worker(Runnable task){
            firstTask = task;
            this.thread = new Thread(this,"Thread-id-"+counter.incrementAndGet());
        }

        public void run(){
            Runnable task = null;
            while((task = firstTask) !=  null || (getTask() != null)){
                task.run();
            }
        }

    }


}
