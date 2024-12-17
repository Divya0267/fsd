package com.example;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Retrieve username from the form
        String username = request.getParameter("username");

        if (username == null || username.trim().isEmpty()) {
            // If username is not provided, return to login with an error message
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("error", "Username cannot be empty!");
            return modelAndView;
        }

        // Pass the username to the welcome page
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("username", username);
        return modelAndView;
    }
}
