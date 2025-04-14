<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel - Login</title>
       <link rel="stylesheet" href="assets/css/admin_login.css">
</head>
<body>
    <button class="home-btn" onclick="window.location.href='<%= request.getContextPath() %>/main'">Go to Home</button>

    <div class="login-container">
        <h2>Admin Login</h2>

                <c:if test="${not empty error}">
                            <div class="error-message">${error}</div>
                        </c:if>

        <form action="AdminLogin" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="submit" value="Login">
        </form>
    </div>
</body>
</html>
