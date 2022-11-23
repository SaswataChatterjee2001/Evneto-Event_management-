import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class admin_feedback extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=resp.getWriter();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            String q="Select * from feedback";
            int num = 1;
            ResultSet rs=stmt.executeQuery(q);
            pw.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
"        <title>Evneto Feedback Form</title>\n" +
"        <link rel=\"stylesheet\" href=\"adfdstyle.css\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <header>\n" +
"            <div class=\"main\">\n" +
"                <div class=\"logo\">\n" +
"                    <img src=\"photo/logo2.png\">\n" +
"                </div>\n" +
"            </div>\n" +
"            <div class=\"main\">\n" +
"                <ul>\n" +
"                    <li><a href=\"admin_page.html\">Home</a></li>\n" +
"                    <li><a href=\"events.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li><a href=\"admin_page.html#about\">About US</a></li>\n" +
"                    <li><a href=\"admin_page.html#contact\">Contact US</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"heading\"><h1>OUR Valuable Feedbacks</h1></section>\n" +
"        <section class=\"feedback\" id=\"feedback\">\n" +
"            <table>\n" +
"                <table width=\"100%\" border=\"2px\">\n" +
"                    <tr>\n" +
"                        <td>Sl No.</td>\n" +
"                        <td>Name</td>\n" +
"                        <td>Email</td>\n" +
"                        <td>Phone No.</td>\n" +
"                        <td>Behaviour</td>\n" +
"                        <td>Rating</td>\n" +
"                        <td>Message</td>\n" +
"                    </tr>");
            while(rs.next()){
                pw.println("<tr><td>"+num+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+
                        "</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+
                            "</td><td>"+rs.getString(6)+"</td></tr>");
                num++;
            }
            pw.println("</table>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
            con.close();
        }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}