package com.caizhen.action.servlet;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/11/30 8:23
 * @Version V1.0
 */

import com.caizhen.dao.Impl.UserDaoImpl;
import com.caizhen.model.EpUser;
import com.caizhen.service.Impl.UserServiceImpl;
import com.caizhen.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "UserLoginServlet", value = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserServlet__doGet");

        response.setHeader("Cache-Control","no-cache"); //不对页面进行缓存，再次访问时将从服务器重新获取最新版本
        response.setHeader("Cache-Control","no-store"); //任何情况下都不缓存页面
        response.setDateHeader("Expires", 0); //使缓存过期
        response.setHeader("Pragma","no-cache"); //HTTP 1.0 向后兼容


        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String verifycode = request.getParameter("verifycode");//获取验证码
        //校验验证码(在获取全部数据之前)
        HttpSession session = request.getSession();
        String checkcode_session =(String)session.getAttribute("checkcode_session");
        session.removeAttribute("checkcode_session");//确保验证码一次性
//        if (!checkcode_session.equalsIgnoreCase(verifycode)){
//            //验证码不正确
//            //提示信息
//            request.setAttribute("login_msg","验证码错误！");
//            //跳转到登陆页面
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
//            return;
//        }

        //获取数据

        Map<String, String[]> map = request.getParameterMap();//获取所有数据
        //System.out.println(role);
        //根据身份登录

        //封装Epuser对象
        EpUser epUser=new EpUser();
        try {
            BeanUtils.populate(epUser,map);
            //BeanUtils.populate(epUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(epUser+" 封装 的 epUser");
        //调用Service查询
        UserService userService = new UserServiceImpl();
        EpUser loginUser=userService.login(epUser);

        //判断是否成功
        if (loginUser!=null){
            //成功
            //将用户存入session
            session.setAttribute("loginUser",loginUser);
            //跳转页面
            if(loginUser.getUserRight()==1){
                //用户
                System.out.println("用户");
                response.sendRedirect(request.getContextPath()+"/loginToindex_news");
            }else{
                //管理员
                System.out.println("管理员");
                response.sendRedirect(request.getContextPath()+"/loginToindex_news");
            }

        }else{
            //登录失败
            //提示信息
            System.out.println(epUser+"  登录epUser");
            request.setAttribute("login_msg","登录失败！");
            //跳转到登陆页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }





    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserServlet__doPost");
        this.doGet(request, response);
    }
}
