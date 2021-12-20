package com.caizhen.action.servlet.category;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/17 13:39
 * @Version V1.0
 */

import com.caizhen.service.CategoryService;
import com.caizhen.service.Impl.CategoryServiceImpl;
import com.caizhen.service.Impl.NewsServiceImpl;
import com.caizhen.service.NewsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteCategoryServlet", value = "/deleteCategoryServlet")
public class deleteCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String catId = request.getParameter("catId");

        //调用Service完成更新
        CategoryService categoryService =new CategoryServiceImpl();
        categoryService.deleteCategory(Integer.parseInt(catId));



        System.out.println("删除新闻");
        response.sendRedirect(request.getContextPath()+"/findCategoryByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
