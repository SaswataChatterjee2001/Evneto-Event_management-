import java.sql.DriverManager;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class fp5 extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm1=req.getParameter("n1");
        try
        {
            HttpSession ses=req.getSession();
            String nm2=(String)ses.getAttribute("SQ");
            String nm3=(String)ses.getAttribute("email");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sandeep02");
            Statement st=con.createStatement();
                if(nm2.equals("PROVIDER"))
                {
                    String q="update provider set password = '"+nm1+"' where Email_id= '"+nm3+"'";
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
"            <P><font size=\"6\"> password changed successfully</font></p> <BR><BR><a href=login.html><font color=\"white\">Go to home</font></a>\n" +
"        </div>\n" +
"    </center>\n" +
"    </body>\n" +
"</html>");
                    }
                    else
                    {
                        pw.println("Registration failed");
                    }
                }
                if(nm2.equals("MANAGER"))
                {
                    String q="update manager set password = '"+nm1+"' where Email_id= '"+nm3+"'";
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
"            <P><font size=\"6\"> password changed successfully</font></p> <BR><BR><a href=login.html><font color=\"white\">Go to home</font></a>\n" +
"        </div>\n" +
"    </center>\n" +
"    </body>\n" +
"</html>");
                    }
                    else
                    {
                        pw.println("Registration failed");
                    }
                }
                if(nm2.equals("USER"))
                {
                    String q="update user1 set password = '"+nm1+"' where Email_id= '"+nm3+"'";
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
"            <P><font size=\"6\"> password changed successfully</font></p> <BR><BR><a href=login.html><font color=\"white\">Go to home</font></a>\n" +
"        </div>\n" +
"    </center>\n" +
"    </body>\n" +
"</html>");
                    }
                    else
                    {
                        pw.println("Registration failed");
                    }
                }
            }
        catch(Exception e){
            pw.print(e);
        }
    }
}