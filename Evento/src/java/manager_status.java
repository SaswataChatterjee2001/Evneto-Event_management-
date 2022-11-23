import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class manager_status extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=resp.getWriter();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            HttpSession man=req.getSession();
            String nm1=(String)man.getAttribute("manemail");
            String q="Select * from onlinepay where email='"+nm1+"'";
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
"                    <li><a href=\"manager_page.html\">Home</a></li>\n" +
"                    <li><a href=\"events.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li><a href=\"manager_page.html#about\">About US</a></li>\n" +
"                    <li><a href=\"manager_page.html#contact\">Contact US</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"heading\"><h1>Online Payments</h1></section>\n" +
"        <section class=\"feedback\" id=\"feedback\">\n" +
"            <table>\n" +
"                <table width=\"100%\" border=\"2px\">\n" +
"                    <tr>\n" +
"                        <td>Sl No.</td>\n" +
"                        <td>Name</td>\n" +
"                        <td>Card No.</td>\n" +
"                        <td>amount</td>\n" +
"                    </tr>");
            while(rs.next()){
                pw.println("<tr><td>"+num+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+
                            "</td><td>"+rs.getString(6)+"</td></tr>");
                num++;
            }
            pw.println("</table></section>");
            String q1="Select * from cashpay where pemail='"+nm1+"'";
            int num1 = 1;
            ResultSet rs1=stmt.executeQuery(q1);
            pw.println(
"        <section class=\"heading\"><h1>Cash payments</h1></section>\n" +
"        <section class=\"feedback\" id=\"feedback\">\n" +
"            <table>\n" +
"                <table width=\"100%\" border=\"2px\">\n" +
"                    <tr>\n" +
"                        <td>Sl No.</td>\n" +
"                        <td>Name</td>\n" +
"                        <td>address</td>\n" +
"                        <td>PIN</td>\n" +
"                        <td>amount</td>\n" +
"                    </tr>");
            while(rs1.next()){
                pw.println("<tr><td>"+num1+"</td><td>"+rs1.getString(1)+"</td><td>"+rs1.getString(2)+
                            "</td><td>"+rs1.getString(4)+"</td><td>"+rs1.getString(7)+"</td></tr>");
                num1++;
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