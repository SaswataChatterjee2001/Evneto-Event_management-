import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class user_paym extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        HttpSession user=req.getSession();
        String nm1=(String)user.getAttribute("email");
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        //String nm2="";
        //String nm3=req.getParameter("id");
        //String venue="",time="",type="";
        try
        {
            HttpSession payuser=req.getSession();
            String nm3=(String)payuser.getAttribute("payu");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            String q3="update event set status2 ='true' where Email_id ='"+nm1+"' and status1='"+nm3+"'";
            int x3=stmt.executeUpdate(q3);
            if(x3>0)
            {
                String q="select * from onlinepay where email='"+nm3+"' and uemail='"+nm1+"'";
                ResultSet x=stmt.executeQuery(q);
                if(x.next())
                {
                    pw.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
"        <title>Evneto Payment Page</title>\n" +
"        <link rel=\"stylesheet\" href=\"adfdstyle.css\">\n" +
"        <style>\n" +
"            .status{\n" +
"                padding-top: 4%;\n" +
"                padding-bottom: 2.5%;\n" +
"                font-size: 1.2rem;\n" +
"            }\n" +
"            .btn{\n" +
"                border: 1px solid rgb(102, 192, 249);\n" +
"                border-radius: 3rem;\n" +
"                padding: 10px 30px;\n" +
"                color: rgb(249, 86, 122);\n" +
"                text-decoration: none;\n" +
"                transition: 0.6s ease;\n" +
"            }\n" +
"            .btn:hover{\n" +
"                background-color: rgb(255, 115, 115);\n" +
"                border-radius: 3rem;\n" +
"                border-color: #fff;\n" +
"                color: #fff;\n" +
"            }\n" +
"        </style>\n" +
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
"        <section class=\"heading\"><h1>Your Payment Details</h1></section>\n" +
"        <section class=\"feedback\" id=\"feedback\">\n" +
"            <center>\n" +
"        <table width=\"65%\" border=\"2px\">\n" +
"            <tr>\n" +
"                <td>Name</td>\n" +
"                <td>"+x.getString(1)+"</td>\n" +
"            </tr>\n" +
"            <tr>\n" +
"                <td>Email</td>\n" +
"                <td>"+x.getString(7)+"</td>\n" +
"            </tr>\n" +
"            <tr>\n" +
"                <td>Receiver Name</td>\n" +
"                <td>"+x.getString(4)+"</td>\n" +
"            </tr>\n" +
"            <tr>\n" +
"                <td>Card No.</td>\n" +
"                <td>"+x.getString(2)+"</td>\n" +
"            </tr>\n" +
"            <tr>\n" +
"                <td>Amount</td>\n" +
"                <td>"+x.getString(6)+"</td>\n" +
"            </tr>\n" +
"        </table>\n" +
"        <div class=\"status\"><h2>Payment Completed Successfully</h2></div>\n" +
"        <div>\n" +
"            <a href=\"user_home.html\" class=\"btn\">Go back to homepage</a>\n" +
"        </div>\n" +
"    </center>\n" +
"    </section>\n" +
"    </body>\n" +
"</html>");
                }
                String q1="select * from cashpay where pemail='"+nm3+"' and email='"+nm1+"'";
                ResultSet x1=stmt.executeQuery(q1);
                if(x1.next())
                {
                    pw.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
"        <title>Evneto Payment Page</title>\n" +
"        <link rel=\"stylesheet\" href=\"adfdstyle.css\">\n" +
"        <style>\n" +
"            .status{\n" +
"                padding-top: 4%;\n" +
"                padding-bottom: 2.5%;\n" +
"                font-size: 1.2rem;\n" +
"            }\n" +
"            .btn{\n" +
"                border: 1px solid rgb(102, 192, 249);\n" +
"                border-radius: 3rem;\n" +
"                padding: 10px 30px;\n" +
"                color: rgb(249, 86, 122);\n" +
"                text-decoration: none;\n" +
"                transition: 0.6s ease;\n" +
"            }\n" +
"            .btn:hover{\n" +
"                background-color: rgb(255, 115, 115);\n" +
"                border-radius: 3rem;\n" +
"                border-color: #fff;\n" +
"                color: #fff;\n" +
"            }\n" +
"        </style>\n" +
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
"                    <li><a href=\"adminpage\">Home</a></li>\n" +
"                    <li><a href=\"events.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li><a href=\"admin.html#about\">About US</a></li>\n" +
"                    <li><a href=\"index.html#contact\">Contact US</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"heading\"><h1>Your Payment Details</h1></section>\n" +
"        <section class=\"feedback\" id=\"feedback\">\n" +
"            <center>\n" +
"        <table width=\"65%\" border=\"2px\">\n" +
"            <tr>\n" +
"                <td>Name</td>\n" +
"                <td>"+x1.getString(1)+"</td>\n" +
"            </tr>\n" +
"            <tr>\n" +
"                <td>Email ID</td>\n" +
"                <td>"+x1.getString(8)+"</td>\n" +
"            </tr>\n" +
"            <tr>\n" +
"                <td>Receiver Name</td>\n" +
"                <td>"+x1.getString(5)+"</td>\n" +
"            </tr>\n" +
"            <tr>\n" +
"                <td>Phone No.</td>\n" +
"                <td>"+x1.getString(3)+"</td>\n" +
"            </tr>\n" +
"            <tr>\n" +
"                <td>Address</td>\n" +
"                <td>"+x1.getString(2)+"</td>\n" +
"            </tr>\n" +
"            <tr>\n" +
"                <td>Area Pin Code</td>\n" +
"                <td>"+x1.getString(4)+"</td>\n" +
"            </tr>\n" +
"            <tr>\n" +
"                <td>Amount</td>\n" +
"                <td>"+x1.getString(7)+"</td>\n" +
"            </tr>\n" +
"        </table>\n" +
"        <div class=\"status\"><h2>Payment through Cash after Completion of work is Confirmed.</h2></div>\n" +
"        <div>\n" +
"            <a href=\"user_home.html\" class=\"btn\">Go back to homepage</a>\n" +
"        </div>\n" +
"    </center>\n" +
"    </section>\n" +
"    </body>\n" +
"</html>");
                }
            }
        }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}