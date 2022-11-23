import java.sql.DriverManager;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class fp2 extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm1=req.getParameter("n1");
        String nm2=req.getParameter("n2");      
        try
        {
            HttpSession ses=req.getSession();
            ses.setAttribute("email", nm1);
            ses.setAttribute("SQ", nm2);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sandeep02");
            Statement st=con.createStatement();
            if(nm2.equals("PROVIDER"))
            {
                String q="select * from PROVIDER where Email_id='"+nm1+"'";
                ResultSet x=st.executeQuery(q);
                if(x.next())
                {
                pw.println("<html>\n" +
"    <LINK REL=\"stylesheet\" HREF=\"fpswrd1.css\">\n" +
"    <body>\n" +
"    <center>\n" +
"        <DIV CLASS=\"contact-form\">\n" +
"        <form method=\"post\" action=\"fp4\">\n" +
"            <table border=\"0\">\n" +
"                <tr>\n" +
"                       <td><p>SQ: </p></td>                   \n" +
"                      <td><font color=white>"+x.getString(7)+"</font></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                        <td><p>Answer: </p></td>\n" +
"                    <td><input type=\"text\" name=\"n1\"></td>\n" +
"                </tr>\n" +
"               <tr>\n" +
"                   <td>&nbsp;<input type=SUBMIT value=\"SUBMIT\"></td>\n" +
"                </tr>\n" +
"            </table> \n" +
"       </form> \n" +
"        </div>\n" +
"    </center>\n" +
"    </body>\n" +
"</html>");
                }
                else
                {
                    pw.println("You've Entered a wrong Email Id please enter a valid email! <a href=f3.html>Retry</a>");
                }
               }
            if(nm2.equals("MANAGER"))
            {
                String q="select * from MANAGER where Email_id='"+nm1+"'";
                ResultSet x=st.executeQuery(q);
                if(x.next())
                {
                pw.println("<html>\n" +
"    <LINK REL=\"stylesheet\" HREF=\"fpswrd1.css\">\n" +
"    <body>\n" +
"    <center>\n" +
"        <DIV CLASS=\"contact-form\">\n" +
"        <form method=\"post\" action=\"fp4\">\n" +
"            <table border=\"0\">\n" +
"                <tr>\n" +
"                       <td><p>SQ: </p></td>                   \n" +
"                      <td><font color=white>"+x.getString(6)+"</font></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                        <td><p>Answer: </p></td>\n" +
"                    <td><input type=\"text\" name=\"n1\"></td>\n" +
"                </tr>\n" +
"               <tr>\n" +
"                   <td>&nbsp;<input type=SUBMIT value=\"SUBMIT\"></td>\n" +
"                </tr>\n" +
"            </table> \n" +
"       </form> \n" +
"        </div>\n" +
"    </center>\n" +
"    </body>\n" +
"</html>");
                }
                else
                {
                    pw.println("You've Entered a wrong Email Id please enter a valid email! <a href=f3.html>Retry</a>");
                }
               }
            if(nm2.equals("USER"))
            {
                String q="select * from USER1 where Email_id='"+nm1+"'";
                ResultSet x=st.executeQuery(q);
                if(x.next())
                {
                pw.println("<html>\n" +
"    <LINK REL=\"stylesheet\" HREF=\"fpswrd1.css\">\n" +
"    <body>\n" +
"    <center>\n" +
"        <DIV CLASS=\"contact-form\">\n" +
"        <form method=\"post\" action=\"fp4\">\n" +
"            <table border=\"0\">\n" +
"                <tr>\n" +
"                       <td><p>SQ: </p></td>                   \n" +
"                      <td><font color=white>"+x.getString(4)+"</font></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                        <td><p>Answer: </p></td>\n" +
"                    <td><input type=\"text\" name=\"n1\"></td>\n" +
"                </tr>\n" +
"               <tr>\n" +
"                   <td>&nbsp;<input type=SUBMIT value=\"SUBMIT\"></td>\n" +
"                </tr>\n" +
"            </table> \n" +
"       </form> \n" +
"        </div>\n" +
"    </center>\n" +
"    </body>\n" +
"</html>");
                }
                else
                {
                    pw.println("You've Entered a wrong Email Id please enter a valid email! <a href=f3.html>Retry</a>");
                }
               }
        }
        catch(Exception e){
            pw.print(e);
        }
    }
}