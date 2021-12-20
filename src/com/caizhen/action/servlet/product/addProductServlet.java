package com.caizhen.action.servlet.product;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/13 13:01
 * @Version V1.0
 */

import com.caizhen.model.EpProduct;
import com.caizhen.model.EpUser;
import com.caizhen.service.Impl.ProductServiceImpl;
import com.caizhen.service.Impl.UserServiceImpl;
import com.caizhen.service.ProductService;
import com.caizhen.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

@WebServlet(name = "addProductServlet", value = "/addProductServlet")
public class addProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        Map<String, String[]> map = request.getParameterMap();//获取所有数据
        //封装对象
        EpProduct epProduct=new EpProduct();
        epProduct.setProdDatetime(new Date());
        try {
            BeanUtils.populate(epProduct, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(epProduct.getProdFirstShow()+"         addProductServlet");
        //调用UserService完成更新
        ProductService productService=new ProductServiceImpl();
        productService.addProduct(epProduct);
        System.out.println("添加产品");
        response.sendRedirect(request.getContextPath()+"/findProductByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
