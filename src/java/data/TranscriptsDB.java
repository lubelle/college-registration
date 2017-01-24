/*
 * Project: IntegratedApp
 * Program: TranscriptsDB.java
 */
package data;

import java.sql.*;
import business.Transcripts;
import java.util.ArrayList;

public class TranscriptsDB {
    public static int insert(Transcripts transcripts){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query
                = "insert into transcripts_ (StudentID, RegCode) " +
                  "values (?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,transcripts.getStudentID());
            ps.setString(2,transcripts.getRegCode());
            return ps.executeUpdate();          
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static int delete(Transcripts transcripts){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "delete from transcripts_ " +
                       "where StudentID = ? " + 
                       " and RegCode = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,transcripts.getStudentID());
            ps.setString(2,transcripts.getRegCode());
            return ps.executeUpdate();          
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }        
    }  
    public static int update(Transcripts transcripts){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "update transcripts_ set " +
                       "GradePoints = ?, " +
                       "LetterGrade = ? " +
                       "where StudentID = ? " + 
                       "and RegCode = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,transcripts.getGradePoints());
            ps.setString(2,transcripts.getLetterGrade());
            ps.setString(3,transcripts.getStudentID());
            ps.setString(4,transcripts.getRegCode());
            
            return ps.executeUpdate();          
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }        
    }
    public static boolean regCodeExists(String regCode){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "Select regCode from transcripts_ " +
                       "where regCode = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,regCode);            
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
    
    public static ArrayList<Transcripts> enterGrade(String instr, String term, String courseNo){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Transcripts> transcriptList = new ArrayList<>();
        
             String query = "select s.StudentID, t.RegCode, s.FirstName, s.LastName, t.GradePoints, t.LetterGrade " +
                            "from (" +
                            "select distinct t.StudentID, t.RegCode, t.GradePoints, t.LetterGrade " +
                            "from (" +
                            "select RegCode " +
                            "from Course_ " +
                            "where Instructor = ? " + 
                            " and Term = ? " + 
                            " and CourseNo = ? " +
                            ")c" +
                            " join transcripts_ t" +
                            " on t.RegCode = c.RegCode" +
                            ")t" +
                            " join student_ s" +
                            " on s.StudentID = t.StudentId";  
                      
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, instr);
            ps.setString(2, term);
            ps.setString(3, courseNo);
            rs = ps.executeQuery();
            Transcripts grades = null;
            while (rs.next()){
                 grades = new Transcripts();
                 grades.setStudentID(rs.getString(1));
                 grades.setRegCode(rs.getString(2));
                 grades.setFirstName(rs.getString(3));
                 grades.setLastName(rs.getString(4));
                 grades.setGradePoints(rs.getInt(5));
                 grades.setLetterGrade(rs.getString(6));
                 transcriptList.add(grades);
            }
            return transcriptList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
