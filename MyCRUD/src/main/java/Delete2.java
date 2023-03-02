import Dao.DaoCrud;
import com.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Delete2")
public class Delete2 extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        DB db = new DB();

        try {
            int id = Integer.parseInt(req.getParameter("delete_id_0"));
            DaoCrud crud = new DaoCrud();
            crud.DeleteNews(id);
            String title1 = "删除成功！";
            out.println("<!DOCTYPE html> \n" +
                    "<html>\n" +
                    "<head><title>" + title1 + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h2 align=\"center\">" + title1 + "</h2>\n" +
                    "<form action=\"Writer3\" method=\"POST\">" +
                    "<input type=\"submit\" value=\"点击返回\">" +
                    "</form>" +
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
