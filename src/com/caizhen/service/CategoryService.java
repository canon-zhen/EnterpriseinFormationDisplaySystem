package com.caizhen.service;

import com.caizhen.model.EpCategory;
import com.caizhen.model.EpFeedback;
import com.caizhen.model.PageBean;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    void addCategory(EpCategory category);
    void editCategory(EpCategory category);
    void deleteCategory(Integer catId);
    EpCategory findCategoryById(Integer catId);
    List<EpCategory> findCategories();
    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<EpCategory> findCategoryByPage(String currentPage, String rows, Map<String, String[]> condition);

    /**
     * 批量删除
     * @param ids
     */
    void deleteSelectedCategory(String[] ids);
}
