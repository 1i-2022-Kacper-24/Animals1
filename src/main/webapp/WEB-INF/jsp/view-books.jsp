<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View Books</title>
</head>
<body>
<h2>Books</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Pages</th>
        <th>Library Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.pages}</td>
            <td>${book.library.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
