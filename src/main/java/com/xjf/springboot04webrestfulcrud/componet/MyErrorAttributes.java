package com.xjf.springboot04webrestfulcrud.componet;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author xjf
 * @date 2019/1/18 16:23
 */

/**
 * 在容器中加入我们自定义的ErrorAttributes
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    //返回值的map就是页面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        //调用DefaultErrorAttributes的getErrorAttributes方法
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);

        //在以上方法的结果中加入我们自定义的数属性
        errorAttributes.put("name","xjf");

        //从request中获取属性值后，加入到errorAttributes中
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext",0);
        errorAttributes.put("ext",ext);

        return errorAttributes;
    }
}
