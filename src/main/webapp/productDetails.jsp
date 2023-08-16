<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
    <h1>Product Details</h1>
    <c:choose>
        <c:when test="${not empty errorMessage}">
            <p>${errorMessage}</p>
        </c:when>
        <c:otherwise>
            <p>Name: ${name}</p>
            <p>Description: ${description}</p>
            <p>Price: $${price}</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
