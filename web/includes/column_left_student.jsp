<%-- 
    Project  : IntegratedApp
    Document : column_left_student
--%>
<%    
    String sid = (String)session.getAttribute("studentID");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<aside id="sidebarA">
    <nav>
      <ul>
          <li><a href="<c:url value='/stu_select/' />">Select Courses</a></li>
          <li>
              <a href="<c:url value="http://localhost:80/IntegratedApp_PHP/index.php">
                        <c:param name="action" value="Financial" />
                        <c:param name="sid" value='<%= sid %>' />
                       </c:url>">Review Financial Records</a>
          </li>
          
          <li>
              <a href="<c:url value="http://localhost:80/IntegratedApp_PHP/index.php">
                        <c:param name="action" value="Payment" />
                        <c:param name="sid" value='<%= sid %>' />
                       </c:url>">Make Payments</a>
          </li>
          <li>
              <a href="<c:url value='/stu_transcripts/' />">View Transcripts</a></li>         
      </ul>
    </nav>
</aside>