import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class accept extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        String eid=req.getParameter("id");  // performing url rewriting
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            String q1="update provider set status2='true' where EMAIL_ID='"+eid+"'";
            int x=stmt.executeUpdate(q1);
            if(x>0)
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
"            <P><font size=\"6\"> Offer Accepted Successfully</font></p> <BR><BR><a href=provider_home.html><font color=\"white\">Go to home</font></a>\n" +
"        </div>\n" +
"    </center>\n" +
"    </body>\n" +
"</html>");
            }
            else
            {
                pw1.println("Verification Failed");
            }
            con.close();
        }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}