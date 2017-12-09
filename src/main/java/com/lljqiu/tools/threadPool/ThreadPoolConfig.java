/**
 * Project Name threadPool
 * File Name package-info.java
 * Package Name com.lljqiu.tools.threadPool
 * Create Time 2017年7月31日
 * Create by name：liujie -- email: liujie@lljqiu.com
 * Copyright © 2015, 2017, www.lljqiu.com. All rights reserved.
 */
package com.lljqiu.tools.threadPool;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lljqiu.tools.threadPool.stack.ThreadPoolInfo;

/** 
 * ClassName: ThreadPoolConfig.java <br>
 * Description: 从配置文件读取配置信息并存储在内存中。<br>
 * Create by: name：liujie <br>email: liujie@lljqiu.com <br>
 * Create Time: 2017年7月31日<br>
 */
public class ThreadPoolConfig implements ThreadLiftCycle {
    protected String _configFile = ThreadPoolConfigCache.getInstance().getConfigFile();
    /**
     * key为线程池名称，value为{@link ThreadPoolInfo}实例。
     */
    protected Map<String, ThreadPoolInfo> _multiThreadPoolInfo = new HashMap<String, ThreadPoolInfo>();
    
    /** 线程池状态收集开关 */
    protected boolean _threadPoolStateSwitch = false;
    protected int _threadPoolStateInterval = 60;   // 单位：秒
    
    /** 线程状态收集开关 */
    protected boolean _threadStateSwitch = false;
    protected int _threadStateInterval = 60;   // 单位：秒
    
    /** 线程堆栈收集开关 */
    protected boolean _threadStackSwitch = false;
    protected int _threadStackInterval = 60;   // 单位：秒
    
    protected String threadpoolstate = "threadpoolstate";
    protected String threadstate = "threadstate";
    protected String threadstack = "threadstack";
    
    @Override
    public void init() {
        initConfig();
    }
    
    private void initConfig() {
        JSONArray poolConfig = getPoolConfig();
        for (int i = 0; i < poolConfig.size(); i++) {
            cachePoolConfigInfo((JSONObject) poolConfig.get(i));
        }
        _threadPoolStateSwitch = computeSwitchValue(threadpoolstate);
        _threadPoolStateInterval = computeIntervalValue(threadpoolstate);
        _threadStateSwitch = computeSwitchValue(threadstate);
        _threadStateInterval = computeIntervalValue(threadstate);
        _threadStackSwitch = computeSwitchValue(threadstack);
        _threadStackInterval = computeIntervalValue(threadstack);
    }
    
    /** 
     * Description：缓存线程池配置
     * @param object
     * @return void
     * @author name：liujie <br>email: liujie@lljqiu.com
     **/
    private void cachePoolConfigInfo(JSONObject object){
        ThreadPoolInfo info = new ThreadPoolInfo();
        String poolName = object.getString("name");
        JSONObject threadConfig = (JSONObject) object.get("config");
        info.setName(poolName);
        info.setCoreSize(threadConfig.getIntValue("corePoolSize"));
        info.setMaxSize(threadConfig.getIntValue("maxPoolSize"));
        info.setThreadKeepAliveTime(threadConfig.getIntValue("keepAliveTime"));
        info.setQueueSize(threadConfig.getIntValue("workQueueSize"));
        _multiThreadPoolInfo.put(info.getName(), info);
    }
    
    /** 
     * Description：获取线程池配置
     * @return
     * @return JSONArray
     * @author name：liujie <br>email: liujie@lljqiu.com
     **/
    private JSONArray getPoolConfig(){
        String poolConfig = (String) ReadPropertiesUtil.get("threadpool");
        JSONArray jsonArray = JSONArray.parseArray(poolConfig);
        return jsonArray;
    }
    public static void main(String[] args) {
        
    }
    
    private boolean computeSwitchValue(String type) {
        boolean flag = false;
        switch (type) {
            case "threadpoolstate":
                flag = ThreadPoolConfigCache.getInstance().isThreadPoolStateSwitch();
                break;
            case "threadstack":
                flag = ThreadPoolConfigCache.getInstance().isThreadStackSwitch();
                break;
            case "threadstate":
                flag = ThreadPoolConfigCache.getInstance().isThreadStateSwitch();
                break;
        }
        return flag;
    }
    
    private int computeIntervalValue(String type) {
        int _interval = 60;
        switch (type) {
            case "threadpoolstate":
                _interval = ThreadPoolConfigCache.getInstance().getThreadPoolStateInterval();
                break;
            case "threadstack":
                _interval = ThreadPoolConfigCache.getInstance().getThreadStackInterval();
                break;
            case "threadstate":
                _interval = ThreadPoolConfigCache.getInstance().getThreadStateInterval();
                break;
        }
        return _interval;
    }
    
    /**
     * 指定名称的线程池的配置是否存在。
     * 
     * @return 如果指定名称的线程池的配置存在返回true，如果不存在返回false；如果传入的线程池名称为null也返回false。
     */
    public boolean containsPool(String poolName) {
        if (null == poolName || null == _multiThreadPoolInfo || _multiThreadPoolInfo.isEmpty()) {
            return false;
        }
        
        return _multiThreadPoolInfo.containsKey(poolName);
    }
    
    /**
     * 获取指定线程池的配置信息。
     * 
     * @param threadpoolName 线程池名称
     * @return 线程池配置信息（{@link ThreadPoolInfo}）
     */
    public ThreadPoolInfo getThreadPoolConfig(String threadpoolName) {
        return _multiThreadPoolInfo.get(threadpoolName);
    }
    
    /**
     * 获取所有线程池的配置信息。
     * 
     * @return 线程池配置信息（{@link ThreadPoolInfo}）集合
     */
    public Collection<ThreadPoolInfo> getThreadPoolConfig() {
        return _multiThreadPoolInfo.values();
    }
    
    /**
     * @return 输出各个线程池状态信息的开关，true表示开，false表示关
     */
    public boolean getThreadPoolStateSwitch() {
        return _threadPoolStateSwitch;
    }
    
    /**
     * @return 线程池状态信息输出的间隔时间（单位：秒）
     */
    public int getThreadPoolStateInterval() {
        return _threadPoolStateInterval;
    }
    
    /**
     * @return 输出各个线程组中线程状态信息的开关，true表示开，false表示关
     */
    public boolean getThreadStateSwitch() {
        return _threadStateSwitch;
    }
    
    /**
     * @return 线程状态信息输出的间隔时间（单位：秒）
     */
    public int getThreadStateInterval() {
        return _threadStateInterval;
    }
    
    /**
     * @return 输出所有线程堆栈的开关，true表示开，false表示关
     */
    public boolean getThreadStackSwitch() {
        return _threadStackSwitch;
    }
    
    /**
     * @return 线程堆栈信息输出的间隔时间（单位：秒）
     */
    public int getThreadStackInterval() {
        return _threadStackInterval;
    }
    
    @Override
    public void destroy() {
        _threadPoolStateSwitch = false;
        _threadStateSwitch = false;
        _multiThreadPoolInfo.clear();
    }

}
