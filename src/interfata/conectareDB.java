package interfata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

public class conectareDB {

    Connection con = null;

    public static Connection Connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Denisa\\eclipse-workspace\\FIS\\database.db");

            return con;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, null);
        }
        return null;
    }
}