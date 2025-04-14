<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
     <link rel="stylesheet" href="assets/css/login.css">
</head>
<body>
     <button class="home-btn" onclick="window.location.href='<%= request.getContextPath() %>/main'">Go to Home</button>

    <form action="login" method="post">

        <label class="loginText">Login</label>

        <c:if test="${not empty error}">
                                    <div class="error-message">${errorMessage}</div>
                                </c:if>

        <label for="username">Username :</label>
        <input type="text" id="username" name="username" required minlength="3" maxlength="20"><br><br>

        <label for="password">Password :</label>
        <input type="password" id="password" name="password" required minlength="6" maxlength="20"><br><br>

        <div class="showPasswordCheckbox">
            <input type="checkbox" id="showPassword" onclick="togglePasswordVisibility();">
             <label for="showPassword" class="showPassword">Show Password</label><br><br>

        </div><br>

        <input type="submit" value="Login">
    </form>
    <p style="text-align:center;">Don't have an account? <a href="/register">Register here</a>.</p>

    <script src="assets/js/login.js"></script>
</body>
</html>
