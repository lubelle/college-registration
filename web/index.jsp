<%-- 
    Project    : IntegratedApp
    Document   : login
--%>

<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_home.jsp" />

<!-- start the middle column -->

<section>

    <h2>Login Form</h2>
    <p>Please enter a username and password to continue.</p>
    <p class="error_message"><i>${message}</i></p>
    <form action="LoginServlet" method="post">
        <input type="hidden" name="action" value="register">
        <label>Username</label>
        <input type="text" name="userName" required><br>
        <label>Password</label>
        <input type="password" name="password" required><br>
        <label>&nbsp;</label>
        <input type="submit" value="Submit">
    </form>

</section>

<!-- end the middle column -->

<jsp:include page="/includes/footer.jsp" />