<%-- 
    Document   : /stu_transcripts/index       
--%>
<%    
    String sid = (String)session.getAttribute("studentID");
%>
<jsp:include page="/includes/header_student.jsp" />
<jsp:include page="/includes/column_left_student.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- start the middle column -->

<section>
    
    <form action="http://localhost:80/IntegratedApp_PHP/index.php" method="get">
        <input type="hidden" name="action" value="Transcripts">
        <input type="hidden" name="sid" value="<%= sid %>">
        
        <h3>View Transcripts</h3>            
        <label>Semester:</label>
            <select name="term">
                <option value="Fall_2014">Fall 2014</option>
                <option value="Summer_2014">Summer 2014</option>
                <option value="Winter_2014">Winter 2014</option>
            </select><br>
        <label>&nbsp;</label>
        
        <input type="submit" value="Submit">
    </form>

</section>

<!-- end the middle column -->

<jsp:include page="/includes/footer.jsp" />