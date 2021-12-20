package com.caizhen.action.servlet.User;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/7 13:26
 * @Version V1.0
 */

import com.caizhen.model.EpUser;
import com.caizhen.service.Impl.UserServiceImpl;
import com.caizhen.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "updateFindUserServlet", value = "/updateFindUserServlet")
public class updateFindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("回显");
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String userId = request.getParameter("userId");
        //调用UserService完成查询
        UserService userService=new UserServiceImpl();
        EpUser epUser = userService.findUserById(Integer.parseInt(userId));

        System.out.println(epUser);
        request.setAttribute("epUser",epUser);
        request.getRequestDispatcher("user/updateUser_index.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
