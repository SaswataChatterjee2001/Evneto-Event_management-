import java.sql.DriverManager;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class preq extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm1=req.getParameter("id");
        try
        {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sandeep02");
                Statement st=con.createStatement();
                HttpSession ses=req.getSession();
                int ob=(int)ses.getAttribute("new");
                String q="update event set status1= '"+nm1+"' where id="+ob;
                int x=st.executeUpdate(q);
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
"            <P><font size=\"6\"> Request Sent Successfully</font></p> <BR><BR><a href=user_CHOOSE.html><font color=\"white\">Go to home</font></a>\n" +
"        </div>\n" +
"    </center>\n" +
"    </body>\n" +
"</html>");
                }
                else
                {
                    pw.println("Request can't be sent");
                }
                //pw.println("<a href=user_CHOOSE.html>Go back to event page</a>");
        }
        catch(Exception e){
            pw.print(e);
        }
    }
}