<%--
  Created by IntelliJ IDEA.
  User: Artur
  Date: 03.07.2020
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <c:choose>
    <c:when test="${empty sessionScope['verifiedUser']}">
      <p>
        <a href="http://localhost:8081/online-shop/products">Products</a>
      </p>
      <p>
        <a href="http://localhost:8081/online-shop/login">Log in</a>
      </p>
    </c:when>
    <c:otherwise>
      Hello, ${sessionScope['verifiedUser']}!
      <a href="http://localhost:8081/online-shop/cart">cart</a>
    </c:otherwise>
  </c:choose>
  </body>
</html>
