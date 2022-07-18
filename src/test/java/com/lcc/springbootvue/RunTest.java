package com.lcc.springbootvue;

import com.lcc.springbootvue.domain.entity.User;
import com.lcc.springbootvue.domain.vo.CheckVO;
import com.lcc.springbootvue.mapper.UserDao;
import com.lcc.springbootvue.service.impl.TecommerceOrderServiceImpl;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.lang.model.element.VariableElement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author lichaochao
 * @data 2022/7/6 7:00 PM
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class RunTest {
    @Autowired
    TecommerceOrderServiceImpl tecommerceOrderService;

    @Autowired
    UserDao userDao;

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
            userDao.insert(user);
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


}
