<%-- 
    Document   : login
    Created on : Dec 4, 2024, 9:37:02 PM
    Author     : Deekshitha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h2>Login Page</h2>
        <form action="welcome.htm" method="POST">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username"><br><br><!-- comment -->
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"><br><br><!-- comment -->
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
