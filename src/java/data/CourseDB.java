/*
 * Project: IntegratedApp
 * Program: CourseDB.java
 */
package data;
import java.sql.*;
import business.Course;
import java.util.ArrayList;

public class CourseDB {
    public static ArrayList<Course> CourseListing(String term, String department){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Course> list = new ArrayList<>();
        
        String query = "select CourseNo, RegCode, Title, Instructor, DaysTimes, Credits, Enrolled " +
                       "from Course_ " +
                       "where Term = ? " +
                       "and Department = ? " +
                       "order by CourseNo";       
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, term);
            ps.setString(2, department);
            rs = ps.executeQuery();
            Course course = null;
            while (rs.next()){
                course = new Course();
                course.setCourseNo(rs.getString("CourseNo"));
                course.setRegCode(rs.getString("RegCode"));
                course.setTitle(rs.getString("Title"));
                course.setInstructor(rs.getString("Instructor"));
                course.setDaysTimes(rs.getString("DaysTimes"));
                course.setCredits(rs.getString("Credits"));
                course.setEnrolled(rs.getInt("Enrolled"));
                list.add(course);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static ArrayList<Course> CourseListingGeneral(String term){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Course> list = new ArrayList<>();
        
        String query = "select CourseNo, RegCode, Title, Instructor, DaysTimes, Credits " +
                       "from Course_ " +
                       "where Term = ? " +
                       "order by Department"; 
                      
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, term);
            rs = ps.executeQuery();
            Course course = null;
            while (rs.next()){
                course = new Course();
                course.setCourseNo(rs.getString("CourseNo"));
                course.setRegCode(rs.getString("RegCode"));
                course.setTitle(rs.getString("Title"));
                course.setInstructor(rs.getString("Instructor"));
                course.setDaysTimes(rs.getString("DaysTimes"));
                course.setCredits(rs.getString("Credits"));
                list.add(course);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
  
    public static Course selectCourse(String regCode){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "select CourseNo, Title, Enrolled from course_ " +
                       "where RegCode = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, regCode);  
            rs = ps.executeQuery();  
            Course course = null;
            if (rs.next()) {
                course = new Course();
                course.setCourseNo(rs.getString("CourseNo"));
                course.setTitle(rs.getString("Title"));
                course.setEnrolled(rs.getInt("Enrolled"));
            }
            return course;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }              
    } 
    public static int updateEnrolledPlusOne(String regCode){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "update course_ " +
                       "set Enrolled = Enrolled + 1 " +
                       "where RegCode = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, regCode);  
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }              
    } 
    public static int updateEnrolledMinusOne(String regCode){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "update course_ " +
                       "set Enrolled = Enrolled - 1 " +
                       "where RegCode = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, regCode);  
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }              
    }
    public static Course getEnrolled(String regCode){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "select Enrolled " +
                       "from course_ " +
                       "where RegCode = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, regCode);  
            rs = ps.executeQuery();
            Course course = null;
            if (rs.next()){
                course = new Course();
                course.setEnrolled(rs.getInt("Enrolled"));
            }
            return course;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }              
    } 
    
}
