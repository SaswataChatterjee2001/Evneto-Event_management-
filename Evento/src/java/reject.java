import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class reject extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        String eid=req.getParameter("id");  // performing url rewriting
        try
        {
            HttpSession ses=req.getSession();
            String id1=(String)ses.getAttribute("nid");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            String q2="update event set status1='false' where EMAILID='"+id1+"'";
            int x2=stmt.executeUpdate(q2);
            if(x2>0)
            {
                // This is dynamic updating the page so that only the not verified persons should be visible to admin
                String q="select * from provider where Email_id='"+id1+"' and status2='false'";
            ResultSet x1=stmt.executeQuery(q);
            if(x1.next())
            {
            String q1="select * from event where status2='false' and status1='"+id1+"'";
            ResultSet x=stmt.executeQuery(q1);
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
"                    <li><a href=\"provider_home.html\">Home</a></li>\n" +
"                    <li><a href=\"events.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li><a href=\"provider_home.html#about\">About US</a></li>\n" +
"                    <li><a href=\"provider_home.html#contact\">Contact US</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"heading\"><h1>Your Available Work Offers</h1></section>\n" +
"        <section class=\"feedback\" id=\"feedback\">\n" +
"        <table width=\"100%\" border=\"2px\">\n" +
"            <tr>\n" +
"                <td>Name</td>\n" +
"                <td>Event Venue</td>\n" +
"                <td>Date of Event</td>\n" +
"                <td>Event Type</td>\n" +
"                <td>Accept</td>\n" +
"                <td>Reject</td>\n" +
"            </tr>");
            while(x.next())
            {
                pw1.println("<tr><td>"+x.getString(2)+"</td><td>"+x.getString(4)+"</td><td>"+x.getString(5)+
                        "</td><td>"+x.getString(6)+"</td><td><a href=accept?id="+x.getString(7)+">Accept</a></td><td><a href=reject?id="+x.getString(3)+">Reject</a></td></tr>");
            }
            pw1.println("</table></div></body></html>");
            }
            else
            {
                pw1.println("<html>\n" +
"    <head>\n" +
"        <title>EVENETO</title>\n" +
"        <LINK REL=\"stylesheet\" HREF=\"popup.css\">\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"    </head>\n" +
"    <body>\n" +
"    <center>\n" +
"        <DIV CLASS=\"contact-form\">\n" +
"            <P><font size=\"6\"> You've already accepted one offer </font></p> <BR><BR><a href=manager_page.html><font color=\"white\">Go to home</font></a>\n" +
"        </div>\n" +
"    </center>\n" +
"    </body>\n" +
"</html>");
            }
            }
            con.close();
        }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}