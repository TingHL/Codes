package com.atguigui.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/hahasession")
public class SessionServlet extends HttpServlet {
    private static final long serialVersionUID=1L;

    public SessionServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String string=req.getParameter("param");
        if(string.equals("getSession")){
            //1.获取到session对象，并把session的id打印给浏览器
            HttpSession session=req.getSession();
            resp.getWriter().write(session.getId());
        }else if(string.equals("invalidateSession")){
            HttpSession session = req.getSession();
            session.invalidate();
            resp.getWriter().write("session...失效");
        }
    }
}
