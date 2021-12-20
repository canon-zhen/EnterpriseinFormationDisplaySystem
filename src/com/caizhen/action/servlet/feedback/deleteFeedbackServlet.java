package com.caizhen.action.servlet.feedback;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/14 21:10
 * @Version V1.0
 */

import com.caizhen.service.FeedbackService;
import com.caizhen.service.Impl.FeedbackServiceImpl;
import com.caizhen.service.Impl.NewsServiceImpl;
import com.caizhen.service.NewsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteFeedbackServlet", value = "/deleteFeedbackServlet")
public class deleteFeedbackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String fbackId = request.getParameter("fbackId");

        //调用Service完成更新
        FeedbackService feedbackService=new FeedbackServiceImpl();
        feedbackService.deleteFeedback(Integer.parseInt(fbackId));

        System.out.println("删除fankui");
        response.sendRedirect(request.getContextPath()+"/findFeedbackByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
