package com.corp.service.thread;

public interface ThreadPoolService {

    public void shutDown();
    public void execute(Runnable task);
}
