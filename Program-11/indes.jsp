<%@ page import="java.sql.SQLException, java.sql.DriverManager, java.sql.ResultSet, java.sql.PreparedStatement, java.sql.Connection" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Login</title>
</head>
<body>
    <h2>User Login</h2>

    <form action="index.jsp" method="POST">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Login">
    </form>

    <%
        // Only process if form is submitted via POST
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username != null && password != null) {
                // Database connection setup
                String dbUrl = "jdbc:mysql://localhost:3306/userdb";
                String dbUser = "root";
                String dbPassword = "password"; // Update with your MySQL password

                Connection conn = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;

                try {
                    // Load the database driver (MySQL)
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // Establish connection
                    conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

                    // Query to validate user credentials
                    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, username);
                    stmt.setString(2, password);

                    rs = stmt.executeQuery();

                    if (rs.next()) {
                        // Successful login, redirect to success page
                        response.sendRedirect("success.jsp");
                    } else {
                        // Invalid credentials, show error message
                        out.println("<h3>Invalid username or password. Please try again.</h3>");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<h3>Error connecting to the database. Please try again later.</h3>");
                } finally {
                    try {
                        if (rs != null) rs.close();
                        if (stmt != null) stmt.close();
                        if (conn != null) conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    %>
</body>
</html>
