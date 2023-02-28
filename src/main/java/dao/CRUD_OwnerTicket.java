/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Format.textGenerals;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import model.automobile;
import model.ticket;

/**
 *
 * @author mindlunny
 */
public class CRUD_OwnerTicket extends connection_db implements ownerMethods {
    
    public ticket ticket;
    public automobile automobile;
    
    public void showTable ( JTable jTable ) {
        
        String[] header = { "License Plate", "Owner", "Arrival time","Cost" };
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, header);
        jTable.setModel(defaultTableModel);
        
        this.ticket = new ticket();
        this.automobile = new automobile();
        
        String query = """
                        SELECT auto.licensePlate, auto.identificationOwner, tckt.entry, tckt.cost
                        FROM ticket tckt INNER JOIN automobile auto
                        ON tckt.automobile = auto.licensePlate
                        ORDER BY tckt.entry DESC;
                       """;
        
        try {
            
            statement = StayConnection().createStatement();
            resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                
                this.automobile.setLicensePlate(resultSet.getString(1));
                this.automobile.setIdentificationOwner(resultSet.getString(2));
                this.ticket.setAutomobile(this.automobile);
                this.ticket.setEntry(resultSet.getDate(3).toLocalDate());
                this.ticket.setCost(resultSet.getInt(4));
                
                defaultTableModel.addRow(this.ticket.values());
            
            }
            
            connect.close();
            
        } catch ( SQLException sqlError ) {
            textGenerals.textMessage("Couldn't load the table." + sqlError);
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public void showTicket ( JTextArea jTextArea, String licensePlate ) {
        
        String query =  "SELECT auto.licensePlate, auto.identificationOwner, tckt.entry, tckt.cost " +
                        "FROM ticket tckt INNER JOIN automobile auto " +
                        "ON tckt.automobile = auto.licensePlate " +
                        "WHERE auto.licensePlate = '"+ licensePlate +"';";
        
        this.automobile = new automobile();
        this.ticket = new ticket();
        
        try {
            
            statement = StayConnection().createStatement();
            resultSet = statement.executeQuery(query);
            
            if ( resultSet.next() ) {
            
                this.automobile.setLicensePlate(resultSet.getString(1));
                this.automobile.setIdentificationOwner(resultSet.getString(2));
                this.ticket.setAutomobile(this.automobile);
                this.ticket.setEntry(resultSet.getDate(3).toLocalDate());
                this.ticket.setCost(resultSet.getInt(4));
                
                jTextArea.append(this.ticket.show());
            
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
        
    }

    @Override
    public void registration(Object object) {
        
        this.ticket = new ticket();
        ticket tckt = (ticket) object;
        
        String query = "INSERT INTO ticket VALUES (?,?,?);";
        
        try {
            
            connect = StayConnection();
            preparedStatement = connect.prepareStatement(query);
            
            preparedStatement.setString(1, tckt.getAutomobile().getLicensePlate());
            preparedStatement.setObject(2, tckt.entry);
            preparedStatement.setInt(3, tckt.getCost());
            
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
        
        this.ticket = new ticket();
        ticket tckt = (ticket) object;
        
        String query = "DELETE FROM ticket WHERE automobile = ?;";
        
        try {
            
            connect = StayConnection();
            preparedStatement = connect.prepareStatement(query);
            
            preparedStatement.setString(1, tckt.getAutomobile().getLicensePlate());
            
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
