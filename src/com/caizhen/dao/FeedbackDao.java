package com.caizhen.dao;

import com.caizhen.model.EpFeedback;
import com.caizhen.model.EpNews;

import java.util.List;
import java.util.Map;

public interface FeedbackDao extends BaseDao<EpFeedback>{
    List<EpFeedback> selectSome(String fbckTitle, String userName, Integer pageNo, Integer pageSize);
    int selectCount(String fbackTitle, String userName);
    int insert1(EpFeedback epFeedback);//反馈影响行数判断是否插入成功
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
    List<EpFeedback> findListByPage(int start, int rows, Map<String, String[]> condition);
}
