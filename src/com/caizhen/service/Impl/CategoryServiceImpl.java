package com.caizhen.service.Impl;

import com.caizhen.dao.CategoryDao;
import com.caizhen.dao.Impl.CategoryDaoImpl;
import com.caizhen.model.EpCategory;
import com.caizhen.model.EpFeedback;
import com.caizhen.model.PageBean;
import com.caizhen.service.CategoryService;

import java.util.List;
import java.util.Map;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao=new CategoryDaoImpl();
    @Override
    public void addCategory(EpCategory category) {
        categoryDao.insert(category);
    }

    @Override
    public void editCategory(EpCategory category) {
        categoryDao.update(category);
    }

    @Override
    public void deleteCategory(Integer catId) {
        categoryDao.delete(catId);
    }

    @Override
    public EpCategory findCategoryById(Integer catId) {
        return (EpCategory) categoryDao.selectById(catId);
    }

    @Override
    public List<EpCategory> findCategories() {
        return null;
    }

    @Override
    public PageBean<EpCategory> findCategoryByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows=Integer.parseInt(_rows);
        if (currentPage <=0){
            currentPage=1;
        }
        //创建空的PageBean对象
        PageBean<EpCategory> pageBean=new PageBean<EpCategory>();
        //设置参数
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        //调用Dao查询总记录数
        int totalCount=categoryDao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);
        //调用Dao查询list集合
        //计算开始的索引
        int start=(currentPage-1)*rows;
        List<EpCategory> list=categoryDao.findListByPage(start,rows,condition);
        pageBean.setList(list);

        //总页码
        int totalPage=(totalCount % rows)==0 ? totalCount/rows : (totalCount/rows)+1;
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }

    @Override
    public void deleteSelectedCategory(String[] ids) {
        if (ids!=null&&ids.length>0){
            for (String id : ids) {
                categoryDao.delete(Integer.parseInt(id));
            }
        }
    }
}
