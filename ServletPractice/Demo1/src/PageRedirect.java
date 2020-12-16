import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 网页重定向
 * 1.最简单的方式是使用response对象的sendRedirect()方法 通过把响应状态和新的网页位置发送给浏览器
 *      public void HttpServletResponse.sendRedirect(String location) throws IOExcepiton
 * 2.方法二：通过把setStatus()和setHeader()方法一起使用达到相同的效果
 *      String site="xxx.xxx.com";
 *      response.setStatus(response.SC_MOVED_TEMPORARILY);
 *      response.setHeader("Location",site);
 */

public class PageRedirect extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");

        //需要重定向的新位置
        String site=new String("http://www.runoob.com");

        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader("Location",site);
    }
}
