package com.caizhen.action.servlet.news;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/14 14:09
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

@WebServlet(name = "deleteNewsServlet", value = "/deleteNewsServlet")
public class deleteNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String newsId = request.getParameter("newsId");

        //调用Service完成更新
        NewsService newsService=new NewsServiceImpl();
        newsService.deleteNews(Integer.parseInt(newsId));


        System.out.println("删除新闻");
        response.sendRedirect(request.getContextPath()+"/findNewsByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
