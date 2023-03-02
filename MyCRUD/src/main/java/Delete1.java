import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Delete1")
public class Delete1 extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = resp.getWriter();
            int id = Integer.parseInt(req.getParameter("delete_id"));
            String title1 = "你确认删除此新闻么，删除后不可撤销";
            out.println("<!DOCTYPE html> \n" +
                    "<html>\n" +
                    "<head><title>" + title1 + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h2 align=\"center\">" + title1 + "</h2>\n" +
                    "<form action=\"Delete2\" method=\"POST\">" +
                    "<input type=\"hidden\" name=\"delete_id_0\" value="+ id +">"+
                    "<input type=\"submit\" value=\"确认删除\">" +
                    "</form>" +
                    "<br><input type=\"button\" value=\"点击取消\" onclick=\"location.href='Writer3'\" />"+
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
