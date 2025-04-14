<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tour_travel.tour_management.model.TourPackage" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Tours Packages</title>
    <link rel="stylesheet" href="assets/css/tour.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
         <%
              String err = (String) request.getAttribute("err");
         %>
    <jsp:include page="header.jsp" />

    <h1>Available Tour Packages</h1>
    <%
        List<TourPackage> pack = (List<TourPackage>) request.getAttribute("pack");
        if (pack != null && !pack.isEmpty()) {
    %>
            <div class="container">
                <%
                    for (TourPackage pa : pack) {
                %>
                <div class="tour-package p1">
                    <%--
                        if (pa.getPhotoPath() != null && !pa.getPhotoPath().isEmpty()) {
                    %>
                        <img src="<%= request.getContextPath() + "/" + pa.getPhotoPath() %>" alt="<%= pa.getPackageName() %>">
                    <%
                        }
                    --%>
                    <h2><%= pa.getPackageName() %></h2>
                    <p><%= pa.getDescription() %></p>
                    <span class="price">Duration : <%= pa.getDays() %> Days + <%= pa.getNights() %> Nights</span> <br>
                    <span class="price">Price : <i class="fa-solid fa-indian-rupee-sign"></i> <%= pa.getPrice() %> only</span> <br>
                    <a href="<%= request.getContextPath() %>/booking/bookTour?tourId=<%= pa.getId() %>" class="btn">Book Now</a>
                </div>

                <%
                    } // End of for loop
                %>
            </div>
    <%
        } else {
    %>
            <p class="no-tour">No tour packages available at the moment.</p>
    <%
        } // End of if condition
    %>
    <jsp:include page="footer.jsp" />

    <script>
                window.onload = function() {
                    <% if (err != null) { %>
                        alert("<%= err %>");
                    <% } %>
                };
            </script>
</body>
</html>
