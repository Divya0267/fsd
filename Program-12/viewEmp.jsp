<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Employees</title>
        
    </head>
    <body>
        <h1>List of Employees</h1>
        <table border="2" width="70%" cellpadding="2">
            <tr>
                <th>Employee Id</th>
                <th>Employee Name</th>
                <th>Department Number</th>
                <th>Branch</th>
            </tr>
            <c:forEach var="emp" items="${empList}">
                <tr>
                    <td>${emp.empId}</td>
                    <td>${emp.name}</td>
                    <td>${emp.deptNo}</td>
                    <td>${emp.branch}</td>
                </tr>
            </c:forEach>
        </table>
        <br/>

        <!-- Debug information as hidden content (optional) -->
       
    </body>
</html>
