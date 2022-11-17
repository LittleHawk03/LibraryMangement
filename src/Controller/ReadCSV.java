/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author honahl
 */
public class ReadCSV {
    private static final String FILE_PATH = "/home/honahl/Documents/java2/SwingIO1/src/data/user.csv";
    private static final String COMMA_DELIMITER = ",";
    
    public static String[] read() {
        
        
        BufferedReader bufferedReader = null;
        
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            String[] data = line.split(COMMA_DELIMITER);
            
            if (!data[0].equals(" ")) {
               return data;
                
            }else{
                return null;
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }finally {
            try {
                if (bufferedReader != null)
                   bufferedReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
        
        return null;
        
        
    }
    
}
