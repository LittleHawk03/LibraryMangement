/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author honahl
 */
public class StatisticalDAO {

    private final Connection connection = DBConnection.getConnection();

    public int NumberOfBook() {
        String sql = "SELECT COUNT(BookID) FROM CTPM";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return -1;
    }

    public int unpaidBook() {
        String sql = "SELECT COUNT(BookID) FROM CTPM WHERE BookReturn = 0";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return -1;
    }

    public int paidBook() {
        String sql = "SELECT COUNT(BookID) FROM CTPM WHERE BookReturn = 1";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return -1;
    }

    public int numberOfCallCard() {
        String sql = "SELECT COUNT(*) FROM PHIEUMUON";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return -1;
    }

    public ResultSet lateStudent() {
        String sql = "SELECT RE.READ_ID,Fullname,COUNT(BookID) " + "FROM (PHIEUMUON PM JOIN CTPM CT ON PM.PM_ID = CT.PM_ID) JOIN READER RE ON PM.READ_ID = RE.READ_ID \n"
                + "WHERE BookReturn = 0 AND DueTo < GETDATE() "
                + "GROUP BY RE.READ_ID,Fullname";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                return rs;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public ResultSet topBook() {
        String sql = "SELECT A.BookID,B.BookName,COUNT(A.BookID) AS NUM FROM CTPM AS A JOIN BOOK AS B ON A.BookID = B.BookID GROUP BY A.BookID,B.BookName ORDER BY NUM DESC ";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                return rs;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public int numberOfLateReader() {
        String sql = "SELECT COUNT(BookID) FROM (PHIEUMUON PM JOIN CTPM CT ON PM.PM_ID = CT.PM_ID) JOIN READER RE ON PM.READ_ID = RE.READ_ID WHERE BookReturn = 0 AND DueTo < GETDATE() GROUP BY RE.READ_ID,Fullname";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return -1;
    }
    
    public int numberOfBookToday() {
        String sql = "SELECT COUNT(*) FROM CTPM WHERE DateBorrow = GETDATE()";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return -1;
    }

}
