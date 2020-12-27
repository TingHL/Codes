import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AjaxServlet extends HttpServlet {
    public AjaxServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> map=new HashMap<>();
        map.put("lastName","admin");
        map.put("age",18);

//        1.×ª³Éjson
        Gson gson=new Gson();
        String json=gson.toJson(map);
        resp.getWriter().write(json);
    }
}
