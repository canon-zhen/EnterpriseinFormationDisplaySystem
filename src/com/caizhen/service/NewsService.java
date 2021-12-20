package com.caizhen.service;

import com.caizhen.model.EpNews;
import com.caizhen.model.EpProduct;
import com.caizhen.model.PageBean;

import java.util.List;
import java.util.Map;

public interface NewsService {
    void addNews(EpNews news);
    void editNews(EpNews news);
    void deleteNews(Integer newsId);
    EpNews findNewsById(Integer newsId);
    List<EpNews> findNewses(String newsTitle,Integer pageNo,Integer pageSize);
    List<EpNews> findNewses(int num);
    int findCount(String newsTitle);


    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<EpNews> findNewsByPage(String currentPage, String rows, Map<String, String[]> condition);

    /**
     * 批量删除
     * @param ids
     */
    void deleteSelectednews(String[] ids);


}
