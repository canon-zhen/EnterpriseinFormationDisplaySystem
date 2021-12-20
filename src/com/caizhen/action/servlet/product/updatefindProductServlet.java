package com.caizhen.action.servlet.product;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/13 14:47
 * @Version V1.0
 */

import com.caizhen.model.EpProduct;
import com.caizhen.model.EpUser;
import com.caizhen.service.Impl.ProductServiceImpl;
import com.caizhen.service.Impl.UserServiceImpl;
import com.caizhen.service.ProductService;
import com.caizhen.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updatefindProductServlet", value = "/updatefindProductServlet")
public class updatefindProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("回显");
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String prodId = request.getParameter("prodId");
        //调用UserService完成查询

        ProductService productService =new ProductServiceImpl();
        EpProduct epProduct = productService.findProductById(Integer.parseInt(prodId));

        System.out.println(epProduct);
        request.setAttribute("epProduct",epProduct);
        request.getRequestDispatcher("product/updateProduct_index.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
