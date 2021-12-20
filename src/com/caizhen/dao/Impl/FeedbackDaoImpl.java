package com.caizhen.dao.Impl;

import com.caizhen.dao.FeedbackDao;
import com.caizhen.model.EpFeedback;
import com.caizhen.model.EpNews;
import com.caizhen.util.DBUtis;
import com.caizhen.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FeedbackDaoImpl implements FeedbackDao {
    private DBUtis utis=new DBUtis();
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int insert1(EpFeedback epFeedback) {
        String sql="insert into ep_feedback(fback_title,fback_content,user_id,fback_datetime) values(?,?,?,?);";
//
        int update = template.update(sql, epFeedback.getFbackTitle(), epFeedback.getFbackContent(), epFeedback.getUserId()
                , epFeedback.getFbackDatetime());
        return update;
    }

    @Override
    public void insert(EpFeedback epFeedback) {

    }

    @Override
    public void update(EpFeedback epFeedback) {
        String sql="update ep_feedback " +
                "set fback_title=?,fback_content=?,fback_datetime=? where fback_id=?;";
//        Object objs[]={epFeedback.getFbackTitle(),epFeedback.getFbackContent(),epFeedback.getFbackDatetime()
//                        ,epFeedback.getFbackId()};
//        utis.getCount(sql,objs);
        int updateFeedback = template.update(sql,epFeedback.getFbackTitle(),epFeedback.getFbackContent(),epFeedback.getFbackDatetime()
                      ,epFeedback.getFbackId() );

    }

    @Override
    public void delete(Integer id) {
        String sql="delete from ep_feedback  where fback_id=?;";
        template.update(sql,id);
    }

    @Override
    public Object selectById(Integer id) {
        String sql="select * from ep_feedback where fback_id= ? ;";
        return template.queryForObject(sql,new BeanPropertyRowMapper<EpFeedback>(EpFeedback.class),id);
    }

    @Override
    public List<EpFeedback> selectAll() {
        String sql="select " +
                "fb.fback_id,fb.fback_title,fb.fback_content,fb.fback_datetime,u.user_name,u.user_rname " +
                "from ep_feedback fb , ep_user u  " ;
//               + "where  1 = 1  ";//fb.user_id = u.user_id
        List<Map<String, Object>> list = template.queryForList(sql);
//        Map<String, Object> map = template.queryForMap(sql);

        for (Map<String, Object> objectMap : list) {
            System.out.println(objectMap);
        }
        return null;
    }
    @Test
    public void test(){
        selectAll();
    }


    @Override
    public List<EpFeedback> selectAll(Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    public int selectAllCount() {
        return 0;
    }

    @Override
    public List<EpFeedback> selectSome(String fbckTitle, String userName, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    public int selectCount(String fbackTitle, String userName) {
        return 0;
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义初始sql
        String sql="select count(*) from ep_feedback where 1 = 1 ";
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
    public List<EpFeedback> findListByPage(int start, int rows, Map<String, String[]> condition) {
        String sql="select * from ep_feedback  where  1 = 1  ";//fb.user_id = u.user_id
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
        List<EpFeedback> list = template.query(sb.toString(),new BeanPropertyRowMapper<EpFeedback>(EpFeedback.class),params.toArray());
//        return template.query(sb.toString(),new BeanPropertyRowMapper<EpProduct>(EpProduct.class),params.toArray());
        return list;

    }
}
