//package com.lcc.springbootvue.controller;
//
//import com.lcc.springbootvue.service.async.AsyncService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.concurrent.Future;
//
///**
// * @author lichaochao
// * @data 2022/6/18 5:08 PM
// * 异步测试接口
// **/
//@RestController
//@RequestMapping("/api")
//public class AsyncController {
//
//    @Autowired
//    private AsyncService asyncService;
//
//    @RequestMapping("/test")
//    public Boolean testTask(@RequestBody String str){
//
//        long begin = System.currentTimeMillis();
//
//        Future<String> task1 = asyncService.task1( str);
//
//        /**
//         *如果需要监控异步任务是否完成，可以使用以下方式
//         **/
//        //如果都执行完成就可以跳出循环,isDone方法如果此任务完成，true
//        while(true){
//            if (task1.isDone()) {
//                break;
//            }
//        }
//
//
//        long end = System.currentTimeMillis();
//        long total = end-begin;
//        System.out.println("执行总耗时="+total);
//        return true;
//    }
//}
