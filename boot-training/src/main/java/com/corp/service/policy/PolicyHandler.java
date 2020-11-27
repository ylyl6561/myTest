package com.corp.service.policy;


import com.corp.service.thread.ThreadPoolExecutor;

public class PolicyHandler {
    public boolean reject(Runnable task, ThreadPoolExecutor executor){
        return false;
    }
}
