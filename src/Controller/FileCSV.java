/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Employee;
import java.io.FileWriter;

/**
 *
 * @author honahl
 */
public class FileCSV {

//    private static final String FILE_HEADER = "id, username, fullname";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_PATH = "/home/honahl/Documents/java2/SwingIO1/src/data/user.csv";

    public static void add(int id,String usr, String fullname) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(FILE_PATH);
//            fileWriter.append(FILE_HEADER);
//            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append(Integer.toString(id));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(usr);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(fullname);
            fileWriter.append(NEW_LINE_SEPARATOR);

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();

        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }

    }

}
