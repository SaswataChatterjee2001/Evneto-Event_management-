import java.sql.DriverManager;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class user_onpay extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm1=req.getParameter("n1");
        String nm2=req.getParameter("n2");
        //String nm3=req.getParameter("n3");
        String nm4=req.getParameter("n4");
        String name="";
        int num=0;
        try
        {
            HttpSession payuser=req.getSession();
            String email=(String)payuser.getAttribute("payu");
            HttpSession user=req.getSession();
            String nm3=(String)user.getAttribute("email");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sandeep02");
            Statement st=con.createStatement();
            String q1="Select * from provider where email_id='"+email+"'";
            ResultSet x1=st.executeQuery(q1);
            if(x1.next())
            {
                name=x1.getString(1);
                num=Integer.parseInt(x1.getString(9))+Integer.parseInt(x1.getString(9))/10;
            }
            String q2="Select * from manager where email_id='"+email+"'";
            ResultSet x2=st.executeQuery(q2);
            if(x2.next())
            {
                name=x2.getString(1);
                num=Integer.parseInt(x2.getString(8));
            }
            String q="Insert into onlinepay values ('"+nm1+"','"+nm2+"','"+nm4+"','"+name+"','"+email+"',"+num+",'"+nm3+"')";
            int x=st.executeUpdate(q);
            if(x>0)
            {
                pw.println("<html>\n" +
"    <LINK REL=\"stylesheet\" HREF=\"confirm.css\">\n" +
"    <body>\n" +
"    <CENTER>\n" +
"        <DIV CLASS=\"contact-form\">\n" +
"        <form method=\"get\" action=\"user_paym\">\n" +
"            <div><P>The total amount to be paid is:</P><br><INPUT TYPE=\"text\" placeholder=\"Name\" name=\"N1\" size=2 value="+num+" readonly></div>\n" +
"           <input type=\"SUBMIT\" value=\"CONFIRM\">\n" +
"        </form>\n" +
"        </div>\n" +
"    </CENTER>\n" +
"    </body>\n" +
"</html>");
            }
            else
            {
                pw.println("Payment failed");
            }
        }
        catch(Exception e){
            pw.print(e);
        }
    }
}