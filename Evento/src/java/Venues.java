
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Venues extends HttpServlet {
    
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        int n=0;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");//Registering the Type4 Driver
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sandeep02");//last 2 are Id and Password & 3rd last is the version of oracle
            Statement stmt=con.createStatement();//to run a query from outside the database
            String q1 = "select * from provider where status2='false' and profession= 'Venues Selection' and Status4='true'";
            ResultSet x = stmt.executeQuery(q1);
            pw1.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
"        <title>Evneto Payment Page</title>\n" +
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
"                    <li><a href=\"user_home.html\">Home</a></li>\n" +
"                    <li><a href=\"events.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li><a href=\"user_home.html#about\">About US</a></li>\n" +
"                    <li><a href=\"user_home.html#contact\">Contact US</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"heading\"><h1>List of Availiable Venues</h1></section>\n" +
"        <section class=\"feedback\" id=\"feedback\">\n" +
"        <table width=\"100%\" border=\"2px\">\n" +
"            <tr>\n" +
"                <td>Name</td>\n" +
"                <td>City</td>\n" +
"                <td>Previous Experiance Year</td>\n" +
"                <td>Price</td>\n" +
"                <td>Send Request</td>\n" +
"            </tr>");
            
            while(x.next())// Dynamic fetching of data from database //this process is called dynamic fetch
            {
                n=Integer.parseInt(x.getString(9))+Integer.parseInt(x.getString(9))/10;
                pw1.println("<tr><td>"+x.getString(1)+"</td><td>"+x.getString(5)+"</td><td>"+x.getString(6)+"</td><td>"+n+"</td><td><a href=preq?id="+x.getString(2)+">Send Request</a></td></tr>");
            }
            pw1.println("</table></center></body></html>");
            con.close();
            
        }
        
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}                                