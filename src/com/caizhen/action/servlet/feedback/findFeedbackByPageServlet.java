package com.caizhen.action.servlet.feedback;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/14 20:06
 * @Version V1.0
 */

import com.caizhen.model.EpFeedback;
import com.caizhen.model.EpNews;
import com.caizhen.model.PageBean;
import com.caizhen.service.FeedbackService;
import com.caizhen.service.Impl.FeedbackServiceImpl;
import com.caizhen.service.Impl.NewsServiceImpl;
import com.caizhen.service.NewsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "findFeedbackByPageServlet", value = "/findFeedbackByPageServlet")
public class findFeedbackByPageServlet extends HttpServlet {
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
        FeedbackService feedbackService=new FeedbackServiceImpl();
        PageBean<EpFeedback> pageBean = feedbackService.findFeedBackByPage(currentPage, rows, condition);
        //将pagebean存入request
        request.setAttribute("pageBean",pageBean);
        //将条件查询condition存入request
        request.setAttribute("condition",condition);
        //转发到list.jsp
        request.getRequestDispatcher("feedback/feedbackList_index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
