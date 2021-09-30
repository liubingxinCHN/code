package com.bx.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;

    static {
        try {
            //1.加载配置文件
            Properties pro = new Properties();
            pro.load(com.bx.utils.JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties"));
            //2.获取DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        }
        catch (Exception e){
            ds = null;
        }
    }

    private static Connection getConnection(){
        Connection con;
        try {
            con = ds.getConnection();
        }
        catch (Exception ex){
            con = null;
        }
        return con;
    }

    /**
     * 执行查询 SQL语句
     */
    public static ResultSet query(String sql, Object[] params) throws Exception{
        ResultSet rs = null;
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        //如果sql含有？，则需要在命令对象中注册对应的参数
        if (params != null){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1,params[i]);
            }
        }
        rs = ps.executeQuery();
        return  rs;
    }

    /**
     * 执行增删改SQL语句
     */
    public static int update(String sql,Object[] params) throws Exception{
        int r = -1;
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        //如果sql含有？，则需要在命令对象中注册对应的参数
        if (params != null){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1,params[i]);
            }
        }
        r = ps.executeUpdate();
        return  r;
    }

    /**
     * 执行聚合查询（单行记录）
     */
    public static List<Object> scalar(String sql, Object[] params) throws Exception{
        List<Object> objects = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        //如果sql含有？，则需要在命令对象中注册对应的参数
        if (params != null){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1,params[i]);
            }
        }
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            // 获取记录的总列数：
            int cols = rs.getMetaData().getColumnCount();
            for (int i=0; i<cols; i++){
                objects.add(rs.getObject(i+1));
            }
        }
        return  objects;
    }

    /* 获取 QueryRunner */
    public static QueryRunner getQueryRunner(){
        QueryRunner runner = new QueryRunner(ds);
        return runner;
    }

    public static CallableStatement getStatement(String sql) throws Exception{
        CallableStatement call = getConnection().prepareCall(sql);
        return call;
    }
}
