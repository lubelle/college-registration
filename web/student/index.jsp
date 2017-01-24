<%-- 
    Project : IntegratedApp
    Document: index
    This is the student's home page after they successfully login.
--%>
<%    
    String sid = (String)session.getAttribute("studentID");
%>

<jsp:include page="/includes/header_student.jsp" />
<jsp:include page="/includes/column_left_student.jsp" />

<!-- start the middle column -->

<section>

    
    <p>Here you can browse and select courses, review your financial records, make payments and view your transcripts</p>


</section>

<!-- end the middle column -->

<jsp:include page="/includes/footer.jsp" />