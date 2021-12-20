package com.caizhen.action.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CharsetFilter implements Filter {
    public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain) throws ServletException, IOException {
        //将父接口转为子接口
        HttpServletRequest request= (HttpServletRequest) request1;
        HttpServletResponse response= (HttpServletResponse) response1;
        //获取请求方法
        String method = request.getMethod();
        //解决post请求中的乱码问题
        if (method.equalsIgnoreCase("post")){
            request.setCharacterEncoding("utf-8");
        }
        //处理响应乱码
        //response.setContentType("text/html;charset=utf-8");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
