package com.caizhen.service;

import com.caizhen.model.EpProduct;
import com.caizhen.model.EpUser;
import com.caizhen.model.PageBean;

import java.util.List;
import java.util.Map;

public interface ProductService {

    void addProduct(EpProduct product);
    void editProduct(EpProduct product);
    void deleteProduct(Integer prodId);
    EpProduct findProductById(Integer prodId);
    List<EpProduct> findProducts(Integer catId,String prodName,String sortExp,Integer pageNo,Integer pageSize);
    int findCount(Integer catId,String prodName);
    List<EpProduct> findProductsForFirst(int num);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<EpProduct> findProductByPage(String currentPage, String rows, Map<String, String[]> condition);

    /**
     * 批量删除
     * @param ids
     */
    void deleteSelectedPro(String[] ids);
}
