package com.lljqiu.tools.threadPool;

public class TestTask implements Runnable {
    protected ThreadPool threadPool;
    protected String runMessage;

    public TestTask(ThreadPool threadPool, String runMessage) {
        this.threadPool = threadPool;
        this.runMessage = runMessage;
    }
    @Override
    public void run() {
        System.out.println(runMessage);
        
    }
}
