package com.caizhen.dao;

import com.caizhen.model.EpUser;
import com.caizhen.model.PageBean;

import java.util.List;
import java.util.Map;

public interface UserDao extends BaseDao<EpUser>{

    List<EpUser> selectAll();

    /**
     *
     * @param username
     * @return
     */
    EpUser findUserByUsername(String username);

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
    List<EpUser> findListByPage(int start, int rows, Map<String, String[]> condition);


    EpUser selectOne(String userName, String userPwd);
   // List<EpUser> selectSomeByPage(Integer pageNo, Integer pageSize);
    int selectCount();


}
