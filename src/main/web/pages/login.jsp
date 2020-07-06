<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<p>Hello User</p>
<form method="post" action="login" enctype="application/x-www-form-urlencoded">
    <p>
        Login
    </p>
    <label>
        <input type="text" name ="name">
    </label>

    <p>
        Password
    </p>
    <label>
        <input type="password" name="password">
    </label>
    <p>
        <button type = "submit">Login</button>
    </p>
</form>
</body>
</html>
