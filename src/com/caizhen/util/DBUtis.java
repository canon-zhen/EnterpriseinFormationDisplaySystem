package com.caizhen.util;

import com.mysql.jdbc.Driver;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;

//import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * 数据库连接工具类（普通）
 */
public class DBUtis {
    //四个常量
    //驱动类
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/softproyang";
    private final String user = "root";
    private final String password = "cz148313";
    private java.sql.Connection conn;//连接

    //获取连接
    public Connection getConnection() throws Exception{
        Class.forName(driver);//加载驱动
        //建立连接
        this.conn=  DriverManager.getConnection(url,user,password);
        return conn;
    }
    //操作数据库
    private PreparedStatement pstm;
    public PreparedStatement getPstm(String sql,Object[] objects) throws Exception {
        this.conn=getConnection();
        //发送SQl语句
        this.pstm=this.conn.prepareStatement(sql);
        //执行
        //处理占位符
        for(int i=0;i<objects.length;i++){
            this.pstm.setObject(i+1,objects[i]);
        }
        this.pstm.execute();
        return pstm;
    }
    private int count;
    public int getCount(String sql, Object[] objects){
        try {
            this.pstm=this.getPstm(sql,objects);
            count = this.pstm.getUpdateCount();//数据库受影响的条数
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ResultSet getResultSet(String sql, Object[] objects){
        try {
            this.getPstm(sql,objects);
            return this.pstm.getResultSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        DBUtis utis=new DBUtis();

//        System.out.println(utis.getConnection());
//        String sql="insert into ep_category(cat_name) VALUES('蔡振23');";
//        //String sql="DELETE FROM ep_category where cat_id=4;";
//        System.out.println(utis.getPstm(sql));
//        String sql="insert into ep_category(cat_id,cat_name) VALUES(?,?);";//占位符
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("id:");String one= scanner.next();
//        System.out.println("name:");String two= scanner.next();
//        Object obj[]={one,two};
        String sql="DELETE FROM ep_category where cat_id = ? ;";//占位符
        Scanner scanner=new Scanner(System.in);
        Object obj[]={1};
        //utis.getPstm(sql,obj);
        System.out.println(utis.getPstm(sql,obj));
    }




}
