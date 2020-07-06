<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="form" type="controller.dto.ProductForm" scope="request"/>
<html>
<head>
    <title>Products</title>
</head>
<body>
<P>
    Hello!
</P>
<p>
    Here are eatable products:
</p>

    <c:forEach items="${form.eatableProducts}" var="products">
        <p>Product: ${products.name} Price:${products.price} Weight: ${products.weight} Id: ${products.id}</p>
    </c:forEach>

    <p>
        Here are uneatable products:
    </p>

    <c:forEach items="${form.uneatableProducts}" var="products2">
            <p>Product: ${products2.name} Price: ${products2.price} Id: ${products2.id}</p>
    </c:forEach>
<form method="post" action="products" enctype="application/x-www-form-urlencoded">
    <p>
    <label>
        Write an ID of the product that you want to add
        <input type="text" name ="productId">
    </label>
    </p>
    <p>
    <label>
        Write the amount of products
        <input type="text" name ="amount">
    </label>
    </p>
    <p>
        <button type = "submit">Add to your cart</button>
    </p>
</form>
</body>
</html>