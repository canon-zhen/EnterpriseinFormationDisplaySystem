package com.caizhen.action.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest request1= (HttpServletRequest) request;
        HttpServletResponse response1= (HttpServletResponse) response;
        //获取资源请求路径
        String uri = request1.getRequestURI();
        //判断是否包含登陆相关资源路径
        if (uri.contains("/login.jsp") || uri.contains("/UserLoginServlet")||
                uri.contains("/registerServlet")||uri.contains("/register.jsp")||
                uri.contains("/css/")|| uri.contains("/js/")|| uri.contains("/fonts/")||uri.contains("/html/")||
                uri.contains("/img/")||uri.contains("/checkCodeServlet")){
            //包含，放行
            chain.doFilter(request, response);
        }else{
            //从session中获取duixiang
            Object admins = request1.getSession().getAttribute("admins");
            Object loginUser = request1.getSession().getAttribute("loginUser");
            System.out.println(loginUser+"   filter");
            if (admins!=null || loginUser!=null){
                System.out.println("放行");
                chain.doFilter(request, response);
            }else{
                //未登录，跳转登陆页面
                System.out.println("没有session");

                request1.setAttribute("login_msg","尚未登录， 请登录");
                //response1.sendRedirect("/login.jsp");
                request1.getRequestDispatcher("/login.jsp").forward(request1,response);
            }
        }

    }
}
