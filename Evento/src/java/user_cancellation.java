import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class user_cancellation extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm2="";
        //String nm1=req.getParameter("n1");
        //String nm3=req.getParameter("n2");
        String venue="",time="",type="";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            
            HttpSession user=req.getSession();
            String nm1=(String)user.getAttribute("email");
            String q1="select * from event where status2='true' and status1 !='false' and Email_id='"+nm1+"'";
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
"                    <li><a href=\"user_home.html\">Home</a></li>\n" +
"                    <li><a href=\"events.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li><a href=\"user_home.html#about\">About US</a></li>\n" +
"                    <li><a href=\"user_home.html#contact\">Contact US</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"heading\"><h1>Cancel Your Booking</h1></section>\n" +
"        <section class=\"feedback\" id=\"feedback\">\n" +
"        <table width=\"100%\" border=\"2px\">\n" +
"            <tr>\n" +
"                <td>Name</td>\n" +
"                <td>Event Venue</td>\n" +
"                <td>Date of Event</td>\n" +
"                <td>Event Type</td>\n" +
"                <td>Amount</td>\n" +
"                <td>Service Provider name</td>\n" +
"                <td>profession</td>\n" +
"                <td>Cancel</td>\n" +
"            </tr>");
            while(x.next())
            {
                venue=x.getString(4);
                time=x.getString(5);
                type=x.getString(6);
                nm2=x.getString(7);
                HttpSession ses=req.getSession();
                ses.setAttribute("email", nm2);
                String q="select * from provider where Email_id='"+nm2+"'";
                int num=0;
                String name="";
                ResultSet x1=stmt.executeQuery(q);
                if(x1.next())
                {
                    num=Integer.parseInt(x1.getString(9))+Integer.parseInt(x1.getString(9))/10;
                    name=x1.getString(1);
                    pw.println("<tr><td>"+name+"</td><td>"+venue+"</td><td>"+time+"</td><td>"+type+
                        "</td><td>"+num+"</td><td>"+name+"</td><td>"+x1.getString(4)+"</td><td><a href=user_Cancel?id="+nm1+">Cancel</a></td></tr>");
                }
                else
                {
                    String q2="select * from manager where Email_id='"+nm2+"'";
                    ResultSet x2=stmt.executeQuery(q2);
                    if(x2.next())
                    {
                        num=Integer.parseInt(x2.getString(8));
                        name=x2.getString(1);
                        pw.println("<tr><td>"+name+"</td><td>"+venue+"</td><td>"+time+"</td><td>"+type+
                        "</td><td>"+num+"</td><td>"+name+"</td><td>"+"manager"+"</td><td><a href=user_Cancel?id="+nm1+">Cancel</a></td></tr>");
                    }
                    else{
                        pw.print("wrong det");
                    }
                }
            }
            pw.println("</table></div></body></html>");
            con.close();
        }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}