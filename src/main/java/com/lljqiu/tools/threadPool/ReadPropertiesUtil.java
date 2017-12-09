/**
 * Project Name threadPool
 * File Name package-info.java
 * Package Name com.lljqiu.tools.threadPool
 * Create Time 2017年7月31日
 * Create by name：liujie -- email: liujie@lljqiu.com
 * Copyright © 2015, 2017, www.lljqiu.com. All rights reserved.
 */
package com.lljqiu.tools.threadPool;

import java.io.InputStream;
import java.util.Properties;

/** 
 * ClassName: ReadPropertiesUtil.java <br>
 * Description: 读取配置文件 (.Properties)<br>
 * Create by: name：liujie <br>email: liujie@lljqiu.com <br>
 * Create Time: 2017年7月31日<br>
 */
public class ReadPropertiesUtil {

    private static Properties p = null;

    /** 
    * Description：
    *   获取properties 中的值
    *   <pre>
    *       key 是properties  所对应的键
    *       返回，根据key获取的值
    *   </pre>
    * @author liujie
     **/
    public static Object get(String key) {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(ThreadPoolConfigCache.getInstance().getConfigFile());
            p = new Properties();
            p.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p.getProperty(key);
    }

}
