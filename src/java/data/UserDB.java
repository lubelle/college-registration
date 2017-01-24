/**
 * Project: IntegratedApp
 * Program: UserDB.java
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {
        public static boolean isStudent(String userName, String password){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "Select StudentID from student_ " +
                       "where StudentID = ? and PassCode = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,userName);  
            ps.setString(2,password);
            rs = ps.executeQuery();  
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }              
    }
    public static boolean isInstructor(String userName, String password){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "Select FacultyName from faculty_ " +
                       "where FacultyName = ? and PassCode = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,userName);  
            ps.setString(2,password);
            rs = ps.executeQuery();  
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }              
    }
}
