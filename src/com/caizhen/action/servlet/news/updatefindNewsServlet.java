package com.caizhen.action.servlet.news;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/14 14:19
 * @Version V1.0
 */

import com.caizhen.model.EpNews;
import com.caizhen.model.EpProduct;
import com.caizhen.service.Impl.NewsServiceImpl;
import com.caizhen.service.Impl.ProductServiceImpl;
import com.caizhen.service.NewsService;
import com.caizhen.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updatefindNewsServlet", value = "/updatefindNewsServlet")
public class updatefindNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("回显");
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String newsId = request.getParameter("newsId");
        //调用UserService完成查询

        NewsService newsService =new NewsServiceImpl();
        EpNews epNews = newsService.findNewsById(Integer.parseInt(newsId));

        System.out.println(epNews);
        request.setAttribute("epNews",epNews);
        request.getRequestDispatcher("news/updateNews_index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
