<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="assets/css/admin_dashboard.css">

    <script>
            function showAlert(message) {
                alert(message);
            }
        </script>

</head>
<body>
    <div class="dashboard-container">
        <header>
            <h1>Admin Dashboard</h1>
            <button class="logout-btn home-btn" onclick="window.location.href='main'">Home</button>
            <button class="logout-btn" onclick="window.location.href='<%= request.getContextPath() %>/logout'">Logout</button>
        </header>

        <div class="content">
            <div class="card">
                <h3>Total Users</h3>
                 <p><%= request.getAttribute("totalUsers") %></p>
            </div>
            <div class="card">
                <h3>Total Bookings</h3>
                <% if(request.getAttribute("totalBookings") == null) { %>
                     <p>0</p>
                <% } else { %>
                      <p><%= request.getAttribute("totalBookings") %></p>
                <% } %>
            </div>
            <div class="card">
                <h3>Total Tours</h3>

                <% if(request.getAttribute("totalTours") == null) { %>
                        <p>0</p>
                    <% } else { %>
                         <p><%= request.getAttribute("totalTours") %></p>
                    <% } %>
            </div>
        </div>

        <div class="package-management">
            <h2>Manage Packages</h2>

            <div class="form-container">
                <form action="addPackage" method="post" enctype="multipart/form-data">
                    <h3>Add Package</h3>
                    <input type="text" name="packageName" placeholder="Package Name" required>
                    <input type="text" name="description" placeholder="Description" required>
                    <input type="number" name="days" placeholder="Days" required>
                    <input type="number" name="nights" placeholder="Nights" required>
                    <input type="number" name="price" placeholder="Price" required>
                    <input type="file" name="image" accept="image/*" required>
                    <input type="submit" value="Add Package">
                </form>

                <form action="<%= request.getContextPath() %>/updatePackage" method="post" enctype="multipart/form-data">

                    <h3>Update Package</h3>
                    <input type="number" name="packageId" placeholder="Package ID" required>
                    <input type="text" name="packageName" placeholder="New Package Name" required>
                    <input type="text" name="description" placeholder="Description" required>
                    <input type="number" name="days" placeholder="Days" required>
                     <input type="number" name="nights" placeholder="Nights" required>
                    <input type="number" name="price" placeholder="New Price" required>
                    <input type="file" name="image" accept="image/*" required>
                    <input type="submit" value="Update Package">
                </form>

                <form action="deletePackage" method="post">
                    <h3>Delete Package</h3>
                    <input type="number" name="packageId" placeholder="Package ID" required>
                    <input type="submit" value="Delete Package">
                </form>
            </div>
        </div>
    </div>

    <!-- Scriptlet to handle error or success messages -->
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            String successMessage = (String) request.getAttribute("successMessage");

            if (errorMessage != null && !errorMessage.isEmpty()) {
        %>
            <script>
                showAlert("<%= errorMessage %>");
            </script>
        <%
            }

            if (successMessage != null && !successMessage.isEmpty()) {
        %>
            <script>
                showAlert("<%= successMessage %>");
            </script>
        <%
            }
        %>

        <%
                    String em1 = (String) request.getAttribute("em1");
                    String sm1 = (String) request.getAttribute("sm1");

                    if (em1 != null && !em1.isEmpty()) {
                %>
                    <script>
                        showAlert("<%= em1 %>");
                    </script>
                <%
                    }

                    if (sm1 != null && !sm1.isEmpty()) {
                %>
                    <script>
                        showAlert("<%= sm1 %>");
                    </script>
                <%
                    }
                %>


            <%
                                String em2 = (String) request.getAttribute("em2");
                                String sm2 = (String) request.getAttribute("sm2");

                                if (em2 != null && !em2.isEmpty()) {
                            %>
                                <script>
                                    showAlert("<%= em2 %>");
                                </script>
                            <%
                                }

                                if (sm2 != null && !sm2.isEmpty()) {
                            %>
                                <script>
                                    showAlert("<%= sm2 %>");
                                </script>
                            <%
                                }
                            %>
</body>
</html>
