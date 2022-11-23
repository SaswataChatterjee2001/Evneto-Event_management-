import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class manager_pay extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw1=resp.getWriter();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            HttpSession man=req.getSession();
            String nm1=(String)man.getAttribute("manemail");
            String name = "",venue="",date="",type="",mgEmail="";
            String q2="select * from event where status1='"+nm1+"' and status2='true' and status3!='false'";
            ResultSet x=stmt.executeQuery(q2);
            int num=0;
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
"                    <li><a href=\"manager_page.html\">Home</a></li>\n" +
"                    <li><a href=\"events.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li><a href=\"manager_page.html#about\">About US</a></li>\n" +
"                    <li><a href=\"manager_page.html#contact\">Contact US</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"heading\"><h1>Your Pending Commission</h1></section>\n" +
"        <section class=\"feedback\" id=\"feedback\">\n" +
"        <table width=\"100%\" border=\"2px\">\n" +
"            <tr>\n" +
"                <td>Name</td>\n" +
"                <td>Event Venue</td>\n" +
"                <td>Date of Event</td>\n" +
"                <td>Event Type</td>\n" +
"                <td>Commission</td>\n" +
"                <td>Payment</td>\n" +
"            </tr>");
                while(x.next()){
                    name=x.getString(2);
                    venue=x.getString(4);
                    date=x.getString(5);
                    type=x.getString(6);
                    mgEmail=x.getString(7);
                    num=Integer.parseInt(x.getString(9));
                    String q3="Select * from manager where email_id='"+mgEmail+"'";
                    ResultSet x3=stmt.executeQuery(q3);
                    if(x3.next()){
                        pw1.println("<tr><td>"+name+"</td><td>"+venue+
                        "</td><td>"+date+"</td><td>"+type+"</td><td>"+num+"</td><td><a href=managerPay_toAdmin?id="+mgEmail+">Pay Commission</a></td></tr>");
                    }
                }
                pw1.println("</table>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
         con.close();
        }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}