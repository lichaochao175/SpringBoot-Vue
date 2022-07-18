//package com.lcc.springbootvue.quartz;
//
//import org.quartz.JobDataMap;
//import org.quartz.JobDetail;
//import org.quartz.Trigger;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
//import org.springframework.scheduling.quartz.JobDetailFactoryBean;
//import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//
//import java.time.LocalDateTime;
//
///**
// * @author lichaochao
// * @data 2022/7/1 7:10 PM
// **/
//@Configuration
//public class QuartzConfig {
//
//    //配置任务，多例的业务bean，耦合业务类，需要实现Job接口
//    @Bean(name = "businessJobDetail")
//    public JobDetailFactoryBean businessJobDetail() {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
//        jobDetailFactoryBean.setJobClass(BusinessJob.class);
//        //将参数传给job
//        JobDataMap jobDataMap = new JobDataMap();
//        jobDataMap.put("time", localDateTime);
//        jobDetailFactoryBean.setJobDataAsMap(jobDataMap);
//        return jobDetailFactoryBean;
//    }
//
//
//    //配置任务，多例的业务bean，耦合业务类，需要实现Job接口
//    @Bean(name = "businessJobDetail2")
//    public JobDetailFactoryBean businessJobDetail2() {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
//        jobDetailFactoryBean.setJobClass(JobUserJob.class);
//        //将参数传给job
//        JobDataMap jobDataMap = new JobDataMap();
//        jobDataMap.put("time", localDateTime);
//        jobDetailFactoryBean.setJobDataAsMap(jobDataMap);
//        return jobDetailFactoryBean;
//    }
//
//
//    //配置任务，单例的业务bean
//    @Bean(name = "jobServiceBeanDetail")
//    public MethodInvokingJobDetailFactoryBean jobServiceBeanDetail(JobOrderService jobOrderService) {
//        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
//        //是否并发执行
//        jobDetail.setConcurrent(false);
//        //需要执行的实体bean
//        jobDetail.setTargetObject(jobOrderService);
//        //需要执行的方法
//        jobDetail.setTargetMethod("business");
//        return jobDetail;
//    }
//
//
//
//    //配置任务，单例的业务bean
//    @Bean(name = "jobServiceBeanDetail2")
//    public MethodInvokingJobDetailFactoryBean jobServiceBeanDetail2(JobUserService JobUserService) {
//        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
//        //是否并发执行
//        jobDetail.setConcurrent(false);
//        //需要执行的实体bean
//        jobDetail.setTargetObject(JobUserService);
//        //需要执行的方法
//        jobDetail.setTargetMethod("userJob");
//        return jobDetail;
//    }
//
//    //配置cron触发器  第一个
//    @Bean(name = "cronTrigger")
//    public CronTriggerFactoryBean cronTrigger(JobDetail jobServiceBeanDetail) {//目标任务jobServiceBeanDetail
//        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
//        triggerFactoryBean.setJobDetail(jobServiceBeanDetail);
//        //每隔6s执行一次
//        triggerFactoryBean.setCronExpression("* * 3 * * ?");
//        return triggerFactoryBean;
//    }
//
//
//    //配置cron触发器  第二个
//    @Bean(name = "cronTrigger2")
//    public CronTriggerFactoryBean cronTrigger2(JobDetail jobServiceBeanDetail2) {//目标任务jobServiceBeanDetail2
//        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
//        triggerFactoryBean.setJobDetail(jobServiceBeanDetail2);
//        //每隔6s执行一次
//        triggerFactoryBean.setCronExpression("* * 3 * * ?");
//        return triggerFactoryBean;
//    }
////    //配置cron触发器  第一个
////    @Bean(name = "cronTrigger2")
////    public CronTriggerFactoryBean cronTrigger2(JobDetail jobServiceBeanDetail) {//目标任务jobServiceBeanDetail
////        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
////        triggerFactoryBean.setJobDetail(jobServiceBeanDetail);
////        //每隔6s执行一次
////        triggerFactoryBean.setCronExpression("0/2 * * * * ?");
////        return triggerFactoryBean;
////    }
//
//    //配置调用工厂，将所有的触发器引入
//    @Bean(name = "scheduler")
//    public SchedulerFactoryBean schedulerFactory(Trigger cronTrigger, @Qualifier("cronTrigger") Trigger simpleTrigger) {//需要管理的触发器cronTrigger，simpleTrigger
//        SchedulerFactoryBean bean = new SchedulerFactoryBean();
//        //延迟1s启动
//        bean.setStartupDelay(1);
//        //注册触发器，可以注册多个
//        bean.setTriggers(cronTrigger, simpleTrigger);
//        return bean;
//    }
//
//    //配置调用工厂，将所有的触发器引入
//    @Bean(name = "scheduler")
//    public SchedulerFactoryBean schedulerFactory2(Trigger cronTrigger, @Qualifier("cronTrigger2") Trigger simpleTrigger) {//需要管理的触发器cronTrigger，simpleTrigger
//        SchedulerFactoryBean bean = new SchedulerFactoryBean();
//        //延迟1s启动
//        bean.setStartupDelay(1);
//        //注册触发器，可以注册多个
//        bean.setTriggers(cronTrigger, simpleTrigger);
//        return bean;
//    }
//
//}
