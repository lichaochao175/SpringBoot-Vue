package com.lcc.springbootvue;

import com.lcc.springbootvue.domain.entity.User;
import com.lcc.springbootvue.domain.vo.CheckVO;
import com.lcc.springbootvue.mapper.UserMapper;
import com.lcc.springbootvue.service.impl.TecommerceOrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lichaochao
 * @data 2022/7/6 7:00 PM
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RunTest {
    @Autowired
    TecommerceOrderServiceImpl tecommerceOrderService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    private  RabbitTemplate rabbitTemplate;
    
    @Test
    public  void list(){
        List<CheckVO> list = tecommerceOrderService.tEcommerceOrderMapper();
        for (CheckVO vo :list){
            System.out.println(vo);
        }
    }

    public static void main(String[] args) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
        System.out.println("格式化输出：" + sdf.format(d));
        for (int i = 0; i <1000000 ; i++) {
            System.out.println("");
        }

    }

    @Test
    public  void list2(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
        System.out.println("格式化输出：" + sdf.format(d));
        for (int i = 0; i <10000000; i++) {
            User user = new User();
            user.setUsername("测试人员"+1);
            user.setPassword("password"+2);
            userMapper.insert(user);
        }

        Date date = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
        System.out.println("格式化输出：" + sdf2.format(date));
    }

    @Test
    public void multiSend(){
        StringBuilder times=new StringBuilder();
        for(int i=0;i<10;i++){
            long time=System.nanoTime();
            rabbitTemplate.convertAndSend("test1","第"+i+"次发送的时间："+time);
            times.append(time+"<br>");
        }
        System.out.println(times.toString());
    }


    @Test
    public  void Thread(){
        log.info("测试开始");
        int  i =3;
        for (int j =0 ; j <i;j++) {
             if( j == 1){
                 log.info("开始处理"+j);
                  int k = 1/0;
                  log.info("报错信息"+j);
             }
        }
    }

}
