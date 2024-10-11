package com.cn.javaLearn.thread.threadPool;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: javaLearn
 * @description: 固定大小线程池
 * @author: liyan
 * @create: 2024-06-19 23:02
 **/
public class FixedPool {

    public static final int THREAD_COUNT = 10;


    /**
     * 线程池调用接口
     */
    public void batchCallApi(List<Object> paramList) throws Exception {
        int threadCount = THREAD_COUNT; // 线程数
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Callable<Map<String, Object>>> callableList = new ArrayList<>();

        // 获取次数
        int len = paramList.size() / threadCount;
        if (len == 0) {
            threadCount = paramList.size();
            len = paramList.size() / threadCount;

        }

        // 循环添加任务
        for (int i = 0; i < len; i++) {
            // 获取每次发送的参数
            List<Object> param = paramList.subList(i * threadCount, (i + 1) * threadCount);
            // 添加任务
            callableList.add(new Callable<Map<String, Object>>() {
                @Override
                public Map<String, Object> call() throws Exception {
                    System.out.println("线程池调用接口");
                    Map<String, Object> map = callApi(param); // 回调参数
                    return map;
                }
            });
        }

        StringBuffer sb = new StringBuffer();
        // 接受 callable的返回对象
        List<Future<Map<String, Object>>> futureList = executorService.invokeAll(callableList);
        for (Future<Map<String, Object>> future : futureList) {
            Map<String, Object> map = future.get(); //返回参数
            sb.append(map.get("errCode"));
            sb.append(map.get("errorMessage"));
        }

        // 关闭线程池
        executorService.shutdown();


    }

    /**
     * 模拟调用接口
     *
     * @param paramList
     * @return
     */
    private Map<String, Object> callApi(List<Object> paramList) {

        Map<String, Object> map = new HashMap<>();

        String result = ""; // 模拟调用接口

        if (StringUtils.isEmpty(result)) {
            map.put("errCode", "0000");
            map.put("errorMessage", "调用失败");
        } else {
            map = (Map<String, Object>) JSON.parse(result);
        }

        return map;
    }

}
