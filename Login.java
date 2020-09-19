package register;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class Login extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String userid = request.getParameter("userid");
        String password = request.getParameter("pass");
        
        if(Validate.checkUser(userid, password))
        {
            RequestDispatcher rs = request.getRequestDispatcher("package.html");
            rs.forward(request, response);
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("login.html");
           rs.include(request, response);
        }
    }  
}