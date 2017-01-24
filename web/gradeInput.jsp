<%-- 
    Program: gradeInput.jsp   
--%>

<jsp:include page="/includes/header_instr.jsp" />
<jsp:include page="/includes/column_left_instr.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
    <form action="<c:url value='/InstructorServlet' />" method="post">
        <h3>Grade Input Form</h3>
        <p>       
            <label>Professor:</label>
            <input type="text" name="instr" style="border:none" readonly value="${instr}"><br>
            <label>Term:</label>
            <input type="text" name="term" style="border:none" readonly value="${term}"><br>
            <label>Course No:</label>
            <input type="text" name="courseNo" style="border:none" readonly value="${courseNo}">
        </p>
        <table border = "1px solid black">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Grade Points</th>
                <th>Grade</th>
            </tr>
            <c:forEach var="rec" items="${transcriptList}">                         
            <tr>
                <td><input type="text" name="studentID" style="border:none" readonly value="${rec.studentID}"></td>
                <td><input type="text" name="fname" style="border:none" readonly value="${rec.firstName}"></td>
                <td><input type="text" name="lname" style="border:none" readonly value="${rec.lastName}"></td>
                <td><input type="text" name="gradePoints" style="text-align:right" pattern="[0-4]" value="${rec.gradePoints}"></td>
                <td><input type="text" name="letterGrade" style="text-align:right" pattern="[ABCDFWI]" value="${rec.letterGrade}"></td>
            </tr>
            </c:forEach>
            
        </table>
        <br>
        <c:forEach var="rec" items="${transcriptList}">
            <input type="hidden" name="regCode" value="${rec.regCode}">
        </c:forEach>
        
        <input type="hidden" name="action" value="SaveToDB">
        <input type="submit"  value="Submit Grades">     
    </form>
</section>

<!-- end the middle column -->

<jsp:include page="/includes/footer.jsp" />
