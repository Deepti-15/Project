package register;
import java.sql.*;

public class Validate {
    public static boolean checkUser(String userid,String password) 
    {
        boolean st =false;
        try {

            //loading drivers for mysql
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","scott");
            PreparedStatement ps = con.prepareStatement("select * from register where userid=? and password=?");
            ps.setString(1, userid);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}