package com.caizhen.action.servlet.User;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/7 8:25
 * @Version V1.0
 */

import com.caizhen.model.EpUser;
import com.caizhen.service.Impl.UserServiceImpl;
import com.caizhen.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "addUserServlet", value = "/addUserServlet")
public class addUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        Map<String, String[]> map = request.getParameterMap();//获取所有数据
        //封装对象
        EpUser epUser=new EpUser();
        epUser.setUserDatetime(new Date());
        try {
            BeanUtils.populate(epUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用UserService完成更新
        UserService userService=new UserServiceImpl();
        userService.addUser(epUser);
        System.out.println("更新用户");
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
