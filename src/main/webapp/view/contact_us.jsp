<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us</title>
    <link rel="stylesheet" href="assets/css/contact_us.css">
</head>
<body>
     <jsp:include page="header.jsp" />
    
    <div class="container">
         <% if (request.getParameter("success") != null) { %>
                    <div class="success-message">
                        Your message has been sent successfully!
                    </div>
                <% } %>

        <form action="<%= request.getContextPath() %>/send-message" method="post" class="contact-form">
            <label for="name">Full Name:</label>
            <input type="text" id="name" name="name" required minlength="3" maxlength="50">

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="subject">Subject:</label>
            <input type="text" id="subject" name="subject" required>

            <label for="message">Message:</label>
            <textarea id="message" name="message" rows="5" required></textarea>

            <input type="submit" value="Send Message">
        </form>
    </div>

     <jsp:include page="footer.jsp" />
</body>
</html>
