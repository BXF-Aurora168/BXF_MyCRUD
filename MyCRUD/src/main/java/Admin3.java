
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

@WebServlet("/Admin3")
public class Admin3 extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取session
        HttpSession hs = req.getSession(true);
        String na = (String) hs.getAttribute("a_name");
        String value = (String) hs.getAttribute("pass");
        //数据库连接
        DB db = new DB();
        //获取旧的文本
        String name = new String(req.getParameter("old_name").getBytes("ISO8859-1"),"UTF-8");
        String password = new String(req.getParameter("old_password").getBytes("ISO8859-1"),"UTF-8");
        String identity = new String(req.getParameter("old_identity").getBytes("ISO8859-1"),"UTF-8");
        int id = Integer.parseInt(req.getParameter("old_id"));

        try {
            String title1 = "修改账户信息";
            out.println("<!DOCTYPE html> \n" +
                    "<html>\n" +
                    "<head><title>" + title1 + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title1 + "</h1>\n" +
                    "<br><input type=\"button\" value=\"点击返回\" onclick=\"location.href='Admin2'\" />"+
                    "<form action=\"AdminModify\" method=\"POST\">" +
                    "账号：<input type=\"text\" name=\"mod_name\" value="+ name +"><br>"+
                    "密码：<input type=\"text\" name=\"mod_password\" value="+ password +"><br>"
            );
            switch (identity){

                case "普通用户":
                    out.println(
                            "登录身份：<input type=\"radio\" name=\"mod_identity\" value=\"普通用户\" checked=\"checked\">普通用户"+
                                    "<input type=\"radio\" name=\"mod_identity\" value=\"撰稿人\">撰稿人"+
                                    "<input type=\"radio\" name=\"mod_identity\" value=\"管理员\">管理员"
                    );
                    break;
                case "撰稿人":
                    out.println(
                            "登录身份：<input type=\"radio\" name=\"mod_identity\" value=\"普通用户\">普通用户"+
                                    "<input type=\"radio\" name=\"mod_identity\" value=\"撰稿人\" checked=\"checked\">撰稿人"+
                                    "<input type=\"radio\" name=\"mod_identity\" value=\"管理员\">管理员"
                    );
                    break;
                case "管理员":
                    out.println(
                            "登录身份：<input type=\"radio\" name=\"mod_identity\" value=\"普通用户\">普通用户"+
                                    "<input type=\"radio\" name=\"mod_identity\" value=\"撰稿人\">撰稿人"+
                                    "<input type=\"radio\" name=\"mod_identity\" value=\"管理员\" checked=\"checked\">管理员"
                    );
                    break;

            }
            out.println(
                            "<br>"+
                            "<input type=\"hidden\" name=\"mod_id\" value="+ id +">"+
                            "<input type=\"submit\" value=\"修改\">" +
                            "</form>" +
                            "<body><html>"
            );
        }catch (Exception e){
            e.printStackTrace();
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
