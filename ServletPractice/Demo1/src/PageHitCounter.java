import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/PageHitCounter")
public class PageHitCounter extends HttpServlet {
    private static final long serialVersionUID=1L;
    private int hitCount;

    @Override
    public void init(){
        //重置点击计数器
        hitCount=0;
    }


    /**
     * 重新启动或Servlet被销毁，计数器将被重置
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        //增加hitCount
        hitCount++;
        PrintWriter out=response.getWriter();
        String title="总点击量";
        String docType="<!DOCTYPE html>\n";
        out.println(docType+
                "<html>\n"+
                "<head><title>"+title+"</title></head>\n"+
                "<body bgcolor=\"#f0f0f0\">\n"+
                "<h1 align=\"center\">"+title+"</h1>\n"+
                "<h2 align=\"center\">"+hitCount+"</h1>\n"+
                "</body></html>"
                );
    }

    @Override
    public void destroy(){

    }
}
