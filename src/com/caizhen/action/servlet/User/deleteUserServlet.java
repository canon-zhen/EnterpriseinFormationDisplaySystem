package com.caizhen.action.servlet.User;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/7 8:26
 * @Version V1.0
 */

import com.caizhen.model.EpUser;
import com.caizhen.service.Impl.UserServiceImpl;
import com.caizhen.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

@WebServlet(name = "deleteUserServlet", value = "/deleteUserServlet")
public class deleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String userId = request.getParameter("userId");

        //调用UserService完成更新
        UserService userService=new UserServiceImpl();
        userService.deleteUser(Integer.parseInt(userId));
        System.out.println("删除用户");
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
