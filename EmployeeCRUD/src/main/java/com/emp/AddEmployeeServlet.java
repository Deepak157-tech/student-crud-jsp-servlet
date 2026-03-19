package com.emp;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        Employee e = new Employee();
        e.setEmpName(req.getParameter("name"));
        e.setDepartment(req.getParameter("department"));
        e.setSalary(Double.parseDouble(req.getParameter("salary")));

        EmployeeDAO.insert(e);
        res.sendRedirect("listEmployee");
    }
}