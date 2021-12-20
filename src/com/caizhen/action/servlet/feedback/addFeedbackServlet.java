package com.caizhen.action.servlet.feedback;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/18 23:18
 * @Version V1.0
 */

import com.caizhen.model.EpCategory;
import com.caizhen.model.EpFeedback;
import com.caizhen.service.CategoryService;
import com.caizhen.service.FeedbackService;
import com.caizhen.service.Impl.CategoryServiceImpl;
import com.caizhen.service.Impl.FeedbackServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "addFeedbackServlet", value = "/addFeedbackServlet")
public class addFeedbackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        Map<String, String[]> map = request.getParameterMap();//获取所有数据
//        System.out.println(request.getParameter("fbackTitle"));
//        System.out.println(request.getParameter("fbackContent"));
//        System.out.println(request.getParameter("userId"));
        //封装对象
        EpFeedback epFeedback=new EpFeedback();
        try {
            BeanUtils.populate(epFeedback, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(epFeedback);

        //调用UserService完成更新
        FeedbackService feedbackService=new FeedbackServiceImpl();
        int isSuccessInsert = feedbackService.addFeedback(epFeedback);
        if (isSuccessInsert==1){
            //成功
            request.setAttribute("feedback_msg","反馈成功，感谢您的反馈！");
        }else{
            request.setAttribute("feedback_msg","很抱歉，请重新反馈！");
        }

        System.out.println("用户添加反馈");
        request.getRequestDispatcher("feedback/addFeedback_index.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
