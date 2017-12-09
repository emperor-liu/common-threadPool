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
 * ClassName: ThreadLiftCycle.java <br>
 * Description: 线程生命周期<br>
 * Create by: name：liujie <br>email: liujie@lljqiu.com <br>
 * Create Time: 2017年7月31日<br>
 */
public abstract interface ThreadLiftCycle {
    
    public abstract void init();

    public abstract void destroy();
}
