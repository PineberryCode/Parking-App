/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Format.TextPrompt;
import Format.textGenerals;
import dao.CRUD_OwnerAutomobile;
import dao.CRUD_OwnerTicket;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.automobile;
import model.ticket;
import view.ownerAutomobile;
import view.printTicket;
import view.showAll;
import view.welcome;
/**
 *
 * @author mindlunny
 */
public class ctrlOwnerAutomobile implements ActionListener {
    
    public welcome frmWelcome;
    public ctrlWelcome ctrlWelcome;
    public ownerAutomobile frmOwnerAutomobile;
    public showAll frmShowAll;
    public ctrlShowAll ctrlShowAll;
    public printTicket frmPrintTicket;
    public ctrlPrintTicket ctrlPrintTicket;
    public CRUD_OwnerTicket crudOwnerTicket;
    public CRUD_OwnerAutomobile crudOwnerAutomobile;
    public automobile automobile;
    public ticket ticket;
    /*=========================*/
    public TextPrompt textPrompt;
    /*=========================*/
    
    public ctrlOwnerAutomobile ( ownerAutomobile frmOwnerAutomobile ) {
        
        this.frmOwnerAutomobile = frmOwnerAutomobile;
        
        this.frmOwnerAutomobile.jMenuItemWelcome.addActionListener(this);
        this.frmOwnerAutomobile.jMenuItemShowRegistration.addActionListener(this);
        this.frmOwnerAutomobile.jButtonRegistration.addActionListener(this);
        this.frmOwnerAutomobile.jButtonRemove.addActionListener(this);
        
        this.placeHolder();
        this.showfrmOwnerAutomobile(this.frmOwnerAutomobile);
    
    }
    
    public void clean ( ownerAutomobile frmOwnerAutomobile ) {
        
        this.frmOwnerAutomobile = frmOwnerAutomobile;
        this.frmOwnerAutomobile.jTextFieldLicensePlate.setText("");
        this.frmOwnerAutomobile.jTextFieldIdentification.setText("");
        this.frmOwnerAutomobile.jTextFieldLicensePlate.requestFocus();
    
    }
    
    public void placeHolder () {
        
        textPrompt = new TextPrompt("License Plate", this.frmOwnerAutomobile.jTextFieldLicensePlate, Color.GRAY);
        textPrompt = new TextPrompt("Identification", this.frmOwnerAutomobile.jTextFieldIdentification, Color.GRAY);
        
    }
    
    public void updateTable ( showAll frmShowAll ) {
        
        this.frmShowAll = frmShowAll;
        
        if ( this.frmShowAll != null ) {
            
            this.crudOwnerTicket = new CRUD_OwnerTicket();
            this.crudOwnerTicket.showTable(this.frmShowAll.jTableOwnerDetails);
        
        }
    
    }
    
    public static ticket readANDGetDataTicket ( ownerAutomobile frmOwnerAutomobile ) {
        
        automobile automobile = new automobile();
        ticket ticket = new ticket();
        
        automobile.setLicensePlate( frmOwnerAutomobile.jTextFieldLicensePlate.getText() );
        automobile.setIdentificationOwner( frmOwnerAutomobile.jTextFieldIdentification.getText() );
        
        ticket.setAutomobile(automobile);
        ticket.setCost(5);
        
        return ticket;
        
    }
    
    public static ticket getANDRemoveDataTicket ( String licensePlate ) {
        
        automobile automobile = new automobile();
        ticket ticket = new ticket();
        
        automobile.setLicensePlate( licensePlate );
        ticket.setAutomobile(automobile);
        
        return ticket;
        
    }
    
    public static automobile readANDGetDataAutomobile ( ownerAutomobile frmOwnerAutomobile ) {
        
        automobile automobile = new automobile();
        
        automobile.setLicensePlate( frmOwnerAutomobile.jTextFieldLicensePlate.getText() );
        automobile.setIdentificationOwner( frmOwnerAutomobile.jTextFieldIdentification.getText()  );
        
        return automobile;
        
    }
    
    public static automobile getANDRemoveDataAutomobile ( String licensePlate ) { //interface
        
        automobile automobile = new automobile();
        automobile.setLicensePlate( licensePlate );
        
        return automobile;
        
    }
    
    public void showfrmOwnerAutomobile ( ownerAutomobile frmOwnerAutomobile ) {
        
        this.frmOwnerAutomobile = frmOwnerAutomobile;
        this.frmOwnerAutomobile.setResizable(false);
        this.frmOwnerAutomobile.setLocationRelativeTo(null);
        this.frmOwnerAutomobile.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if ( e.getSource() == this.frmOwnerAutomobile.jMenuItemWelcome ) {
            
            this.frmWelcome = new welcome();
            this.ctrlWelcome = new ctrlWelcome(this.frmWelcome);
            this.frmOwnerAutomobile.dispose();
            
        } else if ( e.getSource() == this.frmOwnerAutomobile.jMenuItemShowRegistration ) {
            
            this.frmShowAll = new showAll();
            this.ctrlShowAll = new ctrlShowAll(this.frmShowAll);
            
        }
        
        if ( e.getSource() == this.frmOwnerAutomobile.jButtonRegistration ) {
            
            this.ticket = readANDGetDataTicket(this.frmOwnerAutomobile);
            this.automobile = readANDGetDataAutomobile(this.frmOwnerAutomobile);
            
            this.crudOwnerTicket = new CRUD_OwnerTicket();
            this.crudOwnerAutomobile = new CRUD_OwnerAutomobile();

            this.crudOwnerAutomobile.registration(this.automobile);
            this.crudOwnerTicket.registration(this.ticket);
            
            this.frmPrintTicket = new printTicket();
            this.ctrlPrintTicket = new ctrlPrintTicket(this.frmOwnerAutomobile, this.frmPrintTicket);
            
            clean(this.frmOwnerAutomobile);
            updateTable(this.frmShowAll);
            
        }
        
        if ( e.getSource() == this.frmOwnerAutomobile.jButtonRemove ) {
            
            String licensePlate = textGenerals.textInputDialog("Type the license Plate: ", "Information");
            
            this.crudOwnerTicket = new CRUD_OwnerTicket();
            this.crudOwnerAutomobile = new CRUD_OwnerAutomobile();
            
            this.automobile = crudOwnerAutomobile.searchingLicensePlate(licensePlate);
            
            if ( this.automobile == null ) {
                textGenerals.textMessage("Not exist the license plate: " + licensePlate + " in the data base.");
            } else {
            
                int confirmed = textGenerals.textConfirmDialog("Are you sure?", "Warning");
                
                if ( confirmed == 0 ) {
                
                    this.automobile = getANDRemoveDataAutomobile(licensePlate);
                    this.ticket = getANDRemoveDataTicket(licensePlate);
                
                    this.crudOwnerTicket.remove(this.ticket);
                    this.crudOwnerAutomobile.remove(this.automobile);
                    
                    textGenerals.textMessage("Successfully removed");
                    
                    updateTable(this.frmShowAll);
                    
                }
                
            }
            
        }
        
    }
    
}
