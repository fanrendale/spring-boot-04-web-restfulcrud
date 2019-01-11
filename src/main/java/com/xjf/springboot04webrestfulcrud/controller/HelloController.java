package com.xjf.springboot04webrestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author xjf
 * @date 2019/1/7 14:16
 */
@Controller
public class HelloController {

    /*@RequestMapping({"/","index","index.html"})
    public String index(){
        return "index";
    }*/

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World!";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","<h1>lisi</h1>","wangwu"));
        return "success";
    }
}
