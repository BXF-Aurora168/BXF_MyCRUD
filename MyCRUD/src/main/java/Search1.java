
import Dao.DaoCrud;
import com.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/Search1")
public class Search1 extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取session
        HttpSession hs = req.getSession(true);
        String na = (String) hs.getAttribute("u_name");
        String value = (String) hs.getAttribute("pass");
        //获取日期
        java.util.Date dat = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd");
        String putin = new String(req.getParameter("put_in").getBytes("ISO8859-1"),"UTF-8");
        //数据库连接
        DB db = new DB();
        try {
            out.println("<!DOCTYPE html> \n" +
                    "<html>\n" +
                    "<head><title>" + "搜索界面" + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + "搜索结果" + "</h1>\n" +
                    "<br><input type=\"button\" value=\"点击返回主菜单\" onclick=\"location.href='User1'\" />"
            );
            db.rs = db.stmt.executeQuery("SELECT * FROM news_info WHERE news_title LIKE " + "'%" + putin + "%'");
            while (db.rs.next()) {
                out.println("<br>");
                String title = db.rs.getString("news_title");
                String text = db.rs.getString("news_text");
                String writer = db.rs.getString("news_writer");
                String date = db.rs.getString("news_date");
                int id = db.rs.getInt("news_id");
                out.println(title);
                out.println("<br>");
                out.println(text);
                out.println("<br>");
                out.print("作者" + writer);
                out.print("日期: " + date);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    @Override
    public void destroy() {
    }
}
