/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author mindlunny
 */
public class ticket extends owner {
    
    private automobile automobile;
    public LocalDate entry = LocalDate.now();
    private int cost;

    public automobile getAutomobile () { return automobile; }
    public void setAutomobile ( automobile automobile ) { this.automobile = automobile; }
    
    public void setEntry ( LocalDate entry ) { this.entry = entry; }
    
    public int getCost () { return cost; }
    public void setCost ( int cost ) { this.cost = cost; }
    
    public Object[] values () {
        Object fila[] = { this.automobile.getLicensePlate(), this.automobile.getIdentificationOwner(), this.entry, this.getCost() };
        
        return fila;
    }
    
    @Override
    public String show () {
        
        return  "\n***************Ticket***************" +
                this.getAutomobile().show() +
                "\nDate Entry:  " + this.entry +
                "\nCost:    " + this.getCost() +
                "\n************************************";
    
    }
    
}
