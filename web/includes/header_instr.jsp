<%-- 
    Project    : IntegratedApp
    Document   : header_instr
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
            <h2>Instructor Menu</h2>
        </header>
        <nav id="nav_bar">
            <ul>
              <li>
              <div class="dropdown">
                 <button class="dropbtn">Course Listing</button>
                    <div class="dropdown-content">
                       <a href="<c:url value='/CE5Servlet?action=Preview&semester=Winter_2015' />">Winter 2015</a>
                       <a href="<c:url value='/CE5Servlet?action=Preview&semester=Fall_2014' />">Fall 2014</a>
                       <a href="<c:url value='/CE5Servlet?action=Preview&semester=Summer_2014' />">Summer 2014</a>
                       <a href="<c:url value='/CE5Servlet?action=Preview&semester=Winter_2014' />">Winter 2014</a>
                    </div>
              </div>
              </li>
              <li><a href="<c:url value='/index.jsp' />">Login</a>
            </ul>
        </nav>