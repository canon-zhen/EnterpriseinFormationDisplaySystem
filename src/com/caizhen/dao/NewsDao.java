package com.caizhen.dao;

import com.caizhen.model.EpNews;
import com.caizhen.model.EpProduct;

import java.util.List;
import java.util.Map;

public interface NewsDao extends BaseDao<EpNews>{
    List<EpNews> selectSome(int num);
    List<EpNews> selectSome(String newsTitle, Integer pageNo, Integer pageSize);
    int selectCount(String newsTitle);


    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<EpNews> findListByPage(int start, int rows, Map<String, String[]> condition);


}
