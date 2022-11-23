import java.sql.DriverManager;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class login1 extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm1=req.getParameter("n1");
        String nm2=req.getParameter("n2");
        //String nm3=req.getParameter("n3");
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sandeep02");
            Statement st=con.createStatement();
            if(nm1.equals("sandeep@02") && nm2.equals("sandeep"))
            {
                pw.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"    <head>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <title>Admin Home Page</title>\n" +
"        <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/swiper-bundle.min.css\" />\n" +
"        <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n" +
"        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n" +
"        <link rel=\"stylesheet\" href=\"adstyle.css\">\n" +
"        <script>\n" +
"            function fun(){\n" +
"                swal({\n" +
"                    title: \"Are you sure?\",\n" +
"                    text: \"You want to Log Out\",\n" +
"                    icon: \"warning\",\n" +
"                    buttons: true,\n" +
"                    dangerMode: true,\n" +
"                })\n" +
"                .then((willDelete) => {\n" +
"                    if (willDelete) {\n" +
"                        swal(\"You are Successfully Log Out\", {\n" +
"                        icon: \"success\",\n" +
"                        closeOnClickOutside: false,\n" +
"                        confirmButtonText: \"OK\",\n" +
"                        onabort:\"index.html\",\n" +
"                    })\n" +
"                    .then(function() {\n" +
"                        window.location = \"logout\";\n" +
"                    });\n" +
"                    } else {\n" +
"                        swal(\"Logging Out Failed\",\"You are Still Log In !\");\n" +
"                    }\n" +
"                });\n" +
"            }\n" +
"        </script>\n" +
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
"                    <li class=\"active\"><a href=\"admin_page.html\">Home</a></li>\n" +
"                    <li><a href=\"services.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li onclick=\"fun()\"><a>Log Out</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"userlogin\" id=\"userlogin\">\n" +
"            <center>\n" +
"            <div class=\"username\">\n" +
"                <h1>Admin</h1>\n" +
"            </div>\n" +
"            <div class=\"details\">\n" +
"                <h2>Validation</h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                        <li class=\"btn\"><a href=\"admin_show\">Request</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Payment Status</h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                        <li class=\"btn\"><a href=\"admin_pay\">Pay</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Generate Commission</h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                    <li class=\"btn\"><a href=\"admin_commision\">Commission</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>See Feedback</h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                        <li class=\"btn\"><a href=\"admin_feedback\">Feedback</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"            </div>\n" +
"        </center>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
            }
            else
            {
                String q2="select * from USER1 where Email_id='"+nm1+"' and password= '"+nm2+"'";
                ResultSet x2=st.executeQuery(q2);
                if(x2.next())
                {
                    HttpSession user=req.getSession();
                    user.setAttribute("email", nm1);
                    pw.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"    <head>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <title>Event Organise Gallery</title>\n" +
"        <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/swiper-bundle.min.css\" />\n" +
"        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n" +
"        <link rel=\"stylesheet\" href=\"flstyle.css\">\n" +
"        <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n" +
"        <script>\n" +
"            function fun(){\n" +
"                swal({\n" +
"                    title: \"Are you sure?\",\n" +
"                    text: \"You want to Log Out\",\n" +
"                    icon: \"warning\",\n" +
"                    buttons: true,\n" +
"                    dangerMode: true,\n" +
"                })\n" +
"                .then((willDelete) => {\n" +
"                    if (willDelete) {\n" +
"                        swal(\"You are Successfully Log Out\", {\n" +
"                        icon: \"success\",\n" +
"                        closeOnClickOutside: false,\n" +
"                        confirmButtonText: \"OK\",\n" +
"                        onabort:\"index.html\",\n" +
"                    })\n" +
"                    .then(function() {\n" +
"                        window.location = \"logout\";\n" +
"                    });\n" +
"                    } else {\n" +
"                        swal(\"Logging Out Failed\",\"You are Still Log In !\");\n" +
"                    }\n" +
"                });\n" +
"            }\n" +
"        </script>\n" +
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
"                    <li><a href=\"services.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li><a href=\"index.html#about\">About US</a></li>\n" +
"                    <li><a href=\"index.html#contact\">Contact US</a></li>\n" +
"                    <li onclick=\"fun()\"><a>Log Out</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"userlogin\" id=\"userlogin\">\n" +
"            <center>\n" +
"            <div class=\"username\">\n" +
"                <h1>Welcome !! To <span>Evneto</span></h1>\n" +
"                <h2>Trusted Event Services\n" +
"                    for every Indian Occassion</h2>\n" +
"            </div>\n" +
"            <div class=\"details\">\n" +
"                <h2>Book Your Event </h2>\n" +
"                <div class=\"butt\">\n" +
"                    <ul>\n" +
"                        <li class=\"bttn\"><a href=\"user_CHOOSE.html\">Event Details</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Your Payment Status</h2>\n" +
"                <div class=\"butt\">\n" +
"                    <ul>\n" +
"                        <li class=\"bttn\"><a href=\"user_payment\">Payments</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Cancel your Event Booking</h2>\n" +
"                <div class=\"butt\">\n" +
"                    <ul>\n" +
"                    <li class=\"bttn\"><a href=\"user_cancellation\">Cancellation</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Your Feedback</h2>\n" +
"                <div class=\"butt\">\n" +
"                    <ul>\n" +
"                        <li class=\"bttn\"><a href=\"user_feedback.html\">Feedback</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"            </div>\n" +
"        </center>\n" +
"        </section>\n" +
"        <section class=\"about\" id=\"about\">\n" +
"            <center>\n" +
"                <h1><span>About</span> US </h1>\n" +
"            \n" +
"            <div class=\"row\">\n" +
"                <div class=\"image\">\n" +
"                    <img src=\"photo/pic 2.jpeg\" alt=\"\">\n" +
"                </div>\n" +
"                <div class=\"content\">\n" +
"                    <h3>We will give a very special celebration for you</h3>\n" +
"                    <p>We founded <b>EVNETO</b> with one goal in mind: to design and produce creative and unforgettable events for every occasion. From small intimate affairs to large-scale parties, we strive to execute events that not only aim to impress,\n" +
"                         but also to create unique experiences for our clients and their guests that last long after the fun is over.</p>\n" +
"                    <a href=\"#contact\" class=\"btn\"><b>Contact US</b></a>\n" +
"                </div>\n" +
"            </div>\n" +
"        </center>\n" +
"        </section>\n" +
"        <section class=\"contact\" id=\"contact\">\n" +
"            <center>\n" +
"            <h1> <span>Contact</span> Us </h1>\n" +
"            <form action=\"\">\n" +
"                <div class=\"inputBox\">\n" +
"                    <input type=\"text\" placeholder=\"name\" required>\n" +
"                    <input type=\"email\" placeholder=\"email\" required>\n" +
"                </div>\n" +
"                <div class=\"inputBox\">\n" +
"                    <input type=\"number\" placeholder=\"Phn No.\" required>\n" +
"                    <input type=\"text\" placeholder=\"subject\" required>\n" +
"                </div>\n" +
"                <textarea name=\"message\" placeholder=\"your message\" cols=\"10\" rows=\"5\" required></textarea>\n" +
"                <div class=\"but\">\n" +
"                    <input type=\"Submit\" value=\"Send Message\" class=\"btn\">\n" +
"                </div>\n" +
"            </form>\n" +
"        </center>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
                }
                else
                {
                    String q="select * from provider where Email_id='"+nm1+"' and password= '"+nm2+"' and status4='true'";
                    ResultSet x=st.executeQuery(q);
                    if(x.next())
                    {
                        HttpSession pro=req.getSession();
                        pro.setAttribute("proemail", nm1);
                        pw.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"    <head>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <title>Event Organise Gallery</title>\n" +
"        <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/swiper-bundle.min.css\" />\n" +
"        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n" +
"        <link rel=\"stylesheet\" href=\"pstyle.css\">\n" +
"        <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n" +
"        <script>\n" +
"            function fun(){\n" +
"                swal({\n" +
"                    title: \"Are you sure?\",\n" +
"                    text: \"You want to Log Out\",\n" +
"                    icon: \"warning\",\n" +
"                    buttons: true,\n" +
"                    dangerMode: true,\n" +
"                })\n" +
"                .then((willDelete) => {\n" +
"                    if (willDelete) {\n" +
"                        swal(\"You are Successfully Log Out\", {\n" +
"                        icon: \"success\",\n" +
"                        closeOnClickOutside: false,\n" +
"                        confirmButtonText: \"OK\",\n" +
"                        onabort:\"index.html\",\n" +
"                    })\n" +
"                    .then(function() {\n" +
"                        window.location = \"logout\";\n" +
"                    });\n" +
"                    } else {\n" +
"                        swal(\"Logging Out Failed\",\"You are Still Log In !\");\n" +
"                    }\n" +
"                });\n" +
"            }\n" +
"        </script>\n" +
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
"                    <li class=\"active\"><a href=\"provider_home.html\">Home</a></li>\n" +
"                    <li><a href=\"services.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li><a href=\"Provider_home.html#about\">About US</a></li>\n" +
"                    <li><a href=\"Provider_home.html#contact\">Contact US</a></li>\n" +
"                    <li onclick=\"fun()\"><a>Log Out</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"userlogin\" id=\"userlogin\">\n" +
"            <center>\n" +
"            <div class=\"username\">\n" +
"                <h1>Welcome !!</h1>\n" +
"            </div>\n" +
"            <div class=\"details\">\n" +
"                <h2>Your Pending Requests </h2>\n" +
"                <div class=\"butt\">\n" +
"                    <ul>\n" +
"                        <li class=\"bttn\"><a href=\"provider_details\">Pending Requests</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Your work status</h2>\n" +
"                <div class=\"butt\">\n" +
"                    <ul>\n" +
"                        <li class=\"bttn\"><a href=\"details\">Completed</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Work Page</h2>\n" +
"                <div class=\"butt\">\n" +
"                    <ul>\n" +
"                        <li class=\"bttn\"><a href=\"worklist\">See Your Worklist</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Payment Status</h2>\n" +
"                <div class=\"butt\">\n" +
"                    <ul>\n" +
"                        <li class=\"bttn\"><a href=\"provider_status\">See Your Payment</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"            </div>\n" +
"        </center>\n" +
"        </section>\n" +
"        <section class=\"about\" id=\"about\">\n" +
"            <center>\n" +
"                <h1><span>About</span> US </h1>\n" +
"            \n" +
"            <div class=\"row\">\n" +
"                <div class=\"image\">\n" +
"                    <img src=\"photo/pic 2.jpeg\" alt=\"\">\n" +
"                </div>\n" +
"                <div class=\"content\">\n" +
"                    <h3>We will give a very special celebration for you</h3>\n" +
"                    <p>We founded <b>EVNETO</b> with one goal in mind: to design and produce creative and unforgettable events for every occasion. From small intimate affairs to large-scale parties, we strive to execute events that not only aim to impress,\n" +
"                         but also to create unique experiences for our clients and their guests that last long after the fun is over.</p>\n" +
"                    <a href=\"#contact\" class=\"btn\"><b>Contact US</b></a>\n" +
"                </div>\n" +
"            </div>\n" +
"        </center>\n" +
"        </section>\n" +
"        <section class=\"contact\" id=\"contact\">\n" +
"            <center>\n" +
"            <h1> <span>Contact</span> Us </h1>\n" +
"            <form action=\"\">\n" +
"                <div class=\"inputBox\">\n" +
"                    <input type=\"text\" placeholder=\"name\" required>\n" +
"                    <input type=\"email\" placeholder=\"email\" required>\n" +
"                </div>\n" +
"                <div class=\"inputBox\">\n" +
"                    <input type=\"number\" placeholder=\"Phn No.\" required>\n" +
"                    <input type=\"text\" placeholder=\"subject\" required>\n" +
"                </div>\n" +
"                <textarea name=\"message\" placeholder=\"your message\" cols=\"10\" rows=\"5\" required></textarea>\n" +
"                <div class=\"but\">\n" +
"                    <input type=\"Submit\" value=\"Send Message\" class=\"btn\">\n" +
"                </div>\n" +
"            </form>\n" +
"        </center>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
                    }
                    else
                    {
                        String q1="select * from MANAGER where Email_id='"+nm1+"' and password= '"+nm2+"' and status4='true'";
                        ResultSet x1=st.executeQuery(q1);
                        if(x1.next())
                        {
                            HttpSession man=req.getSession();
                            man.setAttribute("manemail", nm1);
                            pw.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"    <head>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <title>Event Organise Gallery</title>\n" +
"        <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/swiper-bundle.min.css\" />\n" +
"        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n" +
"        <link rel=\"stylesheet\" href=\"mnstyle.css\">\n" +
"        <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n" +
"        <script>\n" +
"            function fun(){\n" +
"                swal({\n" +
"                    title: \"Are you sure?\",\n" +
"                    text: \"You want to Log Out\",\n" +
"                    icon: \"warning\",\n" +
"                    buttons: true,\n" +
"                    dangerMode: true,\n" +
"                })\n" +
"                .then((willDelete) => {\n" +
"                    if (willDelete) {\n" +
"                        swal(\"You are Successfully Log Out\", {\n" +
"                        icon: \"success\",\n" +
"                        closeOnClickOutside: false,\n" +
"                        confirmButtonText: \"OK\",\n" +
"                        onabort:\"index.html\",\n" +
"                    })\n" +
"                    .then(function() {\n" +
"                        window.location = \"logout\";\n" +
"                    });\n" +
"                    } else {\n" +
"                        swal(\"Logging Out Failed\",\"You are Still Log In !\");\n" +
"                    }\n" +
"                });\n" +
"            }\n" +
"        </script>\n" +
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
"                    <li class=\"active\"><a href=\"manager_page.html\">Home</a></li>\n" +
"                    <li><a href=\"services.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li><a href=\"manager_home#about\">About US</a></li>\n" +
"                    <li><a href=\"manager_home#contact\">Contact US</a></li>\n" +
"                    <li onclick=\"fun()\"><a>Log Out</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"userlogin\" id=\"userlogin\">\n" +
"            <center>\n" +
"            <div class=\"username\">\n" +
"                <h1>Welcome !!</h1>\n" +
"            </div>\n" +
"            <div class=\"details\">\n" +
"                <h2>Your Pending Requests </h2>\n" +
"                <div class=\"butt\">\n" +
"                    <ul>\n" +
"                        <li class=\"bttn\"><a href=\"manager_pending\">Pending Requests</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Your work status</h2>\n" +
"                <div class=\"butt\">\n" +
"                    <ul>\n" +
"                        <li class=\"bttn\"><a href=\"manager_compdetails\">Completed</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Work Page</h2>\n" +
"                <div class=\"butt\">\n" +
"                    <ul>\n" +
"                        <li class=\"bttn\"><a href=\"manager_worklist\">See Your Worklist</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Pay commission</h2>\n" +
"                <div class=\"butt\">\n" +
"                    <ul>\n" +
"                        <li class=\"bttn\"><a href=\"manager_pay\">pay</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Payment Status</h2>\n" +
"                <div class=\"butt\">\n" +
"                    <ul>\n" +
"                        <li class=\"bttn\"><a href=\"manager_status\">See Your Payment</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                </div>\n" +
"        </center>\n" +
"        </section>\n" +
"        <section class=\"about\" id=\"about\">\n" +
"            <center>\n" +
"                <h1><span>About</span> US </h1>\n" +
"            \n" +
"            <div class=\"row\">\n" +
"                <div class=\"image\">\n" +
"                    <img src=\"photo/pic 2.jpeg\" alt=\"\">\n" +
"                </div>\n" +
"                <div class=\"content\">\n" +
"                    <h3>We will give a very special celebration for you</h3>\n" +
"                    <p>We founded <b>EVNETO</b> with one goal in mind: to design and produce creative and unforgettable events for every occasion. From small intimate affairs to large-scale parties, we strive to execute events that not only aim to impress,\n" +
"                         but also to create unique experiences for our clients and their guests that last long after the fun is over.</p>\n" +
"                    <a href=\"#contact\" class=\"btn\"><b>Contact US</b></a>\n" +
"                </div>\n" +
"            </div>\n" +
"        </center>\n" +
"        </section>\n" +
"        <section class=\"contact\" id=\"contact\">\n" +
"            <center>\n" +
"            <h1> <span>Contact</span> Us </h1>\n" +
"            <form action=\"\">\n" +
"                <div class=\"inputBox\">\n" +
"                    <input type=\"text\" placeholder=\"name\" required>\n" +
"                    <input type=\"email\" placeholder=\"email\" required>\n" +
"                </div>\n" +
"                <div class=\"inputBox\">\n" +
"                    <input type=\"number\" placeholder=\"Phn No.\" required>\n" +
"                    <input type=\"text\" placeholder=\"subject\" required>\n" +
"                </div>\n" +
"                <textarea name=\"message\" placeholder=\"your message\" cols=\"10\" rows=\"5\" required></textarea>\n" +
"                <div class=\"but\">\n" +
"                    <input type=\"Submit\" value=\"Send Message\" class=\"btn\">\n" +
"                </div>\n" +
"            </form>\n" +
"        </center>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
                        }
                        else
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
"            <P><font size=\"6\"> Login Failed</font></p> <BR><BR><a href=login.html><font color=\"white\">Go to home</font></a>\n" +
"        </div>\n" +
"    </center>\n" +
"    </body>\n" +
"</html>"); 
                        }
                }
                }
            }
        }
        catch(Exception e){
            pw.print(e);
        }
    }
}