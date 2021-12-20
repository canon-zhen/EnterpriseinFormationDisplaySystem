package com.caizhen.action.servlet.category;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/17 13:37
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

@WebServlet(name = "deleteSelectedCategoryServlet", value = "/deleteSelectedCategoryServlet")
public class deleteSelectedCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有id
        String[] Ids = request.getParameterValues("selectedId");
        //调用service删除
        CategoryService categoryService=new CategoryServiceImpl();
        categoryService.deleteSelectedCategory(Ids);

        //跳转
        response.sendRedirect(request.getContextPath()+"/findCategoryByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
