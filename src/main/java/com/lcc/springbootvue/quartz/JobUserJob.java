package com.lcc.springbootvue.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author lichaochao
 * @data 2022/7/6 9:26 PM
 **/
@Slf4j
public class JobUserJob   implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("userJob被执行了。。。。。。。");
    }
}
