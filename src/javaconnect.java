
import java.sql.*;
import javax.swing.*;

/*Declaring a class named javaconnect*/
public class javaconnect {
    /*Declaring a variable conn of type Connection avaiable from sql package of java*/
    Connection conn = null;
    
    /*ConnectDb will return an object of type Connection*/
    public static Connection ConnectDb() {
        try {
            /* ABout Class.forName read at http://www.xyzws.com/Javafaq/what-does-classforname-method-do/17*/
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:project124.sqlite");
            /* Following will open a message dialog*/    
            JOptionPane.showMessageDialog(null, "Connction Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
