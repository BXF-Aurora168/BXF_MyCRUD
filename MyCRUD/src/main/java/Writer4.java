
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

@WebServlet("/Writer4")
public class Writer4 extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取session
        HttpSession hs = req.getSession(true);
        String na = (String) hs.getAttribute("w_name");
        String value = (String) hs.getAttribute("w_pass");
        //获取日期
        java.util.Date dat = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd");
        //数据库连接
        DB db = new DB();
        //获取旧的文本
        String title = new String(req.getParameter("old_title").getBytes("ISO8859-1"),"UTF-8");
        String text = new String(req.getParameter("old_text").getBytes("ISO8859-1"),"UTF-8");
        int id = Integer.parseInt(req.getParameter("old_id"));
        out.println("<!DOCTYPE html> \n" +
                "<html>\n" +
                "<head><title>" + "修改界面" + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + "修改你的稿件" + "</h1>\n" +
                "<br><input type=\"button\" value=\"点击返回\" onclick=\"location.href='Writer1'\" />"+
                "<form action=\"Writer5\" method=\"POST\">"+
                "<h3>新闻标题</h3><br>"+
                "<input type=\"text\" name=\"modify_title\" value="+ title +"><br>"+
                "<h3>新闻内容</h3>"+
                "<textarea rows=\"15\" cols=\"60\"  name=\"modify_text\" value=>"+
                text +
                "</textarea>"+
                "<h4>作者</h4>"+ na +
                "<input type=\"hidden\" name=\"modify_writer\" value="+ na +">"+
                "<h4>日期</h4>"+ ft.format(dat) +
                "<input type=\"hidden\" name=\"modify_date\" value=" + ft.format(dat) + ">" +
                "<input type=\"hidden\" name=\"modify_id\" value="+ id +">"+
                "<input type=\"submit\" value=\"修改\">"+
                "</form>"  +
                "</body></html>"
        );
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    @Override
    public void destroy() {
    }
}
