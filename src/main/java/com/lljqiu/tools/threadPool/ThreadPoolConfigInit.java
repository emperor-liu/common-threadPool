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
 * ClassName: ThreadPoolConfigInit.java <br>
 * Description: 配置线程池<br>
 * Create by: name：liujie <br>email: liujie@lljqiu.com <br>
 * Create Time: 2017年7月31日<br>
 */
public class ThreadPoolConfigInit {
    private String  configFile = "config/threadPool.properties";
    /** 线程池状态收集开关 */
    private boolean threadPoolStateSwitch   = false;
    private int     threadPoolStateInterval = 60;   // 单位：秒

    /** 线程状态收集开关 */
    private boolean threadStateSwitch       = false;
    private int     threadStateInterval     = 60;   // 单位：秒

    /** 线程堆栈收集开关 */
    private boolean threadStackSwitch       = false;
    private int     threadStackInterval     = 60;   // 单位：秒

    public ThreadPoolConfigInit() {
        super();
    }
    
    /**
     * @param configFile 线程池配置文件
     * @param threadPoolStateSwitch 线程池状态收集开关
     * @param threadPoolStateInterval 线程池状态收集间隔时间 单位：s
     * @param threadStateSwitch 线程状态收集开关 
     * @param threadStateInterval  线程状态收集间隔时间  单位：s
     * @param threadStackSwitch 线程堆栈收集开关
     * @param threadStackInterval  线程堆栈收集间隔时间   单位：s 
     */
    public ThreadPoolConfigInit(String configFile, boolean threadPoolStateSwitch,
                                int threadPoolStateInterval, boolean threadStateSwitch,
                                int threadStateInterval, boolean threadStackSwitch,
                                int threadStackInterval) {
        super();
        this.configFile = configFile;
        this.threadPoolStateSwitch = threadPoolStateSwitch;
        this.threadPoolStateInterval = threadPoolStateInterval;
        this.threadStateSwitch = threadStateSwitch;
        this.threadStateInterval = threadStateInterval;
        this.threadStackSwitch = threadStackSwitch;
        this.threadStackInterval = threadStackInterval;
    }

    /**
     * @return the configFile
     */
    public String getConfigFile() {
        return configFile;
    }

    /**
     * 线程池的配置文件
     * Thread.currentThread().getContextClassLoader().getResourceAsStream(getConfigFile());
     * @param configFile the configFile to set
     */
    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }

    /**
     * @return the threadPoolStateSwitch
     */
    public boolean isThreadPoolStateSwitch() {
        return threadPoolStateSwitch;
    }

    /**
     * @param threadPoolStateSwitch the threadPoolStateSwitch to set
     */
    public void setThreadPoolStateSwitch(boolean threadPoolStateSwitch) {
        this.threadPoolStateSwitch = threadPoolStateSwitch;
    }

    /**
     * @return the threadPoolStateInterval
     */
    public int getThreadPoolStateInterval() {
        return threadPoolStateInterval;
    }

    /**
     * @param threadPoolStateInterval the threadPoolStateInterval to set
     */
    public void setThreadPoolStateInterval(int threadPoolStateInterval) {
        this.threadPoolStateInterval = threadPoolStateInterval;
    }

    /**
     * @return the threadStateSwitch
     */
    public boolean isThreadStateSwitch() {
        return threadStateSwitch;
    }

    /**
     * @param threadStateSwitch the threadStateSwitch to set
     */
    public void setThreadStateSwitch(boolean threadStateSwitch) {
        this.threadStateSwitch = threadStateSwitch;
    }

    /**
     * @return the threadStateInterval
     */
    public int getThreadStateInterval() {
        return threadStateInterval;
    }

    /**
     * @param threadStateInterval the threadStateInterval to set
     */
    public void setThreadStateInterval(int threadStateInterval) {
        this.threadStateInterval = threadStateInterval;
    }

    /**
     * @return the threadStackSwitch
     */
    public boolean isThreadStackSwitch() {
        return threadStackSwitch;
    }

    /**
     * @param threadStackSwitch the threadStackSwitch to set
     */
    public void setThreadStackSwitch(boolean threadStackSwitch) {
        this.threadStackSwitch = threadStackSwitch;
    }

    /**
     * @return the threadStackInterval
     */
    public int getThreadStackInterval() {
        return threadStackInterval;
    }

    /**
     * @param threadStackInterval the threadStackInterval to set
     */
    public void setThreadStackInterval(int threadStackInterval) {
        this.threadStackInterval = threadStackInterval;
    }

}
