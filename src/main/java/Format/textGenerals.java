/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Format;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JPanel;

/**
 *
 * @author mindlunny
 */
public class textGenerals {
    
    public static void square ( Color color, JPanel jPanel ) {
        
        jPanel.setBackground(color);
    
    }
    
    public static void text ( JLabel jLabel, String text ) {
        
        jLabel.setText(text);
        
    }
    
    public static int textConfirmDialog ( String text, String title ) {
        
        return JOptionPane.showConfirmDialog(null, text, title, YES_NO_OPTION, WARNING_MESSAGE);
        
    }
    
    public static void textMessage ( String text ) {
        
        JOptionPane.showMessageDialog(null, text);
        
    }
    
    public static String textInputDialog ( String text, String title ) {
        
        return JOptionPane.showInputDialog(null, text, title, YES_NO_OPTION);
        
    }
    
}
