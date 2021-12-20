package com.caizhen.service.Impl;

import com.caizhen.dao.FeedbackDao;
import com.caizhen.dao.Impl.FeedbackDaoImpl;
import com.caizhen.model.EpFeedback;
import com.caizhen.model.EpNews;
import com.caizhen.model.PageBean;
import com.caizhen.service.FeedbackService;

import java.util.List;
import java.util.Map;

public class FeedbackServiceImpl implements FeedbackService {
    FeedbackDao feedbackDao=new FeedbackDaoImpl();
    @Override
    public int addFeedback(EpFeedback feedback) {
        return feedbackDao.insert1(feedback);
    }

    @Override
    public void editFeedback(EpFeedback feedback) {

    }

    @Override
    public void deleteFeedback(Integer fbackId) {
        feedbackDao.delete(fbackId);
    }

    @Override
    public EpFeedback findFeedbackById(Integer fbackId) {
        return null;
    }

    @Override
    public List<EpFeedback> findFeedbacks(String fbackTitle, String userName, String sortExp, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    public int findCount(String fbackTitle, String userName) {
        return 0;
    }

    @Override
    public PageBean<EpFeedback> findFeedBackByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows=Integer.parseInt(_rows);
        if (currentPage <=0){
            currentPage=1;
        }
        //创建空的PageBean对象
        PageBean<EpFeedback> pageBean=new PageBean<EpFeedback>();
        //设置参数
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        //调用Dao查询总记录数
        int totalCount=feedbackDao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);
        //调用Dao查询list集合
        //计算开始的索引
        int start=(currentPage-1)*rows;
        List<EpFeedback> list=feedbackDao.findListByPage(start,rows,condition);
        pageBean.setList(list);

        //总页码
        int totalPage=(totalCount % rows)==0 ? totalCount/rows : (totalCount/rows)+1;
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }

    @Override
    public void deleteSelectedfback(String[] ids) {
        if (ids!=null&&ids.length>0){
            for (String id : ids) {
                feedbackDao.delete(Integer.parseInt(id));
            }
        }
    }
}
