/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author honahl
 */
public class ReaderDAO {

    private final Connection connection = DBConnection.getConnection();

    public Reader search(Integer id) {
        String sql = "SELECT * FROM READER WHERE READ_ID = ?";

        try {
            PreparedStatement preparedStatemen = connection.prepareStatement(sql);
            preparedStatemen.setString(1, Integer.toString(id));

            ResultSet rs = preparedStatemen.executeQuery();

            if (rs.next()) {
                Reader reader = new Reader();
                reader.setId(rs.getInt("READ_ID"));
                reader.setFullName(rs.getString("Fullname"));
                reader.setGender(rs.getString("Gender"));
                reader.setYearOfBirth(rs.getInt("YearOfBirth"));
                reader.setAddress(rs.getString("ReadAddress"));
                reader.setPhone(rs.getString("Phone"));
                reader.setClas(rs.getString("Class"));
                reader.setEmp_Id(rs.getInt("EMP_ID"));

                return reader;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public ResultSet searchByName(String Name) {

        String sql = "SELECT * FROM READER WHERE Fullname = ?";

        try {
            PreparedStatement preparedStatemen = connection.prepareStatement(sql);
            preparedStatemen.setString(1, Name);

            ResultSet rs = preparedStatemen.executeQuery();

            if (rs != null) {
                

                return rs;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean creat(Reader reader) {
        String sql = "INSERT INTO READER VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatemen = connection.prepareStatement(sql);
            preparedStatemen.setString(1, reader.getFullName());
            preparedStatemen.setInt(2, reader.getYearOfBirth());
            preparedStatemen.setString(3, reader.getGender());
            preparedStatemen.setString(4, reader.getAddress());
            preparedStatemen.setString(5, reader.getPhone());
            preparedStatemen.setString(6, reader.getClas());
            preparedStatemen.setInt(7, reader.getEmp_Id());

            int rs = preparedStatemen.executeUpdate();
            if (rs > 0) {

                return true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Reader reader) {
        String sql = "DELETE FROM READER WHERE READ_ID = ? ";

        try {
            PreparedStatement preparedStatemen = connection.prepareStatement(sql);
            preparedStatemen.setInt(1, reader.getId());

            int rs = preparedStatemen.executeUpdate();

            if (rs > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Reader reader) {
        String sql = "UPDATE READER SET Fullname = ?, YearOfBirth = ?,Gender = ?,ReadAddress = ?,Phone = ?,Class = ?,EMP_ID = ? WHERE READ_ID = ?";

        try {
            PreparedStatement preparedStatemen = connection.prepareStatement(sql);
            preparedStatemen.setString(1, reader.getFullName());
            preparedStatemen.setInt(2, reader.getYearOfBirth());
            preparedStatemen.setString(3, reader.getGender());
            preparedStatemen.setString(4, reader.getAddress());
            preparedStatemen.setString(5, reader.getPhone());
            preparedStatemen.setString(6, reader.getClas());
            preparedStatemen.setInt(7, reader.getEmp_Id());
            preparedStatemen.setInt(8, reader.getId());

            int rs = preparedStatemen.executeUpdate();

            if (rs > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
