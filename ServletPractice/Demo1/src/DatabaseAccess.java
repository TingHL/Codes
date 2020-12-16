import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/DatabaseAccess")
public class DatabaseAccess extends HttpServlet {
    private static final long serialVersionUID=1L;

    //JDBC 驱动名及数据库URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/runoob?serverTimezone=UTC";

    //数据库的用户名与密码
    static final String USER="root";
    static final String PASS="root";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Connection conn=null;
        Statement stmt=null;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String title = "Servlet Mysql 测试 - 菜鸟教程";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");

        try{
            //注册JDBC驱动器
            Class.forName("com.mysql.jdbc.Driver");

            //打开一个连接
            conn= DriverManager.getConnection(DB_URL,USER,PASS);

            //执行SQL查询
            stmt=conn.createStatement();
            String sql="SELECT id,name,url from websites";
            ResultSet rs=stmt.executeQuery(sql);

            //展开结果集数据集
            while(rs.next()){
                //通过字段检索
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String url=rs.getString("url");

                //输出数据
                out.println("ID:"+id);
                out.println("，站点名称："+name);
                out.println("，站点URL："+url);
                out.println("<br />");
            }
            out.println("</body></html>");

            //完成后关闭
            rs.close();
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //最后是用于关闭资源的块
            try{
                if(stmt!=null) {
                    stmt.close();
                }
            }catch (SQLException se2){
            }
            try{
                if(conn!=null)conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        doGet(request,response);
    }
}
