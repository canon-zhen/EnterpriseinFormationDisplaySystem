package com.caizhen.action.servlet.category;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/16 23:50
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
import java.util.Map;

@WebServlet(name = "updateCategoryServlet", value = "/updateCategoryServlet")
public class updateCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取map
        Map<String, String[]> map = request.getParameterMap();
        //封装对象

        EpCategory epCategory=new EpCategory();
        try {
            BeanUtils.populate(epCategory,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        CategoryService categoryService=new CategoryServiceImpl();
        categoryService.editCategory(epCategory);


        //跳转到Servlet
        response.sendRedirect(request.getContextPath()+"/findCategoryByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
