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

@WebServlet("/LoginJudge")
public class LoginJudge extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        DB db = new DB();
        try {
            PrintWriter out = resp.getWriter();

            String na =new String(req.getParameter("put_name").getBytes("ISO8859-1"),"UTF-8");
            String pw = new String(req.getParameter("put_password").getBytes("ISO8859-1"),"UTF-8");
            String iy = new String(req.getParameter("put_identity").getBytes("ISO8859-1"),"UTF-8");
            //获得session空间
            HttpSession hs = req.getSession(true);
            //修改session的存在时间为200秒
            hs.setMaxInactiveInterval(200);

            db.rs = db.stmt.executeQuery("SELECT * FROM user_info WHERE user_name="+"'"+na+"'");

            if (db.rs.next()){

                if (pw.equals(db.rs.getString("user_password"))){

                    if (iy.equals(db.rs.getString("user_identity"))){

                        switch (iy){
                            case "普通用户":
                                //设置session 名为u_pass 值为ok
                                hs.setAttribute("u_pass","ok");
                                hs.setAttribute("u_name",na);
                                String site1 = new String("http://localhost:8080/MyCRUD_war_exploded/User1");
                                resp.setStatus(resp.SC_MOVED_TEMPORARILY);
                                resp.setHeader("Location", site1);
                                break;
                            case "撰稿人":
                                hs.setAttribute("w_pass","ok");
                                hs.setAttribute("w_name",na);
                                String site2 = new String("http://localhost:8080/MyCRUD_war_exploded/Writer1");
                                resp.setStatus(resp.SC_MOVED_TEMPORARILY);
                                resp.setHeader("Location", site2);
                                break;
                            case "管理员":
                                hs.setAttribute("a_pass","ok");
                                hs.setAttribute("a_name",na);
                                String site3 = new String("http://localhost:8080/MyCRUD_war_exploded/Admin1");
                                resp.setStatus(resp.SC_MOVED_TEMPORARILY);
                                resp.setHeader("Location", site3);
                                break;
                        }

                    } else{
                        out.print("<script language='javaScript'> alert('登陆身份错误');</script>");
                        resp.setHeader("refresh", "0;url=Login");
                    }

                } else{
                    out.print("<script language='javaScript'> alert('密码错误');</script>");
                    resp.setHeader("refresh", "0;url=Login");
                }

            }else {
                out.print("<script language='javaScript'> alert('用户名错误');</script>");
                resp.setHeader("refresh", "0;url=Login");
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally{
            db.close();
        }

    }
    @Override
    public void destroy() {

    }
}
