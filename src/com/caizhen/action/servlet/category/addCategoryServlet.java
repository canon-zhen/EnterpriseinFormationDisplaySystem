package com.caizhen.action.servlet.category;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/17 13:01
 * @Version V1.0
 */

import com.caizhen.model.EpCategory;
import com.caizhen.model.EpNews;
import com.caizhen.service.CategoryService;
import com.caizhen.service.Impl.CategoryServiceImpl;
import com.caizhen.service.Impl.NewsServiceImpl;
import com.caizhen.service.NewsService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

@WebServlet(name = "addCategoryServlet", value = "/addCategoryServlet")
public class addCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        Map<String, String[]> map = request.getParameterMap();//获取所有数据
        //封装对象
        EpCategory epCategory=new EpCategory();

        try {
            BeanUtils.populate(epCategory, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用UserService完成更新
        CategoryService categoryService=new CategoryServiceImpl();
        categoryService.addCategory(epCategory);

        System.out.println("添加fenlei");
        response.sendRedirect(request.getContextPath()+"/findCategoryByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
