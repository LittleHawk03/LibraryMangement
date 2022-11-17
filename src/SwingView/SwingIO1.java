/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SwingView;

import Controller.ReadCSV;

/**
 *
 * @author honahl
 */
public class SwingIO1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Create and display the form */

        String[] data = ReadCSV.read();

        if (data != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new HomePage().setVisible(true);
                }
            });
            System.out.println(data[0]);
        } else {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new LoginPage().setVisible(true);
                }
            });
        }

    }

}
