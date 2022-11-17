/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author honahl
 */
public class DBConnection {
    
    private final static String URL = "jdbc:sqlserver://localhost:1433;databaseName=LIBRARY;encrypt=true;trustServerCertificate=true;" ;
    private final static String USERNAME_MSSQL = "sa";
    private final static String PASSWORD_MSSQL = "123456a@";
    private static Connection connection = null;
    
    
    
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME_MSSQL, PASSWORD_MSSQL);
            System.out.println("connect success");
        } catch (Exception e) {
            System.out.println("connect faile");
            e.printStackTrace();
        }
        return connection;
    }
    
}
