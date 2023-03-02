import com.DB;

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

@WebServlet("/Admin1")
public class Admin1 extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //得到session
        HttpSession hs = req.getSession(true);
        String na = (String) hs.getAttribute("a_name");
        String value = (String) hs.getAttribute("pass");
        // 获取日期格式 yyyy.MM.dd  hh:mm:ss E a
        Date dat = new Date();
        SimpleDateFormat ft =
                new SimpleDateFormat("yyyy.MM.dd");
        //连接数据库，创建数据库对象
        DB db = new DB();
        //判断
        try {
            out.println("<!DOCTYPE html> \n" +
                    "<html>\n" +
                    "<head><title>" + "管理员界面" + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + "管理员界面" + "</h1>\n" +
                    "<h3 align=\"center\">" + "管理员，你好 " + na + "</h3>\n" +
                    "<h3 align=\"center\">" + "现在的日期 " + ft.format(dat) + "</h3>\n"+
                    "<br><input type=\"button\" value=\"点击返回登录页面\" onclick=\"location.href='Login'\" />"+
                    "<form action=\"Admin2\" method=\"POST\">" +
                    "<input type=\"submit\" value=\"管理用户信息\">"+
                    "</form>"
            );
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
