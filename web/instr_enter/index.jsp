<%-- 
    Document: /instr_enter/index       
--%>

<jsp:include page="/includes/header_instr.jsp" />
<jsp:include page="/includes/column_left_instr.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="data.ConnectionPool"%>
<%@page import="data.DBUtil"%>
<%@page import="java.sql.*" %>
<%    
    String instr = (String)session.getAttribute("facultyName");   
    String message="";
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "select Term, CourseNo " +
                       "from Course_ " +
                       "where Instructor = ? " +
                       "order by Term ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, instr);
            rs = ps.executeQuery();  
            if (rs == null) {
                message = "No available selection";%>
                <p><%= message %></p>
            <%}
            else {
            %>
            <!-- start the middle column -->
            <section>
            <h3>Enter Grade</h3>
            <label>Professor: </label>
            <input type="text" name="instr" readonly style="border:none" value="<%= instr %>" >
            <form action="<c:url value='/InstructorServlet' />" method="post"> 
            <input type="hidden" name="action" value="EnterGrade">
            <input type="hidden" name="instr" value="<%= instr %>">

            <br>
            <p>Select a course:</p>
            <select name="termCourseNo">
                    <% while (rs.next()){ %>
                    <option value="<%= rs.getString(1) + "/" + rs.getString(2)%>"><%= rs.getString(1) + "/" + rs.getString(2)%></option>
                    <% } %>
                    </select>
                    <input type="submit" value="Submit">
            </form>
            </section>
            <!-- end the middle column -->              
<%          }
        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
%>

<jsp:include page="/includes/footer.jsp" />