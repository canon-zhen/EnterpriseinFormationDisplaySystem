package com.caizhen.dao.Impl;

import com.caizhen.dao.UserDao;
import com.caizhen.model.EpProduct;
import com.caizhen.model.EpUser;
import com.caizhen.model.PageBean;
import com.caizhen.util.DBUtis;
import com.caizhen.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void insert(EpUser epUser) {
        String sql="insert into " +
                "ep_user(user_name,user_pwd,user_rname,user_email,user_company,user_tel,user_fax,user_datetime,user_right)" +
                " values(?,?,?,?,?,?,?,?,?);";
        int insertNameAndPwd=template.update(sql,epUser.getUserName(),epUser.getUserPwd(),epUser.getUserRname(),
                epUser.getUserEmail(),epUser.getUserCompany(),epUser.getUserTel(),epUser.getUserFax(),
                epUser.getUserDatetime(),epUser.getUserRight());
        System.out.println(insertNameAndPwd+"   UserDaoImpl_insert");
    }

    @Override
    public void update(EpUser epUser) {
        String sql="update ep_user " +
                "set user_name=?,user_pwd=?,user_rname=?,user_email=?,user_company=?, user_tel=?,user_fax=?,user_datetime=?,user_right=? " +
                " where user_id=?;";
        int update = template.update(sql,epUser.getUserName(),epUser.getUserPwd(),epUser.getUserRname(),
                epUser.getUserEmail(),epUser.getUserCompany(),epUser.getUserTel(),epUser.getUserFax(),
                epUser.getUserDatetime(),epUser.getUserRight(),
                epUser.getUserId());
        System.out.println(update+"    UserDaoImpl_update");
    }
    @Test
    public void testUpdate(){
        EpUser epUser=new EpUser(1,"bingbing","520","王冰冰","34@qq.com",
                "半月","555","232",new Date(),0);
        update(epUser);
    }

    @Override
    public void delete(Integer id) {
        String sql="delete from ep_user  where user_id=?;";
        int deleteById= template.update(sql,id);
        System.out.println(deleteById+"     UserDaoImpl_delete");
    }

    @Override
    public Object selectById(Integer id) {
        try{
            String sql="select * from ep_user where user_id= ?";
            EpUser epUser = template.queryForObject(sql,
                    new BeanPropertyRowMapper<EpUser>(EpUser.class),
                    id);
            return epUser;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("selectByYd异常");
            return null;
        }
    }

    @Override
    public List<EpUser> selectAll() {
        //定义sql
        String sql="select * from ep_user " ;
        //String s2="SELECT area_id FROM sys_area WHERE area_code LIKE ";

        List<EpUser> epUsersList = template.query(sql, new BeanPropertyRowMapper<EpUser>(EpUser.class));
        return epUsersList;
    }

    @Override
    public EpUser findUserByUsername(String username) {
        try {
            //定义sql
//            String sql="select * from student where username= ? ";
            String sql="select * from ep_user where user_name= ? ";
            EpUser epUser = template.queryForObject(sql, new BeanPropertyRowMapper<EpUser>(EpUser.class), username);
            return epUser ;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void test(){
        System.out.println(selectAll());
    }


    @Override
    public List<EpUser> selectAll(Integer pageNo, Integer pageSize) {
        return null;
    }


    @Override
    public int selectAllCount() {
        return 0;
    }

    @Override
    public EpUser selectOne(String userName, String userPwd) {
        try{
            String sql="select * from ep_user where user_name= ? and user_pwd= ?";
            EpUser epUser = template.queryForObject(sql,
                    new BeanPropertyRowMapper<EpUser>(EpUser.class),
                    userName, userPwd);
            return epUser;
        }catch (Exception e){
            System.out.println("通过用户名和密码查询epuser失败");
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void selectOneTest(){

        EpUser epUser = selectOne("bingbing", "520");
        System.out.println(epUser);
    }

    @Override
    public int selectCount() {
        return 0;
    }



    public int findTotalCount(Map<String, String[]> condition) {
        //定义初始sql
        String sql="select count(*) from ep_user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> params=new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if ( "currentPage".equals(key) || "rows".equals(key) ){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value!=null&& !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%"); //sql语句中？的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }
    @Override
    public List<EpUser> findListByPage(int start, int rows, Map<String, String[]> condition) {
        String sql="select * from ep_user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> params=new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if ( "currentPage".equals(key) || "rows".equals(key) ){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value!=null&& !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%"); //sql语句中？的值
            }
        }
        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);

        System.out.println(sb.toString());
        System.out.println(params);
        List<EpUser> list=template.query(sb.toString(),new BeanPropertyRowMapper<EpUser>(EpUser.class),params.toArray());
        System.out.println(list+"               userdao");
//        return template.query(sb.toString(),new BeanPropertyRowMapper<EpUser>(EpUser.class),params.toArray());
        return  list;
    }

}
