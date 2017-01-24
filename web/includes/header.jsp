<%-- 
    Project    : IntegratedApp
    Document   : header 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Online Registration</title>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    </head>
    <body>
        <header>
            <h1>Welcome</h1>
            <h2>You can browse the course listing or login to register classes</h2>
        </header>
        <nav id="nav_bar">
            <ul>
                <li><a href="<c:url value='/index.jsp' />">Login</a>
            </ul>
        </nav>
