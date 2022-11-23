import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;

public class user_signup extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm1=req.getParameter("name");
        String nm2=req.getParameter("email");
        String nm3=req.getParameter("pass");
        String nm4=req.getParameter("seq");
        String nm5=req.getParameter("answer");
        try
        {
            if(nm2.equals("sandeep@02") && nm3.equals("sandeep"))
            {
                pw.println("This email can't be used try another email <a href=Manager_sign_up>SIGN UP</a>");
            }
            else
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
                Statement stmt=con.createStatement();
                String query="insert into user1 values ('"+nm1+"','"+nm2+"','"+nm3+"','"+nm4+"','"+nm5+"','"+false+"','"+false+"','"+false+"')";
                int x=stmt.executeUpdate(query);
                if(x>0)
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
"            <P><font size=\"6\"> Registration done Successfully</font></p> <BR><BR><a href=login.html><font color=\"white\">Go to home</font></a>\n" +
"        </div>\n" +
"    </center>\n" +
"    </body>\n" +
"</html>");
                }
                else
                {
                    pw.println("Rgistration Unsuccessful");
                }
                con.close(); 
            }
        }
        catch(Exception e)
        {}
    }
}