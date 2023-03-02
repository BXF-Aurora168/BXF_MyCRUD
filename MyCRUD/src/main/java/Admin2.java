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

@WebServlet("/Admin2")
public class Admin2 extends HttpServlet {
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
//        if (value==null){
//            try {
//                //非法登录
//                resp.sendRedirect("Login");
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
        try {
            out.println("<!DOCTYPE html> \n" +
                    "<html>\n" +
                    "<head><title>" + "管理员界面" + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + "管理员界面" + "</h1>\n" +
                    "<h3 align=\"center\">" + "管理员用户信息 " + na + "</h3>\n" +
                    "<br><input type=\"button\" value=\"点击返回\" onclick=\"location.href='Admin1'\" />"
            );
            db.rs = db.stmt.executeQuery("SELECT user_name, user_password, user_identity, user_id FROM user_info");
            while (db.rs.next()) {
                out.println("<br>");

                String name = db.rs.getString("user_name");
                String password = db.rs.getString("user_password");
                String identity = db.rs.getString("user_identity");
                int id  = db.rs.getInt("user_id");
                out.println("<br>");
                out.println("账号:" + name);
                out.println("密码:" + password);
                out.println("身份:" + identity);
                out.println("<br>");
                out.println("<form action=\"Admin3\" method=\"POST\">"+
                        "<input type=\"hidden\" name=\"old_name\" value="+ name +">"+
                        "<input type=\"hidden\" name=\"old_password\" value="+ password +">"+
                        "<input type=\"hidden\" name=\"old_identity\" value="+ identity +">"+
                        "<input type=\"hidden\" name=\"old_id\" value="+ id +">"+
                        "<input type=\"submit\" value=\"修改此账户\">"+
                        "</form>"+
                        "<form method=\"POST\" action=\"Admin4\">" +
                        "<input type=\"hidden\" name=\"delete_name\" value="+ name +">"+
                        "<input type=\"hidden\" name=\"delete_id\" value="+ id +">"+
                        "<input type=\"submit\" value=\"删除此账户\">"+
                        "</form>"
                );
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
