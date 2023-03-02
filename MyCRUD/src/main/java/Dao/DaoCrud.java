package Dao;

import com.DB;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoCrud {
    public DaoCrud(){

    }
    public void AddNews(String title,String text,String writer,String date){
        DB db = new DB();
        PreparedStatement preparedStatement=null;
        try {
            String sql = "INSERT INTO news_info (news_title,news_text,news_writer,news_date) values (?,?,?,?)";
            preparedStatement=db.conn.prepareStatement(sql);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,text);
            preparedStatement.setString(3,writer);
            preparedStatement.setString(4,date);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
        }
    }
    public void AddUser(String name,String pass,String ident){
        DB db = new DB();
        PreparedStatement preparedStatement=null;
        try {
            String sql = "INSERT INTO user_info (user_name,user_password,user_identity) values (?,?,?)";
            preparedStatement=db.conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,pass);
            preparedStatement.setString(3,ident);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
        }
    }
    public void UpdateNews(String title,String text,String writer,String date,int id){
        DB db = new DB();
        PreparedStatement preparedStatement=null;
        try {
            String sql = "UPDATE news_info SET news_title=?, news_text=?, news_writer=?, news_date=? WHERE news_id=?";
            preparedStatement=db.conn.prepareStatement(sql);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,text);
            preparedStatement.setString(3,writer);
            preparedStatement.setString(4,date);
            preparedStatement.setInt(5,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{

        }
    }
    public void UpdateName(String name,String pass,String ident,int id){
        DB db = new DB();
        PreparedStatement preparedStatement=null;
        try {
            String sql = "UPDATE user_info SET user_name=?, user_password=?, user_identity=? WHERE user_id=?";
            preparedStatement=db.conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,pass);
            preparedStatement.setString(3,ident);
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{

        }
    }
    public void DeleteNews(int id){
        DB db = new DB();
        PreparedStatement preparedStatement=null;
        try {
            String sql = "DELETE FROM news_info WHERE news_id=?";
            preparedStatement=db.conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
        }
    }
    public void DeleteName(int id){
        DB db = new DB();
        PreparedStatement preparedStatement=null;
        try {
            String sql = "DELETE FROM user_info WHERE user_id=?";
            preparedStatement=db.conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
        }
    }

}
