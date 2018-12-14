import java.sql.*;
import javax.swing.*;

public class javaconnect {

    Connection conn = null;

    public static Connection ConnectDb() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:project124.sqlite");

            JOptionPane.showMessageDialog(null, "Connction Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
