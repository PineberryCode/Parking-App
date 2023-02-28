/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Format.textGenerals;
import dao.connection_db;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import view.ownerAutomobile;
import view.welcome;

/**
 *
 * @author mindlunny
 */
public class ctrlWelcome implements ActionListener {
    
    public welcome frmWelcome;
    public ownerAutomobile frmOwnerAutomobile;
    public ctrlOwnerAutomobile ctrlOwnerAutomobile;
    
    connection_db connect = new connection_db();
    
    public ctrlWelcome ( welcome frmWelcome ) {
        
        this.frmWelcome = frmWelcome;
        
        this.frmWelcome.jMenuItemClientAutomobile.addActionListener(this);
        
        this.showfrmWelcome(this.frmWelcome);
        
    }
    
    public void showfrmWelcome ( welcome frmWelcome ) {
        
        this.frmWelcome = frmWelcome;
        this.frmWelcome.setResizable(false);
        this.frmWelcome.setLocationRelativeTo(null);
        createConnection();
        this.frmWelcome.setVisible(true);
    
    }

    public void createConnection () {
        
        Statement statement = null;
        String hexaGreen = "#00a135";
        
        try {
            
            statement = connect.StayConnection().createStatement();
            
            if ( statement != null ) {
                textGenerals.square(Color.decode(hexaGreen), this.frmWelcome.square);
                textGenerals.text(this.frmWelcome.jLabelVerificateDB, "connected");
            }
            
        } catch ( SQLException sqlError ) {
            textGenerals.textMessage(sqlError.toString());
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if ( e.getSource() == this.frmWelcome.jMenuItemClientAutomobile ) {
            
                frmOwnerAutomobile = new ownerAutomobile();
                ctrlOwnerAutomobile = new ctrlOwnerAutomobile(this.frmOwnerAutomobile);
                frmWelcome.dispose();

        }
        
    }
    
}
