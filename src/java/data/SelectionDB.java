/*
 * Project: IntegratedApp
 * Program: SelectionDB.java
 */
package data;

import business.Selected;
import business.Transcripts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectionDB {
    public static ArrayList<Selected> getSelected(String term, String studentID){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Selected> list = new ArrayList<>();
        String query = "select c.CourseNo, c.RegCode, c.Title, c.Instructor, c.DaysTimes, c.Credits " +
                       "from student_ s " +
                       "inner join transcripts_ t on s.StudentID = t.StudentID " +
                       "inner join course_ c on t.RegCode = c.RegCode " +
                       "where c.Term = ? and s.studentID = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, term);
            ps.setString(2,studentID);
            rs = ps.executeQuery();
            Selected selected = null;
            while (rs.next()) {
                selected = new Selected();
                selected.setCourseNo(rs.getString("CourseNo"));
                selected.setRegCode(rs.getString("regCode"));
                selected.setTitle(rs.getString("Title"));
                selected.setInstructor(rs.getString("Instructor"));
                selected.setDaysTimes(rs.getString("DaysTimes"));
                selected.setCredits(rs.getString("Credits"));                
                list.add(selected);
            }           
            return list;          
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static boolean clearSelected(String term, String studentID){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Selected> list = new ArrayList<>();
        String query = "select c.RegCode " +
                       "from student_ s " +
                       "inner join transcripts_ t on s.StudentID = t.StudentID " +
                       "inner join course_ c on t.RegCode = c.RegCode " +
                       "where c.Term = ? and s.studentID = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, term);
            ps.setString(2,studentID);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Transcripts transcripts = new Transcripts();
                transcripts.setStudentID(studentID);
                transcripts.setRegCode(rs.getString("RegCode"));
                TranscriptsDB.delete(transcripts);
                CourseDB.updateEnrolledMinusOne(rs.getString("RegCode"));
            }           
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
