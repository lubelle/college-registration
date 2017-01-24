<%-- 
    Program: confirmation.jsp   
--%>

<jsp:include page="/includes/header_instr.jsp" />
<jsp:include page="/includes/column_left_instr.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
    
       
        <p>       
            <label>Professor:</label>
            <input type="text" name="instr" style="border:none" readonly value="${instr}"><br>
            <label>Term:</label>
            <input type="text" name="term" style="border:none" readonly value="${term}"><br>
            <label>Course No:</label>
            <input type="text" name="courseNo" style="border:none" readonly value="${courseNo}"><br>
            <label>Status:</label><p>Grades input/update confirmed</p>
        
        

</section>

<!-- end the middle column -->

<jsp:include page="/includes/footer.jsp" />