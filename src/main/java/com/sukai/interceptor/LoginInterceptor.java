package com.sukai.interceptor;

import com.sukai.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author chengsukai
 * @desc 定义拦截器
 * LoginInterceptor实现HandlerInterceptor接口重写preHandle方法
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();
        // 路径列表
        String[] requireAuthPages = new String[]{
                "index",
        };

        String url = request.getRequestURI();

        url = StringUtils.remove(url,contextPath+"/");
        String page = url;

        if(beginWith(page, requireAuthPages)){
            User user = (User) session.getAttribute("user");
            if(user == null){
                response.sendRedirect("login");
                return false;
            }
        }
        return true;

    }

    /**
     * 查找特定的值
     * @param page 目标字符串
     * @param requiredAuthPages - 字符串数组
     * @return 是否找到
     */
    private boolean beginWith(String page,String[] requiredAuthPages){
        boolean result = false;
        for(String requiredAuthPage : requiredAuthPages){
            if(StringUtils.startsWith(page,requiredAuthPage)){
                result = true;
                break;
            }
        }
        return result;
    }
}
