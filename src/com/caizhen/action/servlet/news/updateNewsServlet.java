package com.caizhen.action.servlet.news;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/14 14:27
 * @Version V1.0
 */

import com.caizhen.model.EpNews;
import com.caizhen.model.EpProduct;
import com.caizhen.service.Impl.NewsServiceImpl;
import com.caizhen.service.Impl.ProductServiceImpl;
import com.caizhen.service.NewsService;
import com.caizhen.service.ProductService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

@WebServlet(name = "updateNewsServlet", value = "/updateNewsServlet")
public class updateNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取map
        Map<String, String[]> map = request.getParameterMap();
        //封装对象
        EpNews epNews=new EpNews();

        try {
            BeanUtils.populate(epNews,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        NewsService newsService=new NewsServiceImpl();
        newsService.editNews(epNews);


        //跳转到userListServlet
        response.sendRedirect(request.getContextPath()+"/findNewsByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
