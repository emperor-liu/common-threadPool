/**
 * Project Name threadPool
 * File Name package-info.java
 * Package Name com.lljqiu.tools.threadPool
 * Create Time 2017年7月31日
 * Create by name：liujie -- email: liujie@lljqiu.com
 * Copyright © 2015, 2017, www.lljqiu.com. All rights reserved.
 */
package com.lljqiu.tools.threadPool;

import java.util.HashMap;
import java.util.Map;

import com.lljqiu.tools.threadPool.stack.ThreadStateInfo;

/** 
 * ClassName: ThreadUtil.java <br>
 * Description: 线程操作工具类<br>
 * Create by: name：liujie <br>email: liujie@lljqiu.com <br>
 * Create Time: 2017年7月31日<br>
 */
public class ThreadUtil {

    /**
     * 获取当前线程的Top Level线程组。
     * 
     * @return Top Level线程组。
     */
    public static ThreadGroup getRootThreadGroup() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (null != threadGroup.getParent()) {
            threadGroup = threadGroup.getParent();
        }
        
        return threadGroup;
    }

    public static Map<String, ThreadStateInfo> statAllGroupThreadState() {
        ThreadGroup root = ThreadUtil.getRootThreadGroup();
        int groupCapacity = root.activeGroupCount() * 2;
        ThreadGroup[] groupList = new ThreadGroup[groupCapacity];
        int groupNum = root.enumerate(groupList, true);
        
        Map<String, ThreadStateInfo> stateInfoList = new HashMap<String, ThreadStateInfo>();
        stateInfoList.put(root.getName(), statSingleGroupThreadState(root));
        for (int i = 0; i <groupNum; i++) {
            ThreadGroup threadGroup = groupList[i];
            ThreadStateInfo stateInfo = statSingleGroupThreadState(threadGroup);
            stateInfoList.put(threadGroup.getName(), stateInfo);
        }
        
        return stateInfoList;
    }
    
    /**
     * 收集指定线程组{@link ThreadGroup}中所有线程的状态信息。
     * 
     * @param threadGroup 线程组实例
     * @return {@link ThreadStateInfo}实例
     */
    public static ThreadStateInfo statSingleGroupThreadState(ThreadGroup threadGroup) {
        if (null == threadGroup) {
            throw new IllegalArgumentException("threadGroup is null");
        }
        
        int threadCapacity = threadGroup.activeCount() * 2;
        Thread[] threadList = new Thread[threadCapacity];
        int threadNum = threadGroup.enumerate(threadList);
        
        ThreadStateInfo stateInfo = new ThreadStateInfo();
        for (int j = 0; j < threadNum; j++) {
            Thread thread = threadList[j];
            switch (thread.getState()) {
                case NEW:
                    stateInfo.setNewCount(stateInfo.getNewCount() + 1);
                    break;
                case RUNNABLE:   
                    stateInfo.setRunnableCount(stateInfo.getRunnableCount() + 1);
                    break;
                case BLOCKED:   
                    stateInfo.setBlockedCount(stateInfo.getBlockedCount() + 1);
                    break;
                case WAITING:   
                    stateInfo.setWaitingCount(stateInfo.getWaitingCount() + 1);
                    break;
                case TIMED_WAITING:   
                    stateInfo.setTimedWaitingCount(stateInfo.getTimedWaitingCount() + 1);
                    break;
                case TERMINATED:   
                    stateInfo.setTerminatedCount(stateInfo.getTerminatedCount() + 1);
                    break;
                default:
                    // nothing
                    break;
            }
        }
        
        return stateInfo;
    }

}
