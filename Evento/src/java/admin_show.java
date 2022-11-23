import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class admin_show extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            String q1="select * from provider where status4='false'";
            ResultSet x=stmt.executeQuery(q1);
            pw.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
"        <title>Evneto Commission Page</title>\n" +
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
"        <section class=\"heading\"><h1>Service Provider Permission</h1></section>\n" +
"        <section class=\"feedback\" id=\"feedback\">\n" +
"        <table width=\"100%\" border=\"2px\">\n" +
"            <tr>\n" +
"                <td>Name</td>\n" +
"                <td>Email</td>\n" +
"                <td>Profession</td>\n" +
"                <td>Previous Experience(year)</td>\n" +
"                <td>Expected Wage</td>\n" +
"                <td>Permission</td>\n" +
"            </tr>");
            while(x.next())
            {
                pw.println("<tr><td>"+x.getString(1)+"</td><td>"+x.getString(2)+"</td><td>"+x.getString(4)+
                        "</td><td>"+x.getString(6)+"</td><td>"+x.getString(9)+"</td><td><a href=admin_grant?id="+x.getString(2)+">Grant Permission</a></td></tr>");
            }
            pw.println("</table></section>");
            String q2="select * from manager where status4='false'";
            ResultSet x2=stmt.executeQuery(q2);
            pw.println("<section class=\"heading\"><h1>Manager Permission</h1></section>\n" +
"        <section class=\"feedback\" id=\"feedback\">\n" +
"        <table width=\"100%\" border=\"2px\">\n" +
"            <tr>\n" +
"                <td>Name</td>\n" +
"                <td>Email</td>\n" +
"                <td>Profession</td>\n" +
"                <td>Previous Experience(year)</td>\n" +
"                <td>Expected Wage</td>\n" +
"                <td>Permission</td>\n" +
"            </tr>");
            while(x2.next())
            {
                pw.println("<tr><td>"+x2.getString(1)+"</td><td>"+x2.getString(2)+"</td><td>"+"Manager"+"</td><td>"+x2.getString(5)+
                        "</td><td>"+x2.getString(8)+"</td><td><a href=admin_grandman?id="+x2.getString(2)+">Grant Permission</a></td></tr>");
            }
            pw.println("</table></section></body></html>");
            con.close();
        }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}