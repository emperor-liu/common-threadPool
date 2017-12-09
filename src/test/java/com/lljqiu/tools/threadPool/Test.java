package com.lljqiu.tools.threadPool;


/**
 * Unit test for simple App.
 */
public class Test {
  
    public static void main(String[] args) {
        ThreadPoolConfigInit threadPoolConfigInit = new ThreadPoolConfigInit();
        threadPoolConfigInit.setConfigFile("config/threadpool.properties");
        //以下几项不建议打开
        threadPoolConfigInit.setThreadPoolStateInterval(60);
        threadPoolConfigInit.setThreadPoolStateSwitch(true);
        threadPoolConfigInit.setThreadStackInterval(60);
        threadPoolConfigInit.setThreadStackSwitch(true);
        threadPoolConfigInit.setThreadStateInterval(60);
        threadPoolConfigInit.setThreadStateSwitch(true);
        //结束
//        ThreadPoolConfigCache.setInstance(threadPoolConfigInit);
        InitTreadPool initTreadPool = new InitTreadPool(threadPoolConfigInit);
        ThreadPool threadPool = initTreadPool.threadPool;
        TestTask testTask = new TestTask(threadPool,"test start");
        //不需要返回值的 给默认线程池执行的
        threadPool.submit(testTask);
        //不需要返回值的 给指定线程池执行的
        threadPool.submit(testTask,"zhiding");
    }
}
// 下面方法带有返回
//public class CallableAnsyTask implements Callable<Long> {
//
//    private int[] _arr;
//    
//    public CallableAnsyTask(int[] arr) {
//        _arr = arr;
//    }
//    
//    @Override
//    public Long call() throws Exception {
//        long result = 0;
//        for (int i = 0; i < _arr.length; i++) {
//            result += _arr[i];
//        }
//        
//        return result;
//    }
//}
//ThreadPoolManager tpm = ThreadPoolManager.getSingleton();
//ThreadPool threadPool = tpm.getThreadPool();
//
//int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//CallableAnsyTask task = new CallableAnsyTask(arr);
//
//// 将异步任务交给默认的线程池default执行
//Future<Long> future = threadPool.submit(task);
//System.out.println("异步任务在线程池default的执行结果为:"+future.get());
//  
//// 将异步任务交给指定的线程池other执行
//threadPool.submit(task, "other");
//System.out.println("异步任务在线程池other的执行结果为:"+future.get());


//TODO 并行调用多个
//public class CallableAnsyTask implements Callable<Long> {
//    private int[] _arr;
//     
//    public CallableAnsyTask(int[] arr) {
//        _arr = arr;
//    }
//     
//    @Override
//    public Long call() throws Exception {
//        long result = 0;
//        for (int i = 0; i < _arr.length; i++) {
//            result += _arr[i];
//        }
//         
//        return result;
//    }
//}
//创建多个异步任务
//int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//List<Callable<Long>> tasks = new ArrayList<Callable<Long>>();
//tasks.add(new CallableAnsyTask(arr));
//tasks.add(new CallableAnsyTask(arr));
//tasks.add(new CallableAnsyTask(arr));
//
////并行调用多个异步任务
//ThreadPoolManager tpm = ThreadPoolManager.getSingleton();
//ThreadPool threadPool = tpm.getThreadPool();
//List<Future<Long>> futures = threadPool.invokeAll(tasks, 1, TimeUnit.SECONDS);
//for (Future<Long> future : futures) {
// Long result = future.get();   // 如果某个任务执行超时，调用该任务对应的future.get时抛出CancellationException异常
// System.out.println("并行调用，其中一个任务的执行结果为:"+result);
//}