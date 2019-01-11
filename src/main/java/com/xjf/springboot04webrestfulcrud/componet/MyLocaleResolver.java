package com.xjf.springboot04webrestfulcrud.componet;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author xjf
 * @date 2019/1/11 16:16
 */

/**
 * 我的区域化解析器
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        //默认使用操作系统的语言，不是浏览器的
        Locale locale = Locale.getDefault();

        if (!StringUtils.isEmpty(l)){
            String[] temp = l.split("_");
            locale = new Locale(temp[0],temp[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
