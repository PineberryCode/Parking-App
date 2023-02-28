/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Format.textGenerals;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mindlunny
 */
public class connection_db implements parameter {
    
    public Connection connect = null;
    public Statement statement;
    public ResultSet resultSet;
    public PreparedStatement preparedStatement;
    
    public Connection StayConnection () {
        
        try {
            
            Class.forName(DRIVER);
            connect = DriverManager.getConnection(STRING,USER,PASSWORD);
            statement = connect.createStatement();
            
        } catch (ClassNotFoundException | SQLException error) {
            textGenerals.textMessage(error.toString());
        }
        
        return connect;
        
    }
    
}
