import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/ShowError")
public class ShowError extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(407,"Need authentication!!!");
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        doGet(request,response);
    }
}
