package com.caizhen.action.servlet.category;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/15 9:00
 * @Version V1.0
 */

import com.caizhen.model.EpCategory;
import com.caizhen.model.EpFeedback;
import com.caizhen.model.EpUser;
import com.caizhen.model.PageBean;
import com.caizhen.service.CategoryService;
import com.caizhen.service.FeedbackService;
import com.caizhen.service.Impl.CategoryServiceImpl;
import com.caizhen.service.Impl.FeedbackServiceImpl;
import com.caizhen.service.Impl.UserServiceImpl;
import com.caizhen.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "findCategoryByPageServlet", value = "/findCategoryByPageServlet")
public class findCategoryByPageServlet extends HttpServlet {
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

        CategoryService categoryService=new CategoryServiceImpl();
        PageBean<EpCategory> pageBean = categoryService.findCategoryByPage(currentPage, rows, condition);

        Object loginUser=request.getSession().getAttribute("loginUser");
        request.setAttribute("loginUser",loginUser);



        //将pagebean存入request
        request.setAttribute("pageBean",pageBean);
        //将条件查询condition存入request
        request.setAttribute("condition",condition);
        //转发到list.jsp
        request.getRequestDispatcher("category/categoryList_index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
