package com.caizhen.action.servlet.category;

/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/16 23:43
 * @Version V1.0
 */

import com.caizhen.model.EpCategory;
import com.caizhen.model.EpNews;
import com.caizhen.service.CategoryService;
import com.caizhen.service.Impl.CategoryServiceImpl;
import com.caizhen.service.Impl.NewsServiceImpl;
import com.caizhen.service.NewsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updatefindCategoryServlet", value = "/updatefindCategoryServlet")
public class updatefindCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("回显");
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String catId = request.getParameter("catId");
        //调用UserService完成查询

        CategoryService categoryService=new CategoryServiceImpl();
        EpCategory epCategory = categoryService.findCategoryById(Integer.parseInt(catId));

        System.out.println(epCategory+"回显");
        request.setAttribute("epCategory",epCategory);
        request.getRequestDispatcher("category/updateCategory_index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
