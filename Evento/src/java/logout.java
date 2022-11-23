import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class logout extends HttpServlet {

    protected void doGet (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        
        HttpSession session = req.getSession(false);
        if(session != null){
            session.invalidate();
        }
        getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
    }
}