package register;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Package extends HttpServlet {
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        String tourcode = request.getParameter("tc");
        String tourname = request.getParameter("tn");
        String numberofseats = request.getParameter("seat");
        String dates = request.getParameter("dates");
        
        try {
        
            // loading drivers for mysql
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            //creating connection with the database 
            Connection con = DriverManager.getConnection
                        ("jdbc:oracle:thin:@localhost:1521:xe","system","scott");

            PreparedStatement ps = con.prepareStatement
                        ("insert into book values(?,?,?,?)");

            ps.setString(1, tourcode);
            ps.setString(2, tourname);
            ps.setString(3, numberofseats);
            ps.setString(4, dates);
            int i = ps.executeUpdate();
            
            if(i > 0) {
                out.println("<html>  <head> <meta charset=\"ISO-8859-1\"> <link rel=\"stylesheet\" href=\"css/login.css\">  <style>  *{width:380px; height:480px; }  </style></head> <body> <br><br>  <a href=\"index.html\">Go to home page</a> <form align=\"center\" method=\"post\" action=\"package\" id=\"login\" class=\"input-group\">  ");
				
                out.println("<h3>Your Tour is Booked!<br><br>You will get a confirmation call after paying the amount.</h3> </body></html>");
              
            	
                
            }
        
        }
        catch(Exception se) {
            se.printStackTrace();
        }
	
    }
}