/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

/**
 *
 * @author Deekshitha
 */
import com.beans.EmpDao;
import com.beans.Employee;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author ADMIN
 */
public class ViewController extends AbstractController {
    
    public ViewController() {
    }
    
  @Override
protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    EmpDao empDao = new EmpDao();
    List<Employee> empList = empDao.getEmployeeList();
    
    // Collect debug messages
    StringBuilder debugLogs = new StringBuilder();
    
    for (Employee emp : empList) {
        debugLogs.append(emp.toString()).append("\n");
    }
    
    // Add debug logs and employee list to the ModelAndView
    ModelAndView mav = new ModelAndView();
    mav.addObject("empList", empList);
    mav.addObject("debugLogs", debugLogs.toString());
    mav.setViewName("viewEmp");
    return mav;
}

    
}
