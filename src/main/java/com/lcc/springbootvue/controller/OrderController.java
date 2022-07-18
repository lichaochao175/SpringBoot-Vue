package com.lcc.springbootvue.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichaochao
 * @data 2022/6/18 11:00 AM
 **/
@RestController
@RequestMapping("order")
public class OrderController {

    public static void main(String[] args) {
        List<String> list =  new ArrayList<>();
        List<String> list2 = Arrays.asList("123","456");
        System.out.println(list2);
//        list.parallelStream()
    }

}
