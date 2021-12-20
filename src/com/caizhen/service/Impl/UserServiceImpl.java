package com.caizhen.service.Impl;

import com.caizhen.dao.Impl.UserDaoImpl;
import com.caizhen.dao.UserDao;
import com.caizhen.model.EpUser;
import com.caizhen.model.PageBean;
import com.caizhen.service.UserService;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    UserDao userdao=new UserDaoImpl();

    @Override
    public List<EpUser> findAllUser() {
        List<EpUser> epUsers = userdao.selectAll();
        return epUsers;
    }

    @Override
    public void deleteSelectedUser(String[] ids) {
        if (ids!=null&&ids.length>0){
            for (String id : ids) {
                userdao.delete(Integer.parseInt(id));
            }
        }

    }

    @Override
    public EpUser login(EpUser epUser) {
        return userdao.selectOne(epUser.getUserName(),epUser.getUserPwd());
    }

    @Override
    public boolean register(EpUser epUser) {
        EpUser userByUsername = userdao.findUserByUsername(epUser.getUserName());

        if (userByUsername != null){
            //用户名存在，注册失败
            return false;
        }
        //无重名，保存
        userdao.insert(epUser);
        return true;
    }
/*    @Test
    public void test(){
        EpUser User=new EpUser();
        User.setUserName("bingbing");
        User.setUserPwd("520");
        EpUser login = login(User);
        System.out.println(login);
    }*/


    @Override
    public void addUser(EpUser user) {
        userdao.insert(user);
    }

    @Override
    public void editUser(EpUser user) {
        userdao.update(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userdao.delete(userId);
    }

    @Override
    public EpUser findUserById(Integer userId) {
        return (EpUser) userdao.selectById(userId);
    }

    @Override
    public EpUser findUserByNameAndPwd(String userName, String userPwd) {

        return null;
    }

    @Override
    public List<EpUser> findUsers(String userName, String sortExp, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    public int findCount(String userName) {
        return 0;
    }

    @Override
    public PageBean<EpUser> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows=Integer.parseInt(_rows);
        if (currentPage <=0){
            currentPage=1;
        }
        //创建空的PageBean对象
        PageBean<EpUser> pageBean=new PageBean<EpUser>();
        //设置参数
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        //调用Dao查询总记录数
        int totalCount=userdao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);
        //调用Dao查询list集合
        //计算开始的索引
        int start=(currentPage-1)*rows;
        List<EpUser> list=userdao.findListByPage(start,rows,condition);
        pageBean.setList(list);

        //总页码
        int totalPage=(totalCount % rows)==0 ? totalCount/rows : (totalCount/rows)+1;
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }
}
