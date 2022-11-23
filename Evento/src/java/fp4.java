import java.sql.DriverManager;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class fp4 extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm1=req.getParameter("n1");
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sandeep02");
            Statement st=con.createStatement();
            HttpSession ses=req.getSession();
            String nm2=(String)ses.getAttribute("SQ");
            String nm3=(String)ses.getAttribute("email");
            if(nm2.equals("PROVIDER"))
            {
                String q="select * from provider where ANS='"+nm1+"' and Email_id='"+nm3+"'";
                ResultSet x=st.executeQuery(q);
                if(x.next())
                {
                    pw.println("<html>\n" +
"     <LINK REL=\"stylesheet\" HREF=\"fpswrd1.css\">\n" +
"       <head>\n" +
"           <title></title>\n" +
"       </head>\n" +
"       <body>\n" +
"           <center>\n" +
"        <DIV CLASS=\"contact-form\">\n" +
"           <form method=\"post\" action=\"fp5\">\n" +
"               <table border=\"0\">\n" +
"                   <br>\n" +
"                   <br>\n" +
"                   <br>\n" +
"                   <tr>\n" +
"                       <td><P>NEWPASS: </p></td>\n" +
"                       <td><input type=\"password\" name=\"n1\"></td>\n" +
"                   </tr>\n" +
"                   <tr>\n" +
"                       <td>&nbsp;<input type=\"SUBMIT\" value=\"submit\"></td>\n" +
"                   </tr>\n" +
"               </table>\n" +
"           </form>\n" +
"        </div>\n" +
"           </center>\n" +
"       </body>\n" +
"   </html>");
            }
            else
            {
                pw.println("You've Entered a wrong Details please enter a valid details! <a href=f3.html>Retry</a>");
            }
            }
            if(nm2.equals("MANAGER"))
            {
                String q="select * from manager where ANS='"+nm1+"' and Email_id='"+nm3+"'";
                ResultSet x=st.executeQuery(q);
                if(x.next())
                {
                    pw.println("<html>\n" +
"     <LINK REL=\"stylesheet\" HREF=\"fpswrd1.css\">\n" +
"       <head>\n" +
"           <title></title>\n" +
"       </head>\n" +
"       <body>\n" +
"           <center>\n" +
"        <DIV CLASS=\"contact-form\">\n" +
"           <form method=\"post\" action=\"fp5\">\n" +
"               <table border=\"0\">\n" +
"                   <br>\n" +
"                   <br>\n" +
"                   <br>\n" +
"                   <tr>\n" +
"                       <td><P>NEWPASS: </p></td>\n" +
"                       <td><input type=\"password\" name=\"n1\"></td>\n" +
"                   </tr>\n" +
"                   <tr>\n" +
"                       <td>&nbsp;<input type=\"SUBMIT\" value=\"submit\"></td>\n" +
"                   </tr>\n" +
"               </table>\n" +
"           </form>\n" +
"        </div>\n" +
"           </center>\n" +
"       </body>\n" +
"   </html>");
            }
            else
            {
                pw.println("You've Entered a wrong Details please enter a valid details! <a href=f3.html>Retry</a>");
            }
            }
            if(nm2.equals("USER"))
            {
                String q="select * from user1 where ANS='"+nm1+"' and Email_id='"+nm3+"'";
                ResultSet x=st.executeQuery(q);
                if(x.next())
                {
                    pw.println("<html>\n" +
"     <LINK REL=\"stylesheet\" HREF=\"fpswrd1.css\">\n" +
"       <head>\n" +
"           <title></title>\n" +
"       </head>\n" +
"       <body>\n" +
"           <center>\n" +
"        <DIV CLASS=\"contact-form\">\n" +
"           <form method=\"post\" action=\"fp5\">\n" +
"               <table border=\"0\">\n" +
"                   <br>\n" +
"                   <br>\n" +
"                   <br>\n" +
"                   <tr>\n" +
"                       <td><P>NEWPASS: </p></td>\n" +
"                       <td><input type=\"password\" name=\"n1\"></td>\n" +
"                   </tr>\n" +
"                   <tr>\n" +
"                       <td>&nbsp;<input type=\"SUBMIT\" value=\"submit\"></td>\n" +
"                   </tr>\n" +
"               </table>\n" +
"           </form>\n" +
"        </div>\n" +
"           </center>\n" +
"       </body>\n" +
"   </html>");
            }
            else
            {
                pw.println("You've Entered a wrong Details please enter a valid details! <a href=f3.html>Retry</a>");
            }
            }
        }
        catch(Exception e){
            pw.print(e);
        }
    }
}