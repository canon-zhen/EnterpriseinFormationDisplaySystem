package com.caizhen.service.Impl;

import com.caizhen.dao.Impl.ProductDaoImpl;
import com.caizhen.dao.ProductDao;
import com.caizhen.model.EpProduct;
import com.caizhen.model.EpUser;
import com.caizhen.model.PageBean;
import com.caizhen.service.ProductService;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao =new ProductDaoImpl();
    @Override
    public void addProduct(EpProduct product) {
        System.out.println(product.getProdImage());
       /* File file=new File(product.getProdImage());

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getName());
*/
        productDao.insert(product);
    }

    @Override
    public void editProduct(EpProduct product) {
        productDao.update(product);
    }

    @Override
    public void deleteProduct(Integer prodId) {
        productDao.delete(prodId);
    }

    @Override
    public EpProduct findProductById(Integer prodId) {
        return (EpProduct) productDao.selectById(prodId);
    }

    @Override
    public List<EpProduct> findProducts(Integer catId, String prodName, String sortExp, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    public int findCount(Integer catId, String prodName) {
        return 0;
    }

    @Override
    public List<EpProduct> findProductsForFirst(int num) {
        return null;
    }

    @Override
    public PageBean<EpProduct> findProductByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows=Integer.parseInt(_rows);
        if (currentPage <=0){
            currentPage=1;
        }
        //创建空的PageBean对象
        PageBean<EpProduct> pageBean=new PageBean<EpProduct>();
        //设置参数
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        //调用Dao查询总记录数
        int totalCount=productDao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);
        //调用Dao查询list集合
        //计算开始的索引
        int start=(currentPage-1)*rows;
        List<EpProduct> list=productDao.findListByPage(start,rows,condition);
        pageBean.setList(list);

        //总页码
        int totalPage=(totalCount % rows)==0 ? totalCount/rows : (totalCount/rows)+1;
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }

    @Override
    public void deleteSelectedPro(String[] ids) {
        if (ids!=null&&ids.length>0){
            for (String id : ids) {
                productDao.delete(Integer.parseInt(id));
            }
        }
    }


}
