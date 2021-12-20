package com.caizhen.service;

import com.caizhen.dao.Impl.UserDaoImpl;
import com.caizhen.dao.UserDao;
import com.caizhen.model.EpUser;
import com.caizhen.model.PageBean;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<EpUser> findAllUser();
    EpUser login(EpUser epUser);

    /**
     *
     * @param epUser
     * @return
     */
    boolean register(EpUser epUser);

    void addUser(EpUser user);
    void editUser(EpUser user);
    void deleteUser(Integer userId);
    EpUser findUserById(Integer userId);
    EpUser findUserByNameAndPwd(String userName, String userPwd);
    List<EpUser> findUsers(String userName, String sortExp, Integer pageNo, Integer pageSize);
    int findCount(String userName);

    /**
     * 批量删除
     * @param ids
     */
    void deleteSelectedUser(String[] ids);


    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<EpUser> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
