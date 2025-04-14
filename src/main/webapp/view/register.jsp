<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" href="assets/css/register.css">
</head>
<body>
    <button class="home-btn" onclick="window.location.href='<%= request.getContextPath() %>/main'">Go to Home</button>

    <form action="Register" method="post" onsubmit="return validatePasswords();">

        <label class="registerText">Register</label>

        <label for="fullName">Full Name :</label>
        <input type="text" id="fullName" name="fullName" required minlength="3" maxlength="50"><br><br>

        <label for="username">Username :</label>
        <input type="text" id="username" name="username" required minlength="3" maxlength="20"><br><br>

        <label for="email">Email :</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="number">Phone Number :</label>
        <input type="tel" id="number" name="number" required pattern="[0-9]{10}" title="Enter a valid 10-digit phone number"><br><br>

        <label for="password">Password :</label>
        <input type="password" id="password" name="password" required minlength="6" maxlength="20"><br><br>

        <label for="confirmPassword">Confirm Password :</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required><br>

        
        <div class="showPasswordCheckbox">
            <input type="checkbox" id="showPassword" onclick="togglePasswordVisibility();">
             <label for="showPassword" class="showPassword">Show Password</label><br><br>

        </div><br>
    
        <button class="registerButton">Register</button>
    </form>

    <script src="assets/js/register.js"></script>
</body>
</html>
