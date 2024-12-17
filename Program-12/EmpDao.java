package com.beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpDao {

    private Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb?useSSL=false&serverTimezone=UTC", "root", "password");

            
        } catch (Exception ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, "Failed to connect to database", ex);
        }
        return con;
    }

    public List<Employee> getEmployeeList() {
        List<Employee> empList = new ArrayList<>();
        Connection con = getConnection();
        if (con == null) {
            System.out.println("Connection is null. Cannot fetch data!");
            return empList; // Return empty list if connection fails
        }
        try (Statement st = con.createStatement(); 
             ResultSet rs = st.executeQuery("SELECT * FROM employee")) {
            
            while (rs.next()) {
                Employee e = new Employee();
                e.setEmpId(rs.getInt("empId"));
                e.setName(rs.getString("name"));
                e.setDeptNo(rs.getInt("deptNo"));
                e.setBranch(rs.getString("branch"));
                empList.add(e);
                System.out.println("Fetched Employee: " + e); // Debug log for each employee
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return empList;
    }
}
