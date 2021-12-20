package com.caizhen.action.servlet.User;

import com.caizhen.service.Impl.UserServiceImpl;
import com.caizhen.service.UserService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * user
 */

@WebServlet(name = "DeleteSelectedServlet", value = "/deleteSelectedServlet")
public class DeleteSelectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有id
        String[] Ids = request.getParameterValues("selectedId");
        //调用userservice删除
        System.out.println("删除选中");
        UserService service=new UserServiceImpl();
        service.deleteSelectedUser(Ids);
        System.out.println("删除选中user");
        //跳转
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
