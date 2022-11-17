/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author honahl
 */
public class EmployeeDAO {

    private final Connection connection = DBConnection.getConnection();

    public ResultSet searchAll() {
        String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID <> 2";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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

    public Employee search(int id) {
        String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ? AND EMP_ID <> 2";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("EMP_ID"));
                employee.setFullname(rs.getString("Fullname"));
                employee.setGender(rs.getString("Gender"));
                employee.setYear(rs.getInt("YearOfBirth"));
                employee.setPhone(rs.getString("Phone"));
                employee.setAddress(rs.getString("EmAddress"));
                employee.setUsername(rs.getString("usrname"));
                employee.setSignedin(rs.getInt("signedin"));

                return employee;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public ResultSet searchByName(String name) {
        String sql = "SELECT * FROM EMPLOYEE WHERE Fullname = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
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

    public int creat(Employee employee) {
        String sql = "INSERT INTO EMPLOYEE OUTPUT inserted.EMP_ID VALUES (?,?,?,?,?,?,?,?)";
//         ('Nguyen Manh Duc','nam',2002,'Ha Noi','0932273205','LittleHawk03','123456','1')
        try {

            if (checkDuplicate(employee.getUsername())) {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, employee.getFullname());
                preparedStatement.setString(2, employee.getGender());
                preparedStatement.setInt(3, employee.getYear());
                preparedStatement.setString(4, employee.getAddress());
                preparedStatement.setString(5, employee.getPhone());
                preparedStatement.setString(6, employee.getUsername());
                preparedStatement.setString(7, "123456");
                preparedStatement.setInt(8, employee.getSignedin());

                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    return rs.getInt(1);
                }
            } else {
                return -1;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return -1;
    }

    public boolean update(Employee employee) {
        String sql = "UPDATE EMPLOYEE SET Fullname = ?,Gender = ?, YearOfBirth = ?,EmAddress = ?,usrname = ?, signedin = ? WHERE EMP_ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getFullname());
            preparedStatement.setString(2, employee.getGender());
            preparedStatement.setInt(3, employee.getYear());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setString(5, employee.getUsername());
            preparedStatement.setInt(6, employee.getSignedin());
            preparedStatement.setInt(7, employee.getId());

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

    public boolean delete(Integer id) {
        String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

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

    public boolean checkDuplicate(String usrname) {

        String sql = "SELECT COUNT(*) FROM EMPLOYEE WHERE usrname = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, usrname);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getInt(1) > 0) {
                    return false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

    public int CountNumberOfEmployee() {
        String sql = "SELECT COUNT(*) FROM EMPLOYEE";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return -1;
    }
    
    public int CountNumberOfEmployeeSignedIn() {
        String sql = "SELECT COUNT(*) FROM EMPLOYEE WHERE signedin = 1";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return -1;
    }
    
    public int CountNumberOfEmployeeLogOut() {
        String sql = "SELECT COUNT(*) FROM EMPLOYEE WHERE signedin = 0";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return -1;
    }

    public void setSigned(int id) {
        String sql = "UPDATE EMPLOYEE SET signedin = 1 WHERE EMP_ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            int n = preparedStatement.executeUpdate();

            if (n > 0) {
                System.out.println("update ok");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("update not ok");
        }

    }

    public void setLogOut(int id) {
        String sql = "UPDATE EMPLOYEE SET signedin = 0 WHERE EMP_ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            int n = preparedStatement.executeUpdate();

            if (n > 0) {
                System.out.println("update ok");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("update not ok");
        }

    }
}
