import java.sql.DriverManager;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class user_event_choose extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm1=req.getParameter("N1");
        //String nm2=req.getParameter("N2");
        String nm3=req.getParameter("N3");
        String nm4=req.getParameter("N4");
        String nm5=req.getParameter("N5");
        int n=0;
        try
        {
            HttpSession user=req.getSession();
            String nm2=(String)user.getAttribute("email");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sandeep02");
            Statement st=con.createStatement();
            String q1="select * from event";
            ResultSet x=st.executeQuery(q1);
            while(x.next())
            {
                n=Integer.parseInt(x.getString(1));
            }
            n++;
            HttpSession ses=req.getSession();
            ses.setAttribute("new", n);
            String q="Insert into event values ('"+n+"','"+nm1+"','"+nm2+"','"+nm3+"','"+nm4+"','"+nm5+"','"+false+"','"+false+"','"+false+"')";
            int x1=st.executeUpdate(q);
            if(x1>0)
            {
                pw.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"    <head>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <title>Event Organise Gallery</title>\n" +
"\n" +
"        <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/swiper-bundle.min.css\" />\n" +
"\n" +
"        <!-- font awesome cdn link  -->\n" +
"        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n" +
"\n" +
"        <!-- custom css file link  -->\n" +
"        <link rel=\"stylesheet\" href=\"Choosecss.css\">\n" +
"\n" +
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
"                    <li class=\"active\"><a href=\"events.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li><a href=\"user_home.html#about\">About US</a></li>\n" +
"                    <li><a href=\"user_home.html#contact\">Contact US</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"gallery\" id=\"gallery\">\n" +
"            <center>\n" +
"                <h1 class=\"heading\">Find the best Service Providers near you</h1>\n" +
"            </center>      \n" +
"            <div class=\"box-container\">\n" +
"        \n" +
"                <div class=\"box\">\n" +
"                    <a href=\"manager1\"><img src=\"photo/MANAGER.jpg\" alt=\"\"></a>\n" +
"                </div>\n" +
"        \n" +
"                <div class=\"box\">\n" +
"                    <a href=\"Catering\">\n" +
"                    <img src=\"photo/CATERING.png\" alt=\"\"></a>\n" +
"                </div>\n" +
"        \n" +
"                <div class=\"box\">\n" +
"                    <a href=\"Decorator\">\n" +
"                    <img src=\"photo/DECORATORS.jpg\" alt=\"\"></a>\n" +
"                </div>\n" +
"        \n" +
"                <div class=\"box\">\n" +
"                    <a href=\"MakeUp\">\n" +
"                    <img src=\"photo/MAKEUP.jpg\" alt=\"\"></a>\n" +
"                </div>\n" +
"        \n" +
"                <div class=\"box\">\n" +
"                    <a href=\"photographer\">\n" +
"                    <img src=\"photo/photography.png\" alt=\"\"></a>\n" +
"                </div>\n" +
"        \n" +
"                <div class=\"box\">\n" +
"                    <a href=\"Entertainment\">\n" +
"                    <img src=\"photo/ENTERTAINMENT.png\" alt=\"\"></a>\n" +
"                </div>\n" +
"        \n" +
"                <div class=\"box\">\n" +
"                    <a href=\"Invitation\">\n" +
"                    <img src=\"photo/INVITATION.jpg\" alt=\"\"></a>\n" +
"                </div>\n" +
"        \n" +
"                <div class=\"box\">\n" +
"                    <a href=\"Vehicles\">\n" +
"                    <img src=\"photo/VEHICLES.png\" alt=\"\"></a>\n" +
"                </div>\n" +
"        \n" +
"                <div class=\"box\">\n" +
"                    <a href=\"Venues\">\n" +
"                    <img src=\"photo/VENUES.png\" alt=\"\"></a>\n" +
"                </div>\n" +
"            </div>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
            }
            else
            {
                pw.println("event booking cancelled failed");
            }
        }
        catch(Exception e){
            pw.print(e);
        }
    }
}