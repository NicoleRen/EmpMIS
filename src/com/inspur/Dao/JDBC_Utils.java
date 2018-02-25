package com.inspur.Dao;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class JDBC_Utils {
    private static String driver=null;    // 数据库连接驱动
	private static String url=null; 
    private static String user=null;
	private static String password=null;
   static{
		  try{  
			   InputStream in=JDBC_Utils.class.getClassLoader().getResourceAsStream("db.properties");
			   Properties prop =new Properties();
			   prop.load(in);
			    driver = prop.getProperty("driver");
			    url=prop.getProperty("url");
			    user=prop.getProperty("user");
			    password=prop.getProperty("password");
			    Class.forName(driver);     //加载驱动  
		   }  catch (Exception e) {
			   e.printStackTrace();
			   }  //catch  
		  }     //static
   public static Connection getConnection() throws SQLException{   //连接数据库
		  return DriverManager.getConnection(url,user,password);} 
   public static void release(Connection conn,Statement st,ResultSet rs){ //释放数据库资源
	   if (rs!=null) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();}}
	   if (st!=null) {
		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();}}
	   if (conn!=null) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();}}}}

