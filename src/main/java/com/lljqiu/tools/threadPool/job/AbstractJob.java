/**
 * Project Name threadPool
 * File Name package-info.java
 * Package Name com.lljqiu.tools.threadPool.job
 * Create Time 2017年7月31日
 * Create by name：liujie -- email: liujie@lljqiu.com
 * Copyright © 2015, 2017, www.lljqiu.com. All rights reserved.
 */
package com.lljqiu.tools.threadPool.job;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

import com.lljqiu.tools.threadPool.ThreadLiftCycle;

/** 
 * ClassName: AbstractJob.java <br>
 * Description: 抽象job类。<br>
 * Create by: name：liujie <br>email: liujie@lljqiu.com <br>
 * Create Time: 2017年7月31日<br>
 */
public abstract class AbstractJob implements Runnable ,ThreadLiftCycle{

    protected String _lineSeparator = System.getProperty("line.separator"); 
    
    /** 运行状态：true表示正在运行；false表示已停止 */
    protected volatile AtomicBoolean _run = new AtomicBoolean(true);
    
    /** 线程休眠时间（单位：秒） */
    protected int _interval = 60;

    @Override
    public void init() {
        _run.set(true);
    }

    @Override
    public void run() {
        while (_run.get()) {
            execute();
        }
    }
    
    protected abstract void execute();
    
    /**
     * 休眠<code>_interval</code>指定的时间。
     */
    protected void sleep() {
        try {
            Thread.sleep(_interval * 1000);
        } catch (InterruptedException e) {
            // nothing
        }
    }
    
    /**
     * @return 返回"yyyy-MM-dd HH:mm:ss"格式的当前日期时间字符串
     */
    protected String currentTime() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = Calendar.getInstance().getTime();
        
        return format.format(date);
    }
    
    @Override
    public void destroy() {
        _run.set(false);
    }

}
