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
 * ClassName: FailHandler.java <br>
 * Description: 当队列满，异步任务无法提交给线程池执行的"失败处理器"。<br>
 * Create by: name: liujie <br> email: liujie@lljqiu.com <br>
 * Create Time: 2017年7月31日<br>
 */
public interface FailHandler<T> {

    /** 
     * Description：处理无法提交线程池执行的异步任务。
     * @param task 无法提交线程池执行的异步任务
     * @return void
     * @author name：liujie <br>email: liujie@lljqiu.com
     **/
    public void execute(T task);

}
