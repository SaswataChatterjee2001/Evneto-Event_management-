import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class managerPay_toAdmin extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw1=resp.getWriter();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            String email = req.getParameter("id");
            String q1="Update event set status1='false' where status1='"+email+"'";
            int x = stmt.executeUpdate(q1);
            if(x>0){
                pw1.println("<html>\n" +
"    <head>\n" +
"        <title>EVENETO</title>\n" +
"        <LINK REL=\"stylesheet\" HREF=\"popup.css\">\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"    </head>\n" +
"    <body>\n" +
"    <center>\n" +
"        <DIV CLASS=\"contact-form\">\n" +
"            <P><font size=\"6\"> Your commision paid successfully</font></p> <BR><BR><a href=manager_page.html><font color=\"white\">Go to home</font></a>\n" +
"        </div>\n" +
"    </center>\n" +
"    </body>\n" +
"</html>");
            }
            else{
                pw1.println("Payment Failed");
            }
            //pw1.println("<html><body><a href=manager_page.html>Go to Home Page</a></body></html>");
        con.close();
        }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}