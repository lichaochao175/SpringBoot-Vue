package com.lcc.springbootvue.service.async;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;

/**
 * @author lichaochao
 * @data 2022/6/18 5:02 PM
 **/
@Service
//@Async("myAsyncTask")
public interface AsyncService {
//    //获取异步结果
//    public Future<String> task1(String str){
//        long begin = System.currentTimeMillis();
//        try {
//            Thread.sleep(2000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Set<String> set= new HashSet<>();
//        set.add("1231");
//        set.add("1231");
////       log.info("======获取str的值：[{}]:",str);
//        long end = System.currentTimeMillis();
//        System.out.println("任务1耗时="+(end-begin));
//        return new AsyncResult<String>("任务1");
//    }
}
