package register;
//import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Register extends HttpServlet {
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //ArrayList al=new ArrayList();
	
        String email = request.getParameter("email");
        String phone = request.getParameter("phn");
        String userid = request.getParameter("userid");
        String password = request.getParameter("pass");
        
        try {
        
            // loading drivers for mysql
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            //creating connection with the database 
            Connection con = DriverManager.getConnection
                        ("jdbc:oracle:thin:@localhost:1521:xe","system","scott");

            PreparedStatement ps = con.prepareStatement
                        ("insert into register values(?,?,?,?)");

            ps.setString(1, email);
            ps.setString(2, phone);
            ps.setString(3, userid);
            ps.setString(4, password);
            int i = ps.executeUpdate();
            
            if(i > 0) {
            	out.println("<html>  <head> <meta charset=\"ISO-8859-1\"> <link rel=\"stylesheet\" href=\"css/login.css\">  <style>  *{width:380px; height:480px; }  </style></head> <body> <br><br>  <a href=\"index.html\">Go to home page</a> <form align=\"center\" method=\"post\" action=\"package\" id=\"login\" class=\"input-group\">  ");
            				
                out.println("<h3>You are sucessfully registered </h3> </body></html>");
              
            }
        
        }
        catch(Exception se) {
            se.printStackTrace();
        }
	
    }
}