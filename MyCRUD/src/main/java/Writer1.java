
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

@WebServlet("/Writer1")
public class Writer1 extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession hs = req.getSession(true);
        //获取姓名
        String na = (String) hs.getAttribute("w_name");
        String value = (String) hs.getAttribute("w_pass");
        //获取日期
        Date dat = new Date();
        SimpleDateFormat ft =
                new SimpleDateFormat("yyyy.MM.dd");
        out.println("<!DOCTYPE html> \n" +
                "<html>\n" +
                "<head><title>" + "撰稿界面" + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + "发布你的稿件" + "</h1>\n" +
                "<h3 align=\"center\">" + "撰稿人成功登录，你的用户名是 " + na + "</h3>\n"+
                "<h3 align=\"center\">" + "现在的日期 " + ft.format(dat) + "</h3>\n"+
                "<br><input type=\"button\" value=\"点击返回\" onclick=\"location.href='Login'\" />"+
                "<form action=\"Writer2\" method=\"POST\">"+
                "<h3>新闻标题</h3><br>"+
                "<input type=\"text\" name=\"publish_title\" size=\"65\"><br>"+
                "<h3>新闻内容</h3>"+
                "<textarea rows=\"15\" cols=\"60\"  name=\"publish_text\">"+
                "</textarea>"+
                "<h4>作者</h4>"+ na +
                "<input type=\"hidden\" name=\"publish_writer\" value="+ na +"><br>"+
                "<h4>日期</h4>"+ ft.format(dat) +
                "<input type=\"hidden\" name=\"publish_date\" value=" + ft.format(dat) + "><br>" +
                "<input type=\"submit\" value=\"发布我的稿件\">"+
                "</form>"+
                "<form id=\"form1\" name=\"form1\" method=\"POST\" action=\"Writer3\">" +
                "<input type=\"submit\" value=\"查看并修改稿件\">"+
                "</form>"+
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
