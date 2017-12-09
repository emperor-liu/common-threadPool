/**
 * Project Name threadPool
 * File Name package-info.java
 * Package Name com.lljqiu.tools.threadPool.stack
 * Create Time 2017年7月31日
 * Create by name：liujie -- email: liujie@lljqiu.com
 * Copyright © 2015, 2017, www.lljqiu.com. All rights reserved.
 */
package com.lljqiu.tools.threadPool.stack;

/** 
 * ClassName: ThreadPoolStatus.java <br>
 * Description: 线程池状态。<br>
 * Create by: name：liujie <br>email: liujie@lljqiu.com <br>
 * Create Time: 2017年7月31日<br>
 */
public class ThreadPoolStatus {

    /** 未初始化 */
    public final static int UNINITIALIZED = 0;;
    
    /** 初始化成功 */
    public final static int INITIALITION_SUCCESSFUL = 1;
    
    /** 初始化失败 */
    public final static int INITIALITION_FAILED = 2;
    
    /** 已销毁 */
    public final static int DESTROYED = 3;

}
