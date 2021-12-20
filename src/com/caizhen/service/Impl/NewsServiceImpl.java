package com.caizhen.service.Impl;

import com.caizhen.dao.Impl.NewsDaoImpl;
import com.caizhen.dao.NewsDao;
import com.caizhen.model.EpNews;
import com.caizhen.model.EpProduct;
import com.caizhen.model.PageBean;
import com.caizhen.service.NewsService;

import java.util.List;
import java.util.Map;

public class NewsServiceImpl implements NewsService {
    NewsDao newsDao =new NewsDaoImpl();
    @Override
    public void addNews(EpNews news) {
        newsDao.insert(news);
    }

    @Override
    public void editNews(EpNews news) {
        newsDao.update(news);
    }

    @Override
    public void deleteNews(Integer newsId) {
        newsDao.delete(newsId);
    }

    @Override
    public EpNews findNewsById(Integer newsId) {
        return (EpNews) newsDao.selectById(newsId);
    }

    @Override
    public List<EpNews> findNewses(String newsTitle, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    public List<EpNews> findNewses(int num) {
        return null;
    }

    @Override
    public int findCount(String newsTitle) {
        return 0;
    }


    @Override
    public PageBean<EpNews> findNewsByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows=Integer.parseInt(_rows);
        if (currentPage <=0){
            currentPage=1;
        }
        //创建空的PageBean对象
        PageBean<EpNews> pageBean=new PageBean<EpNews>();
        //设置参数
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        //调用Dao查询总记录数
        int totalCount=newsDao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);
        //调用Dao查询list集合
        //计算开始的索引
        int start=(currentPage-1)*rows;
        List<EpNews> list=newsDao.findListByPage(start,rows,condition);
        pageBean.setList(list);

        //总页码
        int totalPage=(totalCount % rows)==0 ? totalCount/rows : (totalCount/rows)+1;
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }

    @Override
    public void deleteSelectednews(String[] ids) {
        if (ids!=null&&ids.length>0){
            for (String id : ids) {
                newsDao.delete(Integer.parseInt(id));
            }
        }
    }
}
