/**
 * Project Name threadPool
 * File Name package-info.java
 * Package Name com.lljqiu.tools.threadPool.handler
 * Create Time 2017年7月31日
 * Create by name：liujie -- email: liujie@lljqiu.com
 * Copyright © 2015, 2017, www.lljqiu.com. All rights reserved.
 */
package com.lljqiu.tools.threadPool.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lljqiu.tools.threadPool.FailHandler;

/** 
 * ClassName: LogErrorFailHandler.java <br>
 * Description: 当队列满，异步任务无法提交给线程池执行时，输出一条错误日志记录处理失败的任务信息。<br>
 * Create by: name：liujie <br>email: liujie@lljqiu.com <br>
 * Create Time: 2017年7月31日<br>
 */
public class LogErrorFailHandler implements FailHandler<Object> {

    private static Logger _logger = LoggerFactory.getLogger(LogErrorFailHandler.class);  
    
    /* (non-Javadoc)
     * @see com.lljqiu.tools.threadPool.FailHandler#execute(java.lang.Object)
     */
    @Override
    public void execute(Object task) {
        _logger.error("queue is full, a task cannot be submit to threadpool, task information:{}", task);
    }

}
