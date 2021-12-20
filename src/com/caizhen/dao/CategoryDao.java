package com.caizhen.dao;

import com.caizhen.model.EpCategory;
import com.caizhen.model.EpFeedback;

import java.util.List;
import java.util.Map;

public interface CategoryDao extends BaseDao<EpCategory>{

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
    List<EpCategory> findListByPage(int start, int rows, Map<String, String[]> condition);
}
