/**
 * Project Name threadPool
 * File Name package-info.java
 * Package Name com.lljqiu.tools.threadPool
 * Create Time 2017年7月31日
 * Create by name：liujie -- email: liujie@lljqiu.com
 * Copyright © 2015, 2017, www.lljqiu.com. All rights reserved.
 */
package com.lljqiu.tools.threadPool;

import com.alibaba.fastjson.JSONArray;

/** 
 * ClassName: ThreadPoolConfigCache.java <br>
 * Description: 单例-缓存线程池配置<br>
 * Create by: name：liujie <br>email: liujie@lljqiu.com <br>
 * Create Time: 2017年7月31日<br>
 */
public class ThreadPoolConfigCache {

    private static ThreadPoolConfigCache instance;
    private  ThreadPoolConfigInit       threadPoolConfigInit;

    public ThreadPoolConfigCache(ThreadPoolConfigInit threadPoolConfigInit) {
        try {
            this.threadPoolConfigInit = threadPoolConfigInit;
        } catch (Exception e) {
            this.threadPoolConfigInit = null;
        }
    }

    /** 
     * Description：获取线程池配置
     * @return
     * @return ThreadPoolConfigCache
     * @author name：liujie <br>email: liujie@lljqiu.com
     **/
    public synchronized static ThreadPoolConfigCache getInstance() {
        if (instance == null) {
            throw new RuntimeException("ThreadPoolConfigInit is error");
        }
        return instance;
    }
    public synchronized static void setInstance(ThreadPoolConfigInit threadPoolConfigInit) {
        instance = new ThreadPoolConfigCache(threadPoolConfigInit);
    }

    /** 
     * Description：获取线程池个数
     * @return String 使用者配置的线程池
     * @author name：liujie <br>email: liujie@lljqiu.com
     **/
    public JSONArray getThreadPool() {
        String poolConfig = (String) ReadPropertiesUtil.get("threadpool");
        JSONArray jsonArray = JSONArray.parseArray(poolConfig);
        return jsonArray;
    }

    public String getConfigFile() {
        return this.threadPoolConfigInit.getConfigFile();
    }

    public boolean isThreadPoolStateSwitch() {
        return this.threadPoolConfigInit.isThreadPoolStateSwitch();
    }

    public int getThreadPoolStateInterval() {
        return this.threadPoolConfigInit.getThreadPoolStateInterval();
    }

    public boolean isThreadStateSwitch() {
        return this.threadPoolConfigInit.isThreadStateSwitch();
    }

    public int getThreadStateInterval() {
        return this.threadPoolConfigInit.getThreadStateInterval();
    }

    public boolean isThreadStackSwitch() {
        return this.threadPoolConfigInit.isThreadStackSwitch();
    }

    public int getThreadStackInterval() {
        return this.threadPoolConfigInit.getThreadStackInterval();
    }

}
