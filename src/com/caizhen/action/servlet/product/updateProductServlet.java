package com.caizhen.action.servlet.product;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/13 18:15
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

@WebServlet(name = "updateProductServlet", value = "/updateProductServlet")
public class updateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//设置编码
        request.setCharacterEncoding("utf-8");
        //获取map
        Map<String, String[]> map = request.getParameterMap();
        //封装对象
        EpProduct epProduct = new EpProduct();

        try {
            BeanUtils.populate(epProduct,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        epProduct.setProdDatetime(new Date());
        System.out.println(epProduct.getProdFirstShow()+"         updateProductServle");
        System.out.println(epProduct);
//        System.out.println(epUser.getUserDatetime());
//        System.out.println(epUser.getUserRight()+"  权限       updateUserServlet");
        //调用service更新数据
        ProductService productService =new ProductServiceImpl();
        productService.editProduct(epProduct);

        //跳转到userListServlet
        response.sendRedirect(request.getContextPath()+"/findProductByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
