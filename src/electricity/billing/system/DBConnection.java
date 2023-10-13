
package electricity.billing.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    
    Connection con;
    Statement st;

    DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/billmgmt","root","Tanya@3005");
            st=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(ClassNotFoundException cx){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, cx);
        }
        
        
        
    }
}
