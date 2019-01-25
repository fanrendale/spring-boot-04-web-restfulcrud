package com.xjf.springboot04webrestfulcrud.controller;

import com.xjf.springboot04webrestfulcrud.exception.UserNotExistsException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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

    /*这条注释测试git*/
    /*这条注释在GitHub修改的*/

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("user") String user) throws UserNotExistsException {
        if ("xjf".equals(user)){
            throw new UserNotExistsException();
        }

        return "Hello World!";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","<h1>lisi</h1>","wangwu"));
        return "success";
    }

    /**
     * 用户登录
     * @return
     */
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){

        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            //登录失败
            map.put("msg","用户名或密码错误");          //错误提示信息
            return "login";
        }
    }
}
