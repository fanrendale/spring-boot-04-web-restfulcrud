package com.xjf.springboot04webrestfulcrud.controller;

import com.xjf.springboot04webrestfulcrud.exception.UserNotExistsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xjf
 * @date 2019/1/18 15:23
 */
@ControllerAdvice
public class MyExceptionHandler {


    //方法一：浏览器、客户端返回的都是json数据，没有自适应
    /*@ExceptionHandler(UserNotExistsException.class)
    @ResponseBody
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notExists");
        map.put("message",e.getMessage());

        return map;
    }*/

    //方法二：能自适应
    @ExceptionHandler(UserNotExistsException.class)
    public String handleException(Exception e, HttpServletRequest request){
        //传入我们自己的错误状态码：4xx,5xx,否则就不会进入定制错误页面的解析流程
        /*Integer statusCode = (Integer) request
				.getAttribute("javax.servlet.error.status_code");*/
        request.setAttribute("javax.servlet.error.status_code",500);

        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notExists");
        map.put("message","用户出错啦");

        //在request中加入我们自定义的属性
        request.setAttribute("ext",map);

        //转发到/error
        return "forward:/error";
    }
}
