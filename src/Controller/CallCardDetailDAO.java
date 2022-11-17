/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CallCardDetail;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author honahl
 */
public class CallCardDetailDAO {

    private final Connection connection = DBConnection.getConnection();

    public boolean creat(CallCardDetail cardDetail) {
        String sql = "INSERT INTO CTPM VALUES (?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cardDetail.getPM_ID());
            preparedStatement.setInt(2, cardDetail.getBookID());
            Date date = new Date(cardDetail.getBorrowDate().getTime());
            preparedStatement.setDate(3, date);
            Date date1 = new Date(cardDetail.getDueTo().getTime());
            preparedStatement.setDate(4, date1);
            preparedStatement.setInt(5, cardDetail.getReturnBook());

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

    public ResultSet searchAll(Integer id_PM) {
        String sql = "SELECT * FROM CTPM AS A JOIN BOOK AS B ON A.BookID = B.BookID WHERE PM_ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_PM);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs != null) {
                
          
                return rs;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public ResultSet searchById(int id_pm, int id_book) {
        String sql = "SELECT * FROM CTPM AS A JOIN BOOK AS B ON A.BookID = B.BookID WHERE PM_ID = ? AND A.BookID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_pm);
            preparedStatement.setInt(2, id_book);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs != null) {
                return rs;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    
    public boolean update(CallCardDetail cardDetail){
        String sql = "UPDATE CTPM SET DateBorrow = ?,DueTo = ?,BookReturn = ? WHERE PM_ID = ? AND BookID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);           
            Date date = new Date(cardDetail.getBorrowDate().getTime());
            preparedStatement.setDate(1, date);
            Date date1 = new Date(cardDetail.getDueTo().getTime());
            preparedStatement.setDate(2, date1);
            preparedStatement.setInt(3, cardDetail.getReturnBook());
            preparedStatement.setInt(4, cardDetail.getPM_ID());
            preparedStatement.setInt(5, cardDetail.getBookID());
            
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
    
    public boolean SetALlReturned(int pm_id){
        String sql = "UPDATE CTPM SET BookReturn = 1 WHERE PM_ID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);           
            preparedStatement.setInt(1, pm_id);
            
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
    
    
    
    public boolean delete(int pm_id , int bookID){
        String sql = "DELETE FROM CTPM WHERE PM_ID = ? AND BookID = ?";
        
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, pm_id);
            preparedStatement.setInt(2,bookID);
            
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
    
    public boolean deleteALL(int pm_id ){
        String sql = "DELETE FROM CTPM WHERE PM_ID = ? ";
        
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, pm_id);
                    
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
