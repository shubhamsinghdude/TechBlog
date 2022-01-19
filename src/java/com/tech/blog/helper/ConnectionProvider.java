package com.tech.blog.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionProvider {
    
    private static Connection conn;
    static
    {
        try 
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","techblog","shubham");
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Cannot Connect to user");
            ex.printStackTrace();
            System.exit(1);
        }

    }
    public static Connection getConnection() {
        return conn;
    }
    
    public static void closeConnection()  {
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "Connection Disconnected SuccesFully");
        }
        catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Cannot Disconnect with the DB");
           ex.printStackTrace();
        }
    }
}
