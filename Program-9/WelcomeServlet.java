package com.example;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve existing session
        HttpSession session = request.getSession(false);
        
        // Redirect to login page if no session exists or if the session is invalid
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("index.html");
            return;
        }

        // Retrieve username and loginTime from the session
        String username = (String) session.getAttribute("username");
        Date loginTime = (Date) session.getAttribute("loginTime"); // Correctly cast to Date
        String startTime = new SimpleDateFormat("hh:mm:ss a").format(loginTime);

        // Generate HTML response
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Welcome, " + username + "</h2>");
        response.getWriter().println("<div style='position: absolute; top: 10px; right: 10px;'>Start Time: " + startTime + "</div>");
        response.getWriter().println("<form action='logout' method='post'>");
        response.getWriter().println("<button type='submit'>Logout</button>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }
}
