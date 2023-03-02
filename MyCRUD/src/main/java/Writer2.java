
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

@WebServlet("/Writer2")
public class Writer2 extends HttpServlet {
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
        DB db = new DB();
        //获取表单信息
        String title_check =req.getParameter("publish_title");
        String text_check =req.getParameter("publish_text");
        String title = new String(req.getParameter("publish_title").getBytes("ISO8859-1"),"UTF-8");
        String text = new String(req.getParameter("publish_text").getBytes("ISO8859-1"),"UTF-8");
        String writer = new String(req.getParameter("publish_writer").getBytes("ISO8859-1"),"UTF-8");
        String date =new String(req.getParameter("publish_date").getBytes("ISO8859-1"),"UTF-8");
        DaoCrud crud = new DaoCrud();
        //检测内容是否为空
        if(title_check==""||text_check==""){
            out.println("<!DOCTYPE html> \n" +
                    "<html>\n" +
                    "<head><title>" + "提交失败" + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + "提交失败，标题或内容不能为空" + "</h1>\n" +
                    "<input type=\"button\" value=\"点击返回\" onclick=\"location.href='Writer1'\" />"+
                    "</body></html>"
            );
        }else {
            crud.AddNews(title,text,writer,date);
            out.println("<!DOCTYPE html> \n" +
                    "<html>\n" +
                    "<head><title>" + "发布成功" + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + "发布成功" + "</h1>\n" +
                    "<input type=\"button\" value=\"点击返回\" onclick=\"location.href='Writer1'\" />"+
                    "</body></html>"
            );
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
