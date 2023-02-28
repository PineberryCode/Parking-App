/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Format.textGenerals;
import java.sql.SQLException;
import model.automobile;

/**
 *
 * @author mindlunny
 */
public class CRUD_OwnerAutomobile extends connection_db implements ownerMethods {
    
    public automobile automobile;
    
    public automobile searchingLicensePlate ( String licensePlate ) {

        automobile auto = null;
        
        String query = "SELECT * FROM automobile HAVING licensePlate = '" + licensePlate + "';";
        
        try {
            
            statement = StayConnection().createStatement();
            resultSet = statement.executeQuery(query);
            
            if ( resultSet.next()  ) {
                
                auto = new automobile();
                auto.setLicensePlate(resultSet.getString(1));
                
            }
            
            connect.close();
            
        } catch ( SQLException sqlError ) {
            textGenerals.textMessage(sqlError.toString());
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                }
            }
        }
        
        return auto;
        
    }

    @Override
    public void registration(Object object) {
        
        this.automobile = new automobile();
        automobile auto = (automobile) object;
        
        String query = "INSERT INTO automobile VALUES (?,?);";
        
        try {
            
            connect = StayConnection();
            preparedStatement = connect.prepareStatement(query);
            
            preparedStatement.setString(1, auto.getLicensePlate() );
            preparedStatement.setString(2, auto.getIdentificationOwner() );
            
            preparedStatement.executeUpdate();
            
            connect.close();
                    
        } catch ( SQLException sqlError ) {
            textGenerals.textMessage(sqlError.toString());
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void remove(Object object) {
        
        this.automobile = new automobile();
        automobile auto = (automobile) object;
        
        String query = "DELETE FROM automobile WHERE licensePlate = ?;";
        
        try {
            
            connect = StayConnection();
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, auto.getLicensePlate());
            preparedStatement.executeUpdate();
            
            connect.close();
            
        } catch ( SQLException sqlError ) {
            textGenerals.textMessage(sqlError.toString());
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                }
            }
        }
        
    }
    
}
