<%-- 
    Program: courseListing.jsp
             The hidden fields were used to pass parameters back to CE5Servlet.
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

    <h2>Courses Offered for <%= semester %></h2>
    
    <table>        
    <c:forEach var="rec" items="${courseListing}" >
    <tr>    
        <td><c:if test="${rec.enrolled >= 10}" ><p class="error_message">Class ${rec.courseNo} is full.</p></c:if></td>
    </tr>    
    </c:forEach>
    </table>

    <form action="<c:url value='CE5Servlet'/>" method="post">   
        <input type="hidden" name="action" value="EnterNewSelection">
        <input type="hidden" name="sid" value="<%= sid %>">
        <input type="hidden" name="dept" value="<%= dept %>">
        <input type="hidden" name="semester" value="<%= semester %>">
        <table border="1px solid black">
            <tr>
                <th>Course Number</th>
                <th>RegCode</th>
                <th>Title</th>
                <th>Instructor</th>
                <th>Days/Times</th>
                <th>Credits</th>
                <th>Select</th>
            </tr>
            
            <c:forEach var="rec" items="${courseListing}" varStatus="status" >
            <tr>  
                <td><input type="text" name="courseNo" style="border:none" readonly value="${rec.courseNo}"></td>
                <td><input type="text" name="regCode" style="border:none" readonly value="${rec.regCode}"></td>              
                <td><input type="text" name="title" style="border:none" readonly value="${rec.title}"></td>   
                <td><input type="text" name="instructor" style="border:none" readonly value="${rec.instructor}"></td>
                <td><input type="text" name="daysTimes" style="border:none" readonly value="${rec.daysTimes}"></td>
                <td><input type="text" name="credits" style="border:none" readonly value="${rec.credits}"></td>
                
                <td><input type="checkbox" name="selected" <c:if test="${rec.isSelected}"> checked="checked"</c:if> value="${status.count}"></td>
            </tr>
            </c:forEach> 
        </table>
        <br>
        <input type="submit" value="Enter New Selection">        
    </form>                            
    <br>    
    <form action="<c:url value='CE5Servlet'/>" method="post">    
        <input type="hidden" name="action" value="ViewPrevious">
        <input type="hidden" name="sid" value="<%= sid %>">
        <input type="hidden" name="dept" value="<%= dept %>">
        <input type="hidden" name="semester" value="<%= semester %>">
        <input type="submit" value="View Previous Selection">
    </form>
    
</section>

<!-- end the middle column -->

<jsp:include page="/includes/footer.jsp" />