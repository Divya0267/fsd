<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ page import="Bean.FactorialBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Factorial Calculation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
</head>
<body>
    <div class="container">
        <h2>Factorial Calculation</h2>

        <!-- UseBean to instantiate the FactorialBean -->
        <jsp:useBean id="factorialBean" class="Bean.FactorialBean" scope="page" />

        <!-- Manually parse the number parameter and set it in the FactorialBean -->
        <%
            String numStr = request.getParameter("number");
            if (numStr != null && !numStr.isEmpty()) {
                try {
                    long number = Long.parseLong(numStr);
                    factorialBean.setNumber(number);
                } catch (NumberFormatException e) {
                    out.println("<p class='error'>Invalid number format. Please enter a valid number.</p>");
                }
            }
        %>

        <!-- Display the factorial result -->
        <%
            if (numStr != null && !numStr.isEmpty()) {
                long factorial = factorialBean.getNumber();
                out.println("<p class='result'>The factorial of " + numStr + " is: " + factorial + "</p>");
            }
        %>

    </div>
</body>
</html>
