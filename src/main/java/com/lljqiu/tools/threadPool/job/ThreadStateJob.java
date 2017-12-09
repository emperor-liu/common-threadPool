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

import com.lljqiu.tools.threadPool.ThreadUtil;
import com.lljqiu.tools.threadPool.stack.ThreadStateInfo;

/** 
 * ClassName: ThreadStateJob.java <br>
 * Description: 收集所有线程组中所有线程的状态信息，统计并输出汇总信息。<br>
 * Create by: name：liujie <br>email: liujie@lljqiu.com <br>
 * Create Time: 2017年7月31日<br>
 */
public class ThreadStateJob extends AbstractJob {

    private static Logger _logger = LoggerFactory.getLogger(ThreadStateJob.class);
    
    public ThreadStateJob(int interval) {
        super._interval = interval;
    }

    @Override
    protected void execute() {
        Map<String, ThreadStateInfo> statMap = ThreadUtil.statAllGroupThreadState();
        
        for (Entry<String, ThreadStateInfo> entry : statMap.entrySet()) {
            ThreadStateInfo stateInfo = entry.getValue();
            _logger.info("ThreadGroup:{}, New:{},  Runnable:{}, Blocked:{}, Waiting:{}, TimedWaiting:{}, Terminated:{}", 
                    entry.getKey(), stateInfo.getNewCount(), stateInfo.getRunnableCount(), stateInfo.getBlockedCount(),
                    stateInfo.getWaitingCount(), stateInfo.getTimedWaitingCount(), stateInfo.getTerminatedCount());
        }
        
        super.sleep();
    } // end of execute

}
