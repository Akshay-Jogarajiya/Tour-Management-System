<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Booking Results</title>
    <link rel="stylesheet" href="assets/css/style.css"> <!-- Link your CSS -->
</head>
<body>
    <h2>Your Bookings</h2>
    <%
        // Retrieve the list of bookings from the request attributes
        List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");

        // Check if bookings is not null and not empty
        if (bookings != null && !bookings.isEmpty()) {
    %>
        <ul>
        <%
            // Iterate through the bookings and display them
            for (Booking booking : bookings) {
        %>
            <li>Package: <%= booking.getPackageName() %>, Date: <%= booking.getBookingDate() %>, Email: <%= booking.getEmail() %></li>
        <%
            } // End of the for loop
        %>
        </ul>
    <%
        } else {
    %>
        <p>No bookings found for this email.</p>
    <%
        } // End of the if statement
    %>
</body>
</html>
