<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tour_travel.tour_management.model.TourPackage" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking Form</title>
     <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/booking.css">
</head>
<body>
    <%
        TourPackage tourPackage = (TourPackage) request.getAttribute("tourPackage");
        String bookingSuccessMessage = (String) request.getAttribute("bs");
    %>

    <h1>Booking Form for <%= tourPackage.getPackageName() %></h1>
    <form action="<%= request.getContextPath() %>/addBooking" method="post">

        <input type="hidden" name="tourPackageId" value="<%= tourPackage.getId() %>">

        <label for="customerName">Name:</label>
        <input type="text" name="customerName" required>

        <label for="customerEmail">Email:</label>
        <input type="email" name="customerEmail" required>

        <label for="numberOfPeople">Number of People:</label>
        <input type="number" name="numberOfPeople" required>

        <label for="bookingDate">Booking Date:</label>
        <input type="date" name="bookingDate" required>

        <button type="submit">Book Now</button>
    </form>

    <script>
            window.onload = function() {
                <% if (bookingSuccessMessage != null) { %>
                    alert("<%= bookingSuccessMessage %>");
                <% } %>
            };
        </script>
</body>
</html>
