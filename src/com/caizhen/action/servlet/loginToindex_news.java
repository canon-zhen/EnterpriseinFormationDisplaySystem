package com.caizhen.action.servlet;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/14 9:24
 * @Version V1.0
 */

import com.caizhen.model.EpNews;
import com.caizhen.model.PageBean;
import com.caizhen.service.Impl.NewsServiceImpl;
import com.caizhen.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "loginToindex_news", value = "/loginToindex_news")
public class loginToindex_news extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示数
        if (currentPage==null || "".equals(currentPage)){
            currentPage="1";
        }
        if (rows==null || "".equals(rows)){
            rows="9";
        }
        System.out.println(currentPage+"_____"+rows);
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();
        //调用service查询
        NewsService newsService =new NewsServiceImpl();
        PageBean<EpNews> pageBean =newsService.findNewsByPage(currentPage,rows,condition);


        Object loginUser=request.getSession().getAttribute("loginUser");
        request.setAttribute("loginUser",loginUser);


        //System.out.println(pageBean);
        //将pagebean存入request
        request.setAttribute("pageBean",pageBean);
        //将条件查询condition存入request
        request.setAttribute("condition",condition);
        //转发到list.jsp
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
