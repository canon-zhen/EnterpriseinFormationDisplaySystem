package com.caizhen.action.servlet.feedback;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/14 21:13
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

@WebServlet(name = "deleteSelectedFBackServlet", value = "/deleteSelectedFBackServlet")
public class deleteSelectedFBackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有id
        String[] Ids = request.getParameterValues("selectedId");
        //调用service删除
        FeedbackService feedbackService=new FeedbackServiceImpl();
        feedbackService.deleteSelectedfback(Ids);

        //跳转
        response.sendRedirect(request.getContextPath()+"/findFeedbackByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
