package com.caizhen.dao.Impl;

import com.caizhen.dao.ProductDao;

import com.caizhen.model.EpProduct;

import com.caizhen.util.JDBCUtils;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductDaoImpl implements ProductDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void insert(EpProduct product) {
        System.out.println(product.toString());
        String sql="insert into" +
                " ep_product (cat_id,prod_name,prod_type,prod_price,prod_image,prod_desc,prod_datetime,prodFirstShow)" +
                " values(?,?,?,?,?,?,?,?);";

        int charu = template.update(sql, product.getCatId(), product.getProdName(), product.getProdType(),
                product.getProdPrice(), product.getProdImage(), product.getProdDesc()
                , product.getProdDatetime(), product.getProdFirstShow());
        System.out.println(charu+"插入产品影响条数");
    }
/*    @Test
    public void testInsert(){
        EpProduct t=new EpProduct();
        EpCategory category=new EpCategory();
        category.setCatId(2);
        t.setEpCategory(category);
        t.setProdName("苹果");
        Date prodDateTime=new Date();
        t.setProdDatetime( prodDateTime);
        insert(t);
    }*/
    @Override
    public void update(EpProduct product) {
        String sql="update ep_product set cat_id=?,prod_name=?,prod_type=?,prod_price=?,prod_image=?," +
                "prod_desc=?,prod_datetime=?,prodFirstShow=?   where prod_id=?;";

        //utis.getCount(sql,objs);
        template.update(sql, product.getCatId(), product.getProdName(), product.getProdType(),
                product.getProdPrice(), product.getProdImage(), product.getProdDesc()
                , product.getProdDatetime(), product.getProdFirstShow(), product.getProdId());
    }

    @Override
    public void delete(Integer id) {
        String sql="delete from ep_product  where prod_id=?;";
       // utis.getCount(sql,objs);
        int delete = template.update(sql, id);
        System.out.println("产品删除 "+delete);
    }


/*
    private List<EpProduct>  epProductsList=new ArrayList<EpProduct>();
    private EpProduct product=null;

    private void rsToList(ResultSet rs){
        product=null;
        try {
            while (rs.next()){
                int proId=rs.getInt(1);
                int catId=rs.getInt(2);
                String prodName=rs.getString(3);
                EpProduct product=new EpProduct();
                product.setProdId(proId);
                product.setCatId(catId);
                product.setProdName(prodName);
                epProductsList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/

    @Override
    public List<EpProduct> selectAll(Integer pageNo, Integer pageSize) {
        //String sql="select * from ep_product where prod_id=?";
        String sql="select * from product limit ?,?";
        int index = (pageNo-1)*pageSize;
        Object objs[] = {index,pageSize};
        //ResultSet resultSet = utis.getResultSet(sql,objs);

        //rsToList(resultSet);
        //return epProductsList;
        return null;

    }

    public List<EpProduct> selectAllByPage(Integer pageNo, Integer pageSize){
        String sql="select * from ep_product limit ?,?";
        int index=(pageNo-1)*pageSize;
        List<EpProduct> productList= template.query(sql,new BeanPropertyRowMapper<EpProduct>(EpProduct.class),
                                    index,pageSize);
        return productList;
    }


    @Override
    public Object selectById(Integer id) {
        String sql="select * from ep_product where prod_id= ? ;";
        return template.queryForObject(sql,new BeanPropertyRowMapper<EpProduct>(EpProduct.class),id);
    }
    @Test
    public void testOne(){
        System.out.println(selectById(13));
    }

    @Override
    public List<EpProduct> selectAll() {
        String sql = "select * from ep_product  ";
        List<EpProduct> AllproductList=template.query(sql,new BeanPropertyRowMapper<EpProduct>(EpProduct.class));
        return AllproductList;
    }
    @Test
    public void test(){
        System.out.println(selectAll());
    }

//    @Test
//    public void testSelect(){
//        System.out.println(selectById(3));
////        System.out.println(selectAll());
//        //System.out.println(selectAll());
//    }
//    @Override
//    public List<EpProduct> selectAll(Integer pageNo, Integer pageSize) {
//        return null;
//    }

    @Override
    public int selectAllCount() {
        String sql="select count(prod_id)" +
                " from ep_product";
        int count= template.queryForObject(sql,Integer.class);
        return count;
    }
  /*  @Test
    public void testCount(){
        System.out.println(selectAllCount());
    }*/

    @Override
    public List<EpProduct> selectSome(Integer catId, String prodName, Integer pageNo, Integer pageSize) {
        String sql="select * from ep_product" +
                    " where cat_id=? and prod_name=? limit ?,? ;";
        int index=(pageNo-1)*pageSize;
        //Object objs[]={catId,prodName,index,pageSize};
        List<EpProduct> productList= template.query(sql,new BeanPropertyRowMapper<EpProduct>(EpProduct.class),
                catId,prodName,index,pageSize);
        return productList;
    }

    @Override
    public List<EpProduct> selectSome(int num) {
        String sql="select * from ep_product" +
                " where prodFirstShow=1 " +
                " limit 0,? ";
        List<EpProduct> productList= template.query(sql,new BeanPropertyRowMapper<EpProduct>(EpProduct.class),
                num);
        return productList;

    }

    @Override
    public int selectCount(Integer catId, String prodName) {
        String sql="select count(prod_id)" +
                " from ep_product" +
                " where cat_id=? and prod_name=? ;";
        int count= template.queryForObject(sql,Integer.class,catId,prodName);
        return count;
    }







    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义初始sql
        String sql="select count(*) from ep_product where 1 = 1 ";
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
    public List<EpProduct> findListByPage(int start, int rows, Map<String, String[]> condition) {
        String sql="select * from ep_product where 1=1 ";
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
        System.out.println(params+"     productParams");

        List<EpProduct> list = template.query(sb.toString(),new BeanPropertyRowMapper<EpProduct>(EpProduct.class),params.toArray());
        System.out.println(list+"            productdao");
//        return template.query(sb.toString(),new BeanPropertyRowMapper<EpProduct>(EpProduct.class),params.toArray());
        return list;
    }








}
