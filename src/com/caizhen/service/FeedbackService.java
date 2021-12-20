package com.caizhen.service;

import com.caizhen.model.EpFeedback;
import com.caizhen.model.EpNews;
import com.caizhen.model.PageBean;

import java.util.List;
import java.util.Map;

public interface FeedbackService {
    int addFeedback(EpFeedback feedback);
    void editFeedback(EpFeedback feedback);
    void deleteFeedback(Integer fbackId);
    EpFeedback findFeedbackById(Integer fbackId);
    List<EpFeedback> findFeedbacks(String fbackTitle, String userName, String sortExp, Integer pageNo, Integer pageSize);
    int findCount(String fbackTitle, String userName);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<EpFeedback> findFeedBackByPage(String currentPage, String rows, Map<String, String[]> condition);

    /**
     * 批量删除
     * @param ids
     */
    void deleteSelectedfback(String[] ids);
}
