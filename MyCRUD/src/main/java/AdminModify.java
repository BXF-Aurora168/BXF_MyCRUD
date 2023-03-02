
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

@WebServlet("/AdminModify")
public class AdminModify extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取session
//        HttpSession hs = req.getSession(true);
//        String na = (String) hs.getAttribute("a_name");
//        String value = (String) hs.getAttribute("pass");
//        DB db = new DB();
        //获取表单信息
        String name_check =req.getParameter("mod_name");
        String password_check =req.getParameter("mod_password");
        String identity_check =req.getParameter("mod_identity");

        String name = new String(req.getParameter("mod_name").getBytes("ISO8859-1"),"UTF-8");
        String password = new String(req.getParameter("mod_password").getBytes("ISO8859-1"),"UTF-8");
        String identity = new String(req.getParameter("mod_identity").getBytes("ISO8859-1"),"UTF-8");
        int id = Integer.parseInt(req.getParameter("mod_id"));

        try {
            //检测内容是否为空
            if(name_check==""||password_check==""||identity_check==""){
                out.println("<!DOCTYPE html> \n" +
                        "<html>\n" +
                        "<head><title>" + "失败" + "</title></head>\n" +
                        "<body bgcolor=\"#f0f0f0\">\n" +
                        "<h1 align=\"center\">" + "修改失败，不能为空" + "</h1>\n" +
                        "<input type=\"button\" value=\"点击返回\" onclick=\"location.href='Admin2'\" />"
                );
            }else {
                DaoCrud crud = new DaoCrud();
                crud.UpdateName(name,password,identity,id);
                out.println("<!DOCTYPE html> \n" +
                        "<html>\n" +
                        "<head><title>" + "修改成功" + "</title></head>\n" +
                        "<body bgcolor=\"#f0f0f0\">\n" +
                        "<h1 align=\"center\">" + "修改成功" + "</h1>\n" +
                        "<input type=\"button\" value=\"点击返回\" onclick=\"location.href='Admin2'\" />"
                );
            }
            out.println("</body></html>");
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
