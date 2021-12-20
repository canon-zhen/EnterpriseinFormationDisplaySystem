package com.caizhen.dao.Impl;

import com.caizhen.dao.CategoryDao;
import com.caizhen.model.EpCategory;
import com.caizhen.model.EpFeedback;
import com.caizhen.util.DBUtis;
import com.caizhen.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CategoryDaoImpl implements CategoryDao {
    private DBUtis utis=new DBUtis();
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void insert(EpCategory category) {
        String sql="insert into ep_category(cat_name) values(?);";
        template.update(sql,category.getCatName());
    }

    @Override
    public void update(EpCategory category) {
        String sql="update ep_category set cat_name=? where cat_id=?;";
        /*Object objs[]={category.getCatName(),category.getCatId()};
        utis.getCount(sql,objs);*/
        template.update(sql,category.getCatName(),category.getCatId());
    }

    @Override
    public void delete(Integer id) {
        String sql="delete from ep_category  where cat_id=?";

        template.update(sql,id);
    }
  /*  @Test
    public void TestDelete(){
        delete(6);
    }*/

    @Override
    public Object selectById(Integer id) {
        String sql="select * from ep_category  where cat_id=? ;";
        return template.queryForObject(sql,new BeanPropertyRowMapper<EpCategory>(EpCategory.class),id);
    }

    @Override
    public List<EpCategory> selectAll() {
        return null;
    }

    @Override
    public List<EpCategory> selectAll(Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    public int selectAllCount() {
        return 0;
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义初始sql
        String sql="select count(*) from ep_category where 1 = 1 ";
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
    public List<EpCategory> findListByPage(int start, int rows, Map<String, String[]> condition) {
        String sql="select * from ep_category  where  1 = 1  ";//fb.user_id = u.user_id
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
        List<EpCategory> list = template.query(sb.toString(),new BeanPropertyRowMapper<EpCategory>(EpCategory.class),params.toArray());
//        return template.query(sb.toString(),new BeanPropertyRowMapper<EpProduct>(EpProduct.class),params.toArray());
        return list;
    }
}
