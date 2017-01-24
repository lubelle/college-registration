<%-- 
    Project    : IntegratedApp
    Document   : column_left_home
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<aside id="sidebarA">
    <nav>
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
      </ul>
    </nav>
</aside>

