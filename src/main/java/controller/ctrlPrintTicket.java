/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Format.textGenerals;
import dao.CRUD_OwnerTicket;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JFrame;
import view.ownerAutomobile;
import view.printTicket;
import view.printerTicket;

/**
 *
 * @author mindlunny
 */
public class ctrlPrintTicket implements ActionListener, Printable {
    
    public printTicket frmTicket;
    public ownerAutomobile frmOwnerAutomobile;
    public CRUD_OwnerTicket crudOwnerTicket;
    public printerTicket frmPanelPrinterTicket;
    
    public ctrlPrintTicket ( ownerAutomobile frmOwnerAutomobile, printTicket frmTicket ) {
        
        this.frmOwnerAutomobile = frmOwnerAutomobile;
        this.frmTicket = frmTicket;
        
        this.frmTicket.jButtonPrint.addActionListener(this);
        
        this.showfrmJPanelTextArea(this.frmOwnerAutomobile, this.frmTicket);
        this.showfrmTicket(this.frmTicket);
        
    }
    
    public void showfrmTicket ( printTicket frmTicket ) {
        
        this.frmTicket = frmTicket;
        this.frmTicket.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frmTicket.setResizable(false);
        this.frmTicket.setLocationRelativeTo(null);
        this.frmTicket.printerTicket.jTextAreaTicket.setEditable(false);
        this.frmTicket.setVisible(true);
    
    }
    
    public void showfrmJPanelTextArea ( ownerAutomobile frmOwnerAutomobile, printTicket frmTicket ) {
        
        this.frmOwnerAutomobile = frmOwnerAutomobile;
        this.frmTicket = frmTicket;
        this.crudOwnerTicket = new CRUD_OwnerTicket();
        this.crudOwnerTicket.showTicket(this.frmTicket.printerTicket.jTextAreaTicket, this.frmOwnerAutomobile.jTextFieldLicensePlate.getText());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if ( e.getSource() == this.frmTicket.jButtonPrint ) {
            
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            printerJob.setPrintable(((Printable) this.frmPanelPrinterTicket));
            
            if ( printerJob.printDialog() ) {
                try {
                    printerJob.print();
                } catch ( PrinterException  printerException ) {
                    
                }
            } else {
                textGenerals.textMessage("Printer canceled");
            }
        
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        
        if ( pageIndex == 0 ) {
            
            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            
            return PAGE_EXISTS;
            
        } else {
            return NO_SUCH_PAGE;
        }
    
    }
    
}
