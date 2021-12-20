package com.caizhen.action;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/18 20:36
 * @Version V1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "quitServlet", value = "/quitServlet")
public class quitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("loginUser");
        session.invalidate();
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
