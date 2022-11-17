/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author honahl
 */
public class BookDAO {
    
    
    private final Connection connection = DBConnection.getConnection();
    
    
    public Book search(Integer  id){
        String sql  = "SELECT * FROM BOOK WHERE BookID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setType(rs.getString(3));
                book.setField(rs.getString(4));
                book.setAuthor(rs.getString(5));
                book.setPublish(rs.getString(6));
                book.setYear(rs.getInt(7));
                
                return book;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public ResultSet searchByName(String name){
        String sql  = "SELECT * FROM BOOK WHERE BookName = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs != null) {
                return rs;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    
    public boolean creat(Book book){
        String sql = "INSERT INTO BOOK VALUES (?,?,?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getType());
            preparedStatement.setString(3, book.getField());
            preparedStatement.setString(4, book.getAuthor());
            preparedStatement.setString(5, book.getPublish());
            preparedStatement.setInt(6, book.getYear());
            
            int n = preparedStatement.executeUpdate();
            
            if (n > 0) {
                return true;
            }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(Book book){
        String sql = "DELETE FROM BOOK WHERE BookID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book.getId());
            
            int n = preparedStatement.executeUpdate();
            
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(Book book){
        String sql = "UPDATE READER SET BookName = ?, BookType = ?,BookField = ?,BookAuthor = ?,BookPublishing = ?,BookYearPub = ? WHERE BookID = ?";
        
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getType());
            preparedStatement.setString(3, book.getField());
            preparedStatement.setString(4, book.getAuthor());
            preparedStatement.setString(5, book.getPublish());
            preparedStatement.setInt(6, book.getYear());
            preparedStatement.setInt(7, book.getId());
            
            int n = preparedStatement.executeUpdate();
            
            if (n > 0) {
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
}
