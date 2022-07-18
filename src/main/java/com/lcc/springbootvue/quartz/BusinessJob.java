package com.lcc.springbootvue.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author lichaochao
 * @data 2022/5/16 3:48 PM
 **/
@Slf4j
public class BusinessJob implements Job {
        int i =0;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("BusinessJob implements Job。。。。。。。。。。");
        Object   obh = jobExecutionContext;
        String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
        System.out.println("PrintWordsJob start at:" + printTime + ", prints: Hello Job-" + new Random().nextInt(100));
    }
    public void business(String time) {
        i++;
        log.info("time:{},threadName:{},i:{}", time, Thread.currentThread().getName(), i);
    }
}
