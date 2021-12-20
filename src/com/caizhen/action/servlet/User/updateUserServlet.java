package com.caizhen.action.servlet.User;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/7 8:27
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

@WebServlet(name = "updateUserServlet", value = "/updateUserServlet")
public class updateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取map
        Map<String, String[]> map = request.getParameterMap();
        //封装对象
        EpUser epUser = new EpUser();
        try {
            BeanUtils.populate(epUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        epUser.setUserDatetime(new Date());

        System.out.println(epUser);
//        System.out.println(epUser.getUserDatetime());
//        System.out.println(epUser.getUserRight()+"  权限       updateUserServlet");
        //调用service更新数据
        UserService userService = new UserServiceImpl();
        userService.editUser(epUser);
        //跳转到userListServlet
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
