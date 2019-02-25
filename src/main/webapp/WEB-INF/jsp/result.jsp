<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="papers" scope="request" type="java.util.List"/>
<jsp:useBean id="parserType" scope="request" type="java.lang.String"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Result</title>
</head>
<body>
<p align="center">${parserType}</p>
<table align="center">
    <tr>
        <th>Name</th>
        <th>ID</th>
        <th>Date</th>
        <th>Index</th>
        <th>Monthly</th>
        <th>Color</th>
        <th>Coated</th>
        <th>Pages</th>
    </tr>

    <c:forEach items="${papers}" var="paper">
        <tr>
            <td align="center">${paper.getName()}</td>
            <td align="center">${paper.getId()}</td>
            <td align="center">${paper.getDate()}</td>
            <td align="center">${paper.getIndex()}</td>
            <td align="center">${paper.getMonthly()}</td>
            <td align="center">${paper.getSpecications().getColor()}</td>
            <td align="center">${paper.getSpecications().getCoated()}</td>
            <td align="center">${paper.getSpecications().getPages()}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>