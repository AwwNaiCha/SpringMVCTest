<%--
  Created by IntelliJ IDEA.
  User: huimin
  Date: 3/26/16
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.sjsu.cmpe275.lab2.*"%>

<%--jsp:useBean id="guestDao" type="guest.GuestDao" scope="request" />
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <hr><ol>
    <% for (Profile profile : guestDao.getAllGuests()) { %>
    <li> <%= guest %> </li>
    <% } %>
  </ol><hr>
  $END$
  </body>
</html--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Car List</h1>

<c:forEach items="${profileList}" var="profile">
  ${profile.id} ${profile.firstname}: ${profile.lastname}
  <br />
</c:forEach>

</body>
</html>