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
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * ClassName: ThreadPoolStateJob.java <br>
 * Description: 收集所有线程池的状态信息，统计并输出汇总信息。<br>
 * Create by: name：liujie <br>email: liujie@lljqiu.com <br>
 * Create Time: 2017年7月31日<br>
 */
public class ThreadPoolStateJob extends AbstractJob {

    private static Logger _logger = LoggerFactory.getLogger(ThreadPoolStateJob.class);
    
    private Map<String, ExecutorService> _multiThreadPool;
    
    public ThreadPoolStateJob(Map<String, ExecutorService> multiThreadPool, int interval) {
        this._multiThreadPool = multiThreadPool;
        super._interval = interval;
    }
    
    @Override
    protected void execute() {
        Set<Entry<String, ExecutorService>> poolSet = _multiThreadPool.entrySet();
        for (Entry<String, ExecutorService> entry : poolSet) {
            ThreadPoolExecutor pool = (ThreadPoolExecutor) entry.getValue();
            _logger.info("ThreadPool:{}, ActiveThread:{}, TotalTask:{}, CompletedTask:{}, Queue:{}", 
                    entry.getKey(), pool.getActiveCount(), pool.getTaskCount(), pool.getCompletedTaskCount(), pool.getQueue().size());
        }
        
        super.sleep();
    }

}
