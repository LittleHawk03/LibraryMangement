/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CallCard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author honahl
 */
public class CallCardDAO {

    private final Connection connection = DBConnection.getConnection();

    public int creat(CallCard callCard) {
        String sql = "INSERT INTO PHIEUMUON OUTPUT inserted.PM_ID VALUES (?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, callCard.getEMP_ID());
            preparedStatement.setInt(2, callCard.getRead_id());

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return -1;
    }

    public CallCard search(Integer id) {
        String sql = "SELECT * FROM PHIEUMUON WHERE PM_ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                CallCard callCard = new CallCard();
                callCard.setCallCardID(rs.getInt("PM_ID"));
                callCard.setEMP_ID(rs.getInt("EMP_ID"));
                callCard.setRead_id(rs.getInt("READ_ID"));

                return callCard;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public boolean update(CallCard callCard) {
        String sql = "UPDATE PHIEUMUON SET EMP_ID = ?, READ_ID = ? WHERE PM_ID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, callCard.getEMP_ID());
            preparedStatement.setInt(2, callCard.getRead_id());
            preparedStatement.setInt(3, callCard.getCallCardID());
            
            int n = preparedStatement.executeUpdate();
            
            if (n > 0) {
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
        
    }
    
    public boolean delete(int callCardId){
        String sql = "DELETE FROM PHIEUMUON WHERE PM_ID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, callCardId);
            
            int n = preparedStatement.executeUpdate();
            
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

}
