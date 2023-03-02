package com;

import java.sql.*;

public class DB {
    public Connection conn = null;
    public Statement stmt = null;
    public ResultSet rs = null;
    String url = "jdbc:mysql://localhost:3306/test001?useSSL=false&serverTimezone=UTC";
    String username = "root";
    String password = "1506583922";
    public DB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            stmt = conn.createStatement();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            if (rs!=null){
                rs.close();
            }
            if (stmt!=null){
                stmt.close();
            }
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
