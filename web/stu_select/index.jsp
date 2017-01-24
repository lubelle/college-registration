<%-- 
    Document   : /stu_select/index       
--%>
<%    
    String sid = (String)session.getAttribute("studentID");
%>
<jsp:include page="/includes/header_student.jsp" />
<jsp:include page="/includes/column_left_student.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- start the middle column -->

<section>
    <h3>Select Courses</h3>
    <form action="<c:url value='/CE5Servlet'/>" method="post">
        <input type="hidden" name="action" value="View">
        <input type="hidden" name="sid" value="<%= sid %>">
        <label>Current Semester: </label>
        <input type="text" name="semester" style="border:none" readonly value="Winter_2015"><br>
        <label>Department:</label>
            <select name="dept">
                <option value="Biology">Biology</option>
                <option value="Accounting">Accounting</option>
                <option value="Economics">Economics</option>
                <option value="French">French</option>
                <option value="Mathematics">Mathematics</option>
                <option value="Sociology">Sociology</option>
            </select><br>
        <label>&nbsp;</label>
        
        <input type="submit" value="Submit">
    </form>

</section>

<!-- end the middle column -->

<jsp:include page="/includes/footer.jsp" />