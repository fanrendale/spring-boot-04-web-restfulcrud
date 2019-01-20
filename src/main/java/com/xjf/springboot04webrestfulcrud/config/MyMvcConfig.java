package com.xjf.springboot04webrestfulcrud.config;

import com.xjf.springboot04webrestfulcrud.componet.LoginHandlerInterceptor;
import com.xjf.springboot04webrestfulcrud.componet.MyLocaleResolver;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author xjf
 * @date 2019/1/8 9:31
 */

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
//@EnableWebMvc       不要接管SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/atguigu来到success页面
        registry.addViewController("/atguigu").setViewName("success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    /**
     * 添加登录拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //  "/**"对所有请求有效   并且不拦截访问登录的请求和发起登录的请求
        //springboot已经做好的静态资源的映射，此时不需要再配置静态资源的拦截
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
//                excludePathPatterns("/","/index.html","/user/login","/**/*.js","/**/*.css","/**/*.svg");
    }

    /**
     * 添加区域化解析器
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
