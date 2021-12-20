package com.caizhen.dao.Impl;

import com.caizhen.dao.NewsDao;
import com.caizhen.model.EpNews;
import com.caizhen.model.EpProduct;
import com.caizhen.util.DBUtis;
import com.caizhen.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class NewsDaoImpl implements NewsDao {
    private DBUtis utis=new DBUtis();
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void insert(EpNews epNews) {
        String sql="insert into ep_news(news_title,news_content,news_datetime) values(?,?,?);";
//        Object objs[]={epNews.getNewsTitle(),epNews.getNewsContent(),epNews.getNewsDatetime()};
//        utis.getCount(sql,objs);
        template.update(sql,epNews.getNewsTitle(),epNews.getNewsContent(),epNews.getNewsDatetime());

    }
/*
    @Test
    public void testInsert(){
        EpNews news=new EpNews("勇士总冠军","库里FMVP",new Date());
        insert(news);
    }
*/



    @Override
    public void update(EpNews epNews) {
        String sql="update ep_news set news_title=?,news_content=? where news_id=?;";
//        Object objs[]={epNews.getNewsTitle(),epNews.getNewsContent(),epNews.getNewsDatetime(),epNews.getNewsId()};
//        utis.getCount(sql,objs);
        int updatenews = template.update(sql, epNews.getNewsTitle(), epNews.getNewsContent(), epNews.getNewsId());
        System.out.println(updatenews+"     updateNEws");
    }
    @Test
    public void test(){
        EpNews epNews=new EpNews();
        epNews.setNewsId(3);
        epNews.setNewsTitle("test");
        epNews.setNewsContent("test");
        epNews.setNewsDatetime(new Date());
        update(epNews);
    }


    @Override
    public void delete(Integer id) {
        String sql="delete from ep_news  where news_id=?;";
//        Object objs[]={id};
//        utis.getCount(sql,objs);
        template.update(sql,id);
    }



    @Override
    public Object selectById(Integer id) {
        String sql="select * from ep_news where news_id= ? ;";
        return template.queryForObject(sql,new BeanPropertyRowMapper<EpNews>(EpNews.class),id);
    }

    @Override
    public List<EpNews> selectAll() {
        String sql = "select * from ep_news";
        List<EpNews> epNewsList=template.query(sql,new BeanPropertyRowMapper<EpNews>(EpNews.class));
        return epNewsList;
    }

    @Test
    public void test1(){
        List<EpNews> epNewsList = selectAll();
        System.out.println(epNewsList);

    }

    @Override
    public List<EpNews> selectAll(Integer pageNo, Integer pageSize) {
        String sql="select * from ep_news limit ?,?";
        int index=(pageNo-1)*pageSize;
        List<EpNews> epNewsList= template.query(sql,new BeanPropertyRowMapper<EpNews>(EpNews.class),
                index,pageSize);
        return epNewsList;
    }


    @Override
    public int selectAllCount() {
        String sql="select count(news_id)" +
                " from ep_news";
        int count= template.queryForObject(sql,Integer.class);
        return count;
    }

    @Override
    public List<EpNews> selectSome(int num) {
        String sql="select * from ep_news" +
//                " where prod_firstShow=1 " +
                " limit 0,? ";
        List<EpNews> epNewsList= template.query(sql,new BeanPropertyRowMapper<EpNews>(EpNews.class),
                num);
        return epNewsList;
    }

    @Override
    public List<EpNews> selectSome(String newsTitle, Integer pageNo, Integer pageSize) {
        String sql="select * from ep_news" +
                " where  news_title=? limit ?,? ;";
        int index=(pageNo-1)*pageSize;
        List<EpNews> epNewsList= template.query(sql,new BeanPropertyRowMapper<EpNews>(EpNews.class),
                newsTitle,index,pageSize);
        return epNewsList;
    }

    @Override
    public int selectCount(String newsTitle) {
        String sql="select count(news_id)" +
                " from ep_news" +
                " where news_title=? ;";
        int count= template.queryForObject(sql,Integer.class,newsTitle);
        return count;
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义初始sql
        String sql="select count(*) from ep_news where 1 = 1 ";
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
    public List<EpNews> findListByPage(int start, int rows, Map<String, String[]> condition) {
        String sql="select * from ep_news where 1=1 ";
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



        List<EpNews> list = template.query(sb.toString(),new BeanPropertyRowMapper<EpNews>(EpNews.class),params.toArray());

//        return template.query(sb.toString(),new BeanPropertyRowMapper<EpProduct>(EpProduct.class),params.toArray());
        return list;
    }
}
