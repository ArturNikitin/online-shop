<%--
  Created by IntelliJ IDEA.
  User: Artur
  Date: 03.07.2020
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="cart" type="controller.dto.CartForm" scope="request"/>
<html>
<head>
    <title>Cart</title>
</head>
<body>
    <c:forEach items="${cart.products}" var="cart">
        <P>Product: ${cart.key.name} Amount: ${cart.value}</P>
    </c:forEach>
</body>
</html>
