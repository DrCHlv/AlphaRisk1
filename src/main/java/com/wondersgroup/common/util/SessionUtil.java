package com.wondersgroup.common.util;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionUtil {

    private SessionUtil(){}

    private static class SingletonInstance{
        private static final SessionUtil INSTANCE = new SessionUtil();
    }

    private HttpSession buildHttpSession(){
        //获取到ServletRequestAttributes 里面有
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取到Request对象
        HttpServletRequest request = attrs.getRequest();
        //获取到Session对象
        HttpSession session = request.getSession();

        //获取到Response对象
        //HttpServletResponse response = attrs.getResponse();
        return session;
    }

    public static HttpSession getHttpSession(){

        return SingletonInstance.INSTANCE.buildHttpSession();
    }
}
