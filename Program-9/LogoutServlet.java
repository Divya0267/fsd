package com.example;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve existing session
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            // Retrieve username and loginTime from session
            String username = (String) session.getAttribute("username");
            Date loginTime = (Date) session.getAttribute("loginTime"); // Correctly cast to Date
            
            // Calculate session duration in seconds
            long duration = (System.currentTimeMillis() - loginTime.getTime()) / 1000;
            
            // Invalidate the session
            session.invalidate();
            
            // Generate HTML response
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h2>Thank You, " + username + "!</h2>");
            response.getWriter().println("<p>You used the application for " + duration + " seconds.</p>");
            response.getWriter().println("<a href='index.html'>Login Again</a>");
            response.getWriter().println("</body></html>");
        } else {
            // Redirect to login page if no session exists
            response.sendRedirect("index.html");
        }
    }
}
