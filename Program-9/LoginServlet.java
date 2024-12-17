package com.example;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private String validUsername;
    private String validPassword;

    @Override
    public void init(ServletConfig config) throws ServletException {
        validUsername = config.getInitParameter("username");
        validPassword = config.getInitParameter("password");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals(validUsername) && password.equals(validPassword)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("loginTime", new Date());
            response.sendRedirect("welcome");
        } else {
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h3>Invalid username or password.</h3>");
            response.getWriter().println("<a href='index.html'>Try Again</a>");
            response.getWriter().println("</body></html>");
        }
    }
}
