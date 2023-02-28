/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CRUD_OwnerTicket;
import javax.swing.JFrame;
import view.showAll;

/**
 *
 * @author mindlunny
 */
public class ctrlShowAll {
    
    public showAll frmShowAll;
    public CRUD_OwnerTicket crudOwnerTicket;
    
    public ctrlShowAll ( showAll frmShowAll ) {
        
        this.frmShowAll = frmShowAll;
        
        this.showTable();
        this.showfrmShowAll(this.frmShowAll);
        
    }
    
    public void showTable () {
        
        this.crudOwnerTicket = new CRUD_OwnerTicket();
        this.crudOwnerTicket.showTable(this.frmShowAll.jTableOwnerDetails);
    
    }
    
    public void showfrmShowAll ( showAll frmShowAll ) {
        
        this.frmShowAll = frmShowAll;
        this.frmShowAll.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frmShowAll.setResizable(false);
        this.frmShowAll.setLocationRelativeTo(null);
        this.frmShowAll.setVisible(true);
        
    }
    
}
