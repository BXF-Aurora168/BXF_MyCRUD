import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = resp.getWriter();

            String title1 = "登录";
            out.println("<!DOCTYPE html> \n" +
                    "<html>\n" +
                    "<head><title>" + title1 + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title1 + "</h1>\n" +
                    "<form action=\"LoginJudge\" method=\"POST\">" +
                    "账号：<input type=\"text\" name=\"put_name\"><br>"+
                    "密码：<input type=\"password\" name=\"put_password\"><br>" +
                    "登录身份：<input type=\"radio\" name=\"put_identity\" value=\"普通用户\">普通用户"+
                    "<input type=\"radio\" name=\"put_identity\" value=\"撰稿人\">撰稿人"+
                    "<input type=\"radio\" name=\"put_identity\" value=\"管理员\">管理员"+
                    "<br>"+
                    "<input type=\"submit\" value=\"登录\">" +
                    "</form>" +
                    "<form action=\"Register\" method=\"POST\">" +
                    "<input type=\"submit\" value=\"注册\">"+
                    "</form>"+
                    "<body><html>"
            );
        }catch (Exception e){
            e.printStackTrace();
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
