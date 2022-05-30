/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package college.information.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbconnect {
    Connection connection;
    void conn() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
            connection = DriverManager.getConnection("jdbc:ucanaccess://E:\\College Information System\\dbcis.accdb");//Establishing Connection
            System.out.println("Connected Successfully");
            
        } catch (Exception e) {
            System.out.println("Error in connection");

        }
    }

    ResultSet search() {

        PreparedStatement pst;
        ResultSet rs = null;
        try {
            pst = connection.prepareStatement("select * from Student_table");
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(dbconnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    ResultSet fun(String u, String p) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from login where UserID=? and Password=? ");
            preparedStatement.setString(1, u);
            preparedStatement.setString(2, p);
            //Creaing Java ResultSet object
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.out.println("No data found");
             Logger.getLogger(dbconnect.class.getName()).log(Level.SEVERE, null, e);

        }
        return resultSet;
    }

   

 

}
