<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tours and Travels</title>
    <link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    <jsp:include page="header.jsp" />

    <div class="login-reg">
        <button class="lr" onClick="window.location.href='login'">Login</button>
        <button class="lr" onClick="window.location.href='register'">Register</button>
        <button class="lr" onClick="window.location.href='<%= request.getContextPath() %>/logout'">Logout</button>
    </div>

    <div id="home" class="hero">
        <div class="left"><img src="assets/images/png1.png" alt=""></div>
        <div class="right">
            <div class="right1 r">
                <div class="logo"> <img src="assets/images/logo1.png" alt="logo1"> </div>
                <div class="title"><b>Best Price <br> Guarantee</b></div>
                <div class="des">We Guarantee High  Quality  accommodations, <br> friendly and efficient  service,  and clean, <br> comfortable surroundings</div>
            </div>
            <div class="right2 r">
                <div class="logo2"> <img src="assets/images/logo2.png" alt="logo1"> </div>
                <div class="title"><b>Travellers <br>Loves Us</b></div>
                <div class="des">Traveling in the  company <br> of those we love  is <br> home in motion</div>
            </div>
            <div class="right3 r">
                <div class="logo3"> <img src="assets/images/logo3.png" alt="logo1"> </div>
                <div class="title"><b>Best Travel <br>Agent</b></div>
                <div class="des"> if you want the best travel agency in india then the Travel Planners are the ones for you. Highly recommendes!!!</div>
            </div>
            <div class="right4 r">
                <div class="logo4"> <img src="assets/images/logo4.png" alt="logo1"> </div>
                <div class="title"><b>Our Dedicated <br>Support</b></div>
                <div class="des">Our customer support is available  around <br> the clock to ensure that you <br> get the help you need</div>
            </div>
        </div>
        
    </div>
</body>
</html>
