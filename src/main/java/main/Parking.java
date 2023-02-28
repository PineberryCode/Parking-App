package main;

import view.welcome;
import controller.ctrlWelcome;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author mindlunny
 */

public class Parking {

    public static welcome frmWelcome;
    public static ctrlWelcome ctrlWelcome;
    
    public static void main(String[] args) {
        frmWelcome = new welcome();
        ctrlWelcome = new ctrlWelcome(frmWelcome);
    }
}
