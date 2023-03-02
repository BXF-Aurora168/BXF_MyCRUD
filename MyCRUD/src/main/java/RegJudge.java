
import Dao.DaoCrud;
import com.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/RegJudge")
public class RegJudge extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name =new String(request.getParameter("reg_name").getBytes("ISO8859-1"),"UTF-8");
        String password = new String(request.getParameter("reg_password").getBytes("ISO8859-1"),"UTF-8");
        String identity = new String(request.getParameter("reg_identity").getBytes("ISO8859-1"),"UTF-8");

        try {
            DB db = new DB();
            DaoCrud crud = new DaoCrud();

            if(identity==""||password==""||name==""){
                out.println("<!DOCTYPE html> \n" +
                        "<html>\n" +
                        "<head><title>" + "提交失败" + "</title></head>\n" +
                        "<body bgcolor=\"#f0f0f0\">\n" +
                        "<h1 align=\"center\">" + "提交失败，标题或内容不能为空" + "</h1>\n" +
                        "<input type=\"button\" value=\"点击返回\" onclick=\"location.href='Register'\" />"+
                        "</body></html>"
                );
            }else {
                crud.AddUser(name,password,identity);
                out.println("<!DOCTYPE html> \n" +
                        "<html>\n" +
                        "<head><title>" + "注册成功" + "</title></head>\n" +
                        "<body bgcolor=\"#f0f0f0\">\n" +
                        "<h1 align=\"center\">" + "注册成功" + "</h1>\n" +
                        "<input type=\"button\" value=\"点击返回登录\" onclick=\"location.href='Login'\" />"+
                        "</body></html>"
                );
            }
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
