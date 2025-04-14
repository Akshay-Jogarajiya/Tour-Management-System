<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tour_travel.tour_management.model.Booking" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Bookings</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
    <h2>Your Bookings</h2>
    <%
        List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");

        if (bookings != null && !bookings.isEmpty()) {
    %>
        <ul>
        <%
            for (Booking booking : bookings) {
        %>
            <li>Package: <%= booking.getTourPackage().getPackageName() %>, Date: <%= booking.getBookingDate() %>, Email: <%= booking.getCustomerEmail() %></li>
        <%
            }
        %>
        </ul>
    <%
        } else {
    %>
        <p>No bookings found for this email.</p>
    <%
        }
    %>
</body>
</html>
