<%@ page import="java.util.List" %>
<%@ page import="models.Phone" %>
<%@ page import="models.County" %>
<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: Kuat
  Date: 14.06.2023
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="head.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <div class="container">
        <table class="table table-striped">
            <thead>
            <th>ID</th>
            <th>FULL NAME</th>
            <th>AGE</th>
            <th>CITY/CODE</th>
            <th>STREET/INDEX</th>
            </thead>
            <tbody>
                <%
                    List<User> users = (List<User>) request.getAttribute("users");
                    for (User user : users) {
                %>
                <tr>
                    <td><%=user.getId()%></td>
                    <td><%=user.getFullName()%></td>
                    <td><%=user.getAge()%></td>
                    <td><%=user.getCity().getName() + "/" + user.getCity().getCode()%></td>
                    <td><%=user.getCity().getStreet().getName() + "/" +
                    user.getCity().getStreet().getIndex()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
