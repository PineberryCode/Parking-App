/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mindlunny
 */
public class automobile extends owner {
    
    private String licensePlate;
    private String identificationOwner;

    public String getLicensePlate () { return licensePlate; }

    public void setLicensePlate ( String licensePlate ) { this.licensePlate = licensePlate; }

    public String getIdentificationOwner () { return identificationOwner; }

    public void setIdentificationOwner ( String identificationOwner ) { this.identificationOwner = identificationOwner; }

    @Override
    public String show() {
        
        return  "\nLicense Plate:    " + this.getLicensePlate() +
                "\nOwner:   " + this.getIdentificationOwner();
        
    }
    
}
