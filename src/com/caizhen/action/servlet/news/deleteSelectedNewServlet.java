package com.caizhen.action.servlet.news;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/14 14:17
 * @Version V1.0
 */

import com.caizhen.service.Impl.NewsServiceImpl;
import com.caizhen.service.Impl.ProductServiceImpl;
import com.caizhen.service.NewsService;
import com.caizhen.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteSelectedNewServlet", value = "/deleteSelectedNewServlet")
public class deleteSelectedNewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有id
        String[] Ids = request.getParameterValues("selectedId");
        //调用service删除
        NewsService newsService =new NewsServiceImpl();
        newsService.deleteSelectednews(Ids);

        //跳转
        response.sendRedirect(request.getContextPath()+"/findNewsByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
