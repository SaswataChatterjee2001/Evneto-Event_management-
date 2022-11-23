import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class manager_pending extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        //String nm1=req.getParameter("n1");
        try
        {
            HttpSession man=req.getSession();
            String nm1=(String)man.getAttribute("manemail");
            HttpSession ses1=req.getSession();
            ses1.setAttribute("nid", nm1);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            String q="select * from manager where Email_id='"+nm1+"' and status2='false'";
            ResultSet x1=stmt.executeQuery(q);
            if(x1.next())
            {
                String q1="select * from event where status2='false' and status1='"+nm1+"'";
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
"                    <li><a href=\"manager_page.html\">Home</a></li>\n" +
"                    <li><a href=\"events.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li><a href=\"manager_page.html#about\">About US</a></li>\n" +
"                    <li><a href=\"manager_page.html#contact\">Contact US</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"heading\"><h1>Your Work Request</h1></section>\n" +
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
                pw.println("<tr><td>"+x.getString(2)+"</td><td>"+x.getString(4)+"</td><td>"+x.getString(5)+
                        "</td><td>"+x.getString(6)+"</td><td><a href=man_Accept?id="+x.getString(7)+">Accept</a></td><td><a href=man_reject?id="+x.getString(3)+">Reject</a></td></tr>");
            }
            pw.println("</table></section></body></html>");
            }
            else
            {
                pw.println("<html>\n" +
"    <head>\n" +
"        <title>EVENETO</title>\n" +
"        <LINK REL=\"stylesheet\" HREF=\"popup.css\">\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"    </head>\n" +
"    <body>\n" +
"    <center>\n" +
"        <DIV CLASS=\"contact-form\">\n" +
"            <P><font size=\"6\"> No offer to accept</font></p> <BR><BR><a href=manager_page.html><font color=\"white\">Go to home</font></a>\n" +
"        </div>\n" +
"    </center>\n" +
"    </body>\n" +
"</html>");
            }
            con.close();
        }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}