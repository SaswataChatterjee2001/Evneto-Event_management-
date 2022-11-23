import java.sql.DriverManager;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class user_feedback extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm1=req.getParameter("name");
        String nm2=req.getParameter("email");
        String nm3=req.getParameter("phone");
        String nm4=req.getParameter("behaviour");
        String nm5=req.getParameter("Rating");
        String nm6=req.getParameter("message");
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sandeep02");
            Statement st=con.createStatement();
            String q="Insert into feedback values ('"+nm1+"','"+nm2+"','"+nm3+"','"+nm4+"','"+nm5+"','"+nm6+"')";
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
"            <P><font size=\"6\"> feedback sent successfully </font></p> <BR><BR><a href=user_home.html><font color=\"white\">Go to home</font></a>\n" +
"        </div>\n" +
"    </center>\n" +
"    </body>\n" +
"</html>");
            }
            else
            {
                pw.println("feedback failed");
            }
            //pw.println("<a href=>Go to home page</a>");
        }
        catch(Exception e){
            pw.print(e);
        }
    }
}