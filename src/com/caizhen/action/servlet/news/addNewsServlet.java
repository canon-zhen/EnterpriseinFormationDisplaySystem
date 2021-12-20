package com.caizhen.action.servlet.news;
/**
 * @Description TODO
 * @ClassName ${CLASS_NAME}
 * @Author Canon_Zhen
 * @Date 2021/12/16 23:39
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

@WebServlet(name = "addNewsServlet", value = "/addNewsServlet")
public class addNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        Map<String, String[]> map = request.getParameterMap();//获取所有数据
        //封装对象
        EpNews epNews=new EpNews();
        epNews.setNewsDatetime(new Date());
        try {
            BeanUtils.populate(epNews, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用UserService完成更新
        NewsService newsService=new NewsServiceImpl();
        newsService.addNews(epNews);
        System.out.println("添加xwen");
        response.sendRedirect(request.getContextPath()+"/findNewsByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
