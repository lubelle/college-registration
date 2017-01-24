<%-- 
    Project : IntegratedApp
    Document: courseOffered
--%>

<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_home.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- start the middle column -->

<section>
    <h2>Courses Offered for ${current_semester}</h2>              
    <table border="1px ,solid, black">
            <tr>
                <th>Course Number</th>
                <th>RegCode</th>  
                <th>Title</th>
                <th>Instructor</th>
                <th>Days/Times</th>
                <th>Credits</th>
            </tr>
            <c:forEach var="rec" items="${courseListingGeneral}" >
            <tr>  
                <td>${rec.courseNo}</td>
                <td>${rec.regCode}</td>              
                <td>${rec.title}</td>   
                <td>${rec.instructor}</td>
                <td>${rec.daysTimes}</td>
                <td>${rec.credits}</td>            
            </tr>
            </c:forEach>              
        </table>
</section>
<!-- end the middle column -->

<jsp:include page="/includes/footer.jsp" />