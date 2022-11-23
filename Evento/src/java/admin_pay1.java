import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class admin_pay1 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw1=resp.getWriter();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            String email1 = req.getParameter("id");
            String q1="update event set status3='true' , status1='false' where status1='"+email1+"'";
            int y=stmt.executeUpdate(q1);
            if(y>0){
              String name = "",email="",venue="",date="",type="",svpEmail="";
            String q="select * from event where status2='true' and status3='false'";
            String num="";
            ResultSet x=stmt.executeQuery(q);
            pw1.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
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
"        <section class=\"heading\"><h1>Service Provider Payment</h1></section>\n" +
"        <section class=\"feedback\" id=\"feedback\">\n" +
"        <table width=\"100%\" border=\"2px\">\n" +
"            <tr>\n" +
"                <td>Name</td>\n" +
"                <td>Email</td>\n" +
"                <td>Event Venue</td>\n" +
"                <td>Date of Event</td>\n" +
"                <td>Event Type</td>\n" +
"                <td>Service Provider EmailId</td>\n" +
"                <td>Amount</td>\n" +
"                <td>Payment</td>\n" +
"            </tr>");
                while(x.next()){
                    name=x.getString(2);
                    email=x.getString(3);
                    venue=x.getString(4);
                    date=x.getString(5);
                    type=x.getString(6);
                    svpEmail=x.getString(7);
                    String q2="Select * from provider where email_id='"+svpEmail+"'";
                    ResultSet x2=stmt.executeQuery(q2);
                    if(x2.next()){
                        num=x2.getString(9);
                        pw1.println("<tr><td>"+name+"</td><td>"+email+"</td><td>"+venue+
                        "</td><td>"+date+"</td><td>"+type+"</td><td>"+svpEmail+
                            "</td><td>"+num+"</td><td><a href=admin_pay1?id="+svpEmail+">Pay</a></td></tr>");
                    }
                }
                pw1.println("</table>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
            }
            con.close();
        }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}