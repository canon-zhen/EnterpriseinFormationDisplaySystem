package com.caizhen.action.servlet.product;

import com.caizhen.service.Impl.ProductServiceImpl;
import com.caizhen.service.Impl.UserServiceImpl;
import com.caizhen.service.ProductService;
import com.caizhen.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteSelectedServlet", value = "/deleteSelectedProServlet")
public class DeleteSelectedProServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有id
        String[] Ids = request.getParameterValues("selectedId");
        //调用service删除
        ProductService service=new ProductServiceImpl();
        service.deleteSelectedPro(Ids);
        //跳转
        response.sendRedirect(request.getContextPath()+"/findProductByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
