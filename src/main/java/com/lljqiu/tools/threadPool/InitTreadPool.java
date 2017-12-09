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
 * ClassName: InitTreadPool.java <br>
 * Description: 应用启动时--初始化线程池<br>
 * Create by: name：liujie <br>email: liujie@lljqiu.com <br>
 * Create Time: 2017年6月9日<br>
 */
public class InitTreadPool {
    protected ThreadPoolManager tpm;
    protected ThreadPool threadPool;
   /* static{
        threadPool = tpm.getThreadPool();
        tpm.init(); // 在应用启动时调用
    }*/
    
    public InitTreadPool(ThreadPoolConfigInit threadPoolConfigInit){
        ThreadPoolConfigCache.setInstance(threadPoolConfigInit);
        tpm = ThreadPoolManager.getSingleton();
        threadPool = tpm.getThreadPool();
        tpm.init(); // 在应用启动时调用
    }
}
