/**
 * Project Name threadPool
 * File Name package-info.java
 * Package Name com.lljqiu.tools.threadPool
 * Create Time 2017年7月31日
 * Create by name：liujie -- email: liujie@lljqiu.com
 * Copyright © 2015, 2017, www.lljqiu.com. All rights reserved.
 */
package com.lljqiu.tools.threadPool;

/** 
 * ClassName: ThreadPoolManager.java <br>
 * Description: 线程池实例管理。<br>
 * Create by: name：liujie <br>email: liujie@lljqiu.com <br>
 * Create Time: 2017年7月31日<br>
 */
public class ThreadPoolManager implements ThreadLiftCycle {

    private ThreadLiftCycle _threadPool = new ThreadPoolImpl(); 
    
    private static Object _lock = new Object();
    private boolean _initStatus = false;
    private boolean _destroyStatus = false;
    
    private static ThreadPoolManager _instance = new ThreadPoolManager();
    public static ThreadPoolManager getSingleton() {
        return _instance;
    }

    public ThreadPool getThreadPool() {
        return (ThreadPool) _threadPool;
    }
    
    // 用于单元测试和子类扩展
    protected void setThreadPool(ThreadPool threadPool) {
        this._threadPool = (ThreadLiftCycle) threadPool;
    }
    
    @Override
    public void init() {
        synchronized (_lock) {
            if (_initStatus) {
                return;
            }
            _threadPool.init();
            _initStatus = true;
        }
    }

    @Override
    public void destroy() {
        synchronized (_lock) {
            if (_destroyStatus) {
                return;
            }
            _threadPool.destroy();
            _destroyStatus = true;
        }
    }

}
