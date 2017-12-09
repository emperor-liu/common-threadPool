/**
 * Project Name threadPool
 * File Name package-info.java
 * Package Name com.lljqiu.tools.threadPool.job
 * Create Time 2017年7月31日
 * Create by name：liujie -- email: liujie@lljqiu.com
 * Copyright © 2015, 2017, www.lljqiu.com. All rights reserved.
 */
package com.lljqiu.tools.threadPool.job;

import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * ClassName: ThreadStackJob.java <br>
 * Description: 收集所有线程的堆栈信息并输出到文件。<br>
 * Create by: name：liujie <br>email: liujie@lljqiu.com <br>
 * Create Time: 2017年7月31日<br>
 */
public class ThreadStackJob extends AbstractJob {

    private static Logger _logger = LoggerFactory.getLogger(ThreadStackJob.class);
    
    private String _lineSeparator = System.getProperty("line.separator");;
    /** 线程堆栈缓冲区初始大小 */
    private final static int BUFFER_SIZE = 4096;
    
    public ThreadStackJob(int interval) {
        super._interval = interval;
    }
    
    @Override
    protected void execute() {
        Map<Thread, StackTraceElement[]> stackMap = Thread.getAllStackTraces();
        for (Entry<Thread, StackTraceElement[]> entry : stackMap.entrySet()) {
            // 线程基本信息
            Thread thread = entry.getKey();
            StringBuilder buffer = new StringBuilder(BUFFER_SIZE)
                .append("name:").append(thread.getName())
                .append(", id:").append(thread.getId())
                .append(", status:").append(thread.getState().toString())
                .append(", priority:").append(thread.getPriority())
                .append(_lineSeparator);
            
            // 线程堆栈
            StackTraceElement[] stackList = entry.getValue();
            for (StackTraceElement ste : stackList) {
                buffer.append(ste.toString())
                    .append(_lineSeparator);
            }
            
            _logger.info(buffer.toString());
        }
        
        super.sleep();
    }

}
