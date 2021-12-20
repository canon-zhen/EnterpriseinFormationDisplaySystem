package com.caizhen.util;

import com.caizhen.model.EpUser;
import com.caizhen.service.Impl.UserServiceImpl;
import com.caizhen.service.UserService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class jdbcTest {
    public static void main(String[] args) {
       // UserService userService=new UserServiceImpl();
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        EpUser User=new EpUser();
        EpUser epUser=new EpUser();
        User.setUserName("bingbing");
        User.setUserPwd("520");
        try{
            String sql="select * from ep_user where user_name= ? and user_pwd= ?";
            epUser = template.queryForObject(sql,
                    new BeanPropertyRowMapper<EpUser>(EpUser.class),
                    User.getUserName(),User.getUserPwd());
        }catch (Exception e){
            System.out.println("通过用户名和密码查询epuser失败");
            e.printStackTrace();
        }
        System.out.println(epUser);

    }
}
