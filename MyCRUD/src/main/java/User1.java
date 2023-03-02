import com.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

@WebServlet("/User1")
public class User1 extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //得到session
        HttpSession hs = req.getSession(true);
        String na = (String) hs.getAttribute("u_name");
        String value = (String) hs.getAttribute("u_pass");
        // 获取日期格式 yyyy.MM.dd  hh:mm:ss E a
        Date dat = new Date();
        SimpleDateFormat ft =
                new SimpleDateFormat("yyyy.MM.dd");
        //连接数据库，创建数据库对象
        DB db = new DB();
        //判断
        if (value!="ok"){
            try {
                //非法登录
                resp.sendRedirect("Login");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        try {
            out.println("<!DOCTYPE html> \n" +
                    "<html>\n" +
                    "<head><title>" + "用户界面" + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + "用户界面：浏览新闻" + "</h1>\n" +
                    "<h3 align=\"center\">" + "成功登录，你的用户名是 " + na + "</h3>\n" +
                    "<h3 align=\"center\">" + "现在的日期 " + ft.format(dat) + "</h3>\n"+
                    "<br><input type=\"button\" value=\"点击返回\" onclick=\"location.href='Login'\" />"+
                    "<form action=\"Search1\" method=\"POST\">" +
                    "<input type=\"text\" name=\"put_in\">"+
                    "<input type=\"submit\" value=\"搜索\">"+
                    "</form>"
            );
            db.rs = db.stmt.executeQuery("SELECT news_title,news_text,news_writer,news_date FROM news_info");
            while (db.rs.next()) {
                out.println("<br>");
                String title = db.rs.getString("news_title");
                String text = db.rs.getString("news_text");
                String writer = db.rs.getString("news_writer");
                String date = db.rs.getString("news_date");

                out.println(title);
                out.println("<br>");
                out.println(text);
                out.println("<br>");
                out.println("作者" + writer);
                out.println("日期: " + date);
                out.println("<br>");
                out.println("<br>");
            }
                out.println("</body></html>");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.close();
        }


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    @Override
    public void destroy() {

    }
}
