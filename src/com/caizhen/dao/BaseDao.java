package com.caizhen.dao;


import java.util.List;

public interface BaseDao<T> {
    void insert(T t);
    void update(T t);
    void delete(Integer id);
    Object selectById(Integer id);
    List<T> selectAll();
    List<T> selectAll(Integer pageNo, Integer pageSize);
    int selectAllCount();

}
