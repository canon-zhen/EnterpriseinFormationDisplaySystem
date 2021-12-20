package com.caizhen.dao;

import com.caizhen.model.EpProduct;
import com.caizhen.model.EpUser;

import java.util.List;
import java.util.Map;

public interface ProductDao extends BaseDao<EpProduct>{
    List<EpProduct> selectSome(Integer catId, String prodName, Integer pageNo, Integer pageSize);
    List<EpProduct> selectSome(int num);
    int selectCount(Integer catId, String prodName);
    List<EpProduct> selectAllByPage(Integer pageNo, Integer pageSize);


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
    List<EpProduct> findListByPage(int start, int rows, Map<String, String[]> condition);

}
