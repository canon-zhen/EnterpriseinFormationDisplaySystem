package com.caizhen.action.servlet;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/20 13:18
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

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //验证校验
        String check = request.getParameter("check");//获取验证码
        //从sesion中获取验证码
        HttpSession session = request.getSession();
        String checkcode_session =(String)session.getAttribute("checkcode_session");
        session.removeAttribute("checkcode_session");//确保验证码一次性
        //比较
        if(checkcode_session == null || !checkcode_session.equalsIgnoreCase(check)){
            //验证码不正确
            //提示信息
            request.setAttribute("register_msg","验证码错误！");
            //跳转到登陆页面
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return ;
        }
        //获取数据
        Map<String, String[]> map = request.getParameterMap();//获取所有数据
        EpUser epUser=new EpUser();
        try {
            BeanUtils.populate(epUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        epUser.setUserDatetime(new Date());
        epUser.setUserRight(1);
        //调用service完成注册
        UserService userService=new UserServiceImpl();
        boolean flag = userService.register(epUser);

        System.out.println(flag);
        if (flag){
            //注册成功
            //跳转到登录界面
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }else{
            //注册失败
            //失败
            //提示信息
            request.setAttribute("register_msg","用户名已存在，注册失败!");
            //跳转回登陆页面
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
