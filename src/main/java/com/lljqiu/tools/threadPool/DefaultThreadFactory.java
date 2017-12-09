/**
 * Project Name threadPool
 * File Name package-info.java
 * Package Name com.lljqiu.tools.threadPool
 * Create Time 2017年7月31日
 * Create by name：liujie -- email: liujie@lljqiu.com
 * Copyright © 2015, 2017, www.lljqiu.com. All rights reserved.
 */
package com.lljqiu.tools.threadPool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/** 
 * ClassName: DefaultThreadFactory.java <br>
 * Description: 线程池工厂<br>
 * Create by: name：liujie <br>email: iujie@lljqiu.com <br>
 * Create Time: 2017年7月31日<br>
 */
public class DefaultThreadFactory implements ThreadFactory {

    private AtomicLong          _count;
    private static final String DEFAULT_THREAD_NAME_PRIFIX = "lljqiu-thread";
    private ThreadGroup         _group;
    private String              _threadNamePrefix;

    public DefaultThreadFactory() {
        this("aofeng-thread");
    }

    public DefaultThreadFactory(String threadNamePrefix) {
        this._count = new AtomicLong(1L);

        this._threadNamePrefix = DEFAULT_THREAD_NAME_PRIFIX;

        this._threadNamePrefix = threadNamePrefix;
        ThreadGroup root = getRootThreadGroup();
        this._group = new ThreadGroup(root, this._threadNamePrefix);
    }

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(this._group, r);
        thread.setName(this._threadNamePrefix + "-" + this._count.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (5 != thread.getPriority()) {
            thread.setPriority(5);
        }

        return thread;
    }

    private ThreadGroup getRootThreadGroup() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (null != threadGroup.getParent()) {
            threadGroup = threadGroup.getParent();
        }

        return threadGroup;
    }


}
