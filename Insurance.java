package register;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Insurance extends HttpServlet {
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
	
        String a = request.getParameter("fname");
        String b = request.getParameter("lname");
        String c= request.getParameter("mob");
       
        String d = request.getParameter("day");
        String e = request.getParameter("month");
        String f = request.getParameter("year");
        String g = request.getParameter("street");
        String h = request.getParameter("city");
        String i = request.getParameter("state");
        String j = request.getParameter("zip");
        String k = request.getParameter("tc");
        String l = request.getParameter("tn");
        String m = request.getParameter("hos");
        String n= request.getParameter("accident");
        String o = request.getParameter("injury");
        
        try {
        
            // loading drivers for oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            //creating connection with the database 
            Connection con = DriverManager.getConnection
                        ("jdbc:oracle:thin:@localhost:1521:xe","system","scott");

            PreparedStatement ps = con.prepareStatement
                        ("insert into insurance values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, a);
            ps.setString(2, b);
            ps.setString(3, c);
            ps.setString(4, d );
            ps.setString(5, e);
            ps.setString(6, f);
            ps.setString(7, g);
            ps.setString(8, h);
            ps.setString(9, i);
            ps.setString(10, j);
            ps.setString(11, k);
            ps.setString(12, l);
            ps.setString(13, m);
            ps.setString(14, n);
            ps.setString(15, o);
            
            int ii = ps.executeUpdate();
            
            if(ii > 0) {
            	out.println("<html>  <head> <meta charset=\"ISO-8859-1\"> <link rel=\"stylesheet\" href=\"css/login.css\">  <style>  *{width:380px; height:480px; }  </style></head> <body> <br><br>  <a href=\"index.html\">Go to home page</a> <form align=\"center\" method=\"post\" action=\"package\" id=\"login\" class=\"input-group\">  ");
				
                out.println("<h3>Your request for mediclaim is sent!</h3> </body></html>");
              
               
            }
        
        }
        catch(Exception se) {
            se.printStackTrace();
        }
	
    }
}