<%-- 
    Project: IntegratedApp
    Program: selectionResult.jsp
--%>
<%   
    String sid = (String)session.getAttribute("studentID");
    String dept = (String)session.getAttribute("department");
    String semester = (String)session.getAttribute("semester");
%>

<jsp:include page="/includes/header_student.jsp" />
<jsp:include page="/includes/column_left_student.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- start the middle column -->
<section>
    
        <h2>Courses selected for ${semester}</h2>
        <form action="" method="get">
        <table border="1, solid, black">
            <tr>
                <th>Course Number</th>
                <th>RegCode</th>    
                <th>Title</th>
                <th>Instructor</th>
                <th>Days/Times</th>
                <th>Credits</th>
            </tr>
            <c:forEach var="rec" items="${selectedList}">               
            <tr>
                <td><c:out value="${rec.courseNo}" /></td>
                <td><c:out value="${rec.regCode}" /></td>
                <td><c:out value="${rec.title}" /></td>
                <td><c:out value="${rec.instructor}" /></td>
                <td><c:out value="${rec.daysTimes}" /></td>
                <td><c:out value="${rec.credits}" /></td>
            </tr>                 
            </c:forEach>
        </table>
            <br>
            <input type="hidden" name="action" value="View">
            <input type="hidden" name="sid" value="<%= sid %>">
            <input type="hidden" name="semester" value="<%= semester %>">
            <input type="hidden" name="dept" value="<%= dept %>">
            <input type="submit" value="Return To Offerings"> 
        </form>    
</section>            
<!-- end the middle column -->

<jsp:include page="/includes/footer.jsp" />
