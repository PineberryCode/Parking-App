/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author mindlunny
 */
public interface parameter {
    
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String USER = "root";
    public static final String PASSWORD = "123456789";
    public static final String DATABASE = "parking";
    public static final String IP = "localhost";
    public static final String PORT = "3306";
    
    public static final String STRING = "jdbc:mysql://"+IP+":"+PORT+"/"+DATABASE;

}
