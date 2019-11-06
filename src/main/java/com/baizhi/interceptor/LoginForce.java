package com.baizhi.interceptor;

import com.baizhi.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginForce implements HandlerInterceptor {


    @Override//方法前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //添加
        String oper = request.getParameter("oper");
        if ("add".equals(oper)) {
            return true;
        }
        //修改状态
        String status = request.getParameter("status");
        User user = new User();
        if (status != null && status != "") {
            System.out.println("修改用户状态传入数据:"+status);
            String[] split = status.split(",");
            user.setId(split[1]);
            user.setStatus(split[0]);
            request.setAttribute("user", user);
            return true;
        }

        HttpSession session = request.getSession();
        String flog = (String) session.getAttribute("flog");
        if ("Y".equals(flog)) {
            System.out.println("强制登陆成功拦截");
            return true;
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return false;
        }

    }

    @Override//方法结果返回前
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("方法返回之前");
    }

    @Override//方法执行后
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("方法执行后调用");
    }
}
