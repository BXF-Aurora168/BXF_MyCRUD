
import Dao.DaoCrud;
import com.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/Register")
public class Register extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = resp.getWriter();

            String title1 = "注册";
            out.println("<!DOCTYPE html> \n" +
                    "<html>\n" +
                    "<head><title>" + title1 + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title1 + "</h1>\n" +
                    "<form action=\"RegJudge\" method=\"POST\">" +
                    "账号：<input type=\"text\" name=\"reg_name\"><br>"+
                    "密码：<input type=\"password\" name=\"reg_password\"><br>" +
                    "登录身份：<input type=\"radio\" name=\"reg_identity\" value=\"普通用户\">普通用户"+
                    "<input type=\"radio\" name=\"reg_identity\" value=\"撰稿人\">撰稿人"+
                    "<br>"+
                    "<input type=\"submit\" value=\"注册\">" +
                    "</form>" +
                    "<br><input type=\"button\" value=\"点击返回\" onclick=\"location.href='Login'\" />"+
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
