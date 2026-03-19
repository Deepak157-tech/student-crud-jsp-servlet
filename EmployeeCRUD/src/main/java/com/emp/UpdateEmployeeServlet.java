package com.emp;

import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@jakarta.servlet.annotation.WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        Employee e = new Employee();

        e.setEmpId(Integer.parseInt(req.getParameter("id")));
        e.setEmpName(req.getParameter("name"));
        e.setDepartment(req.getParameter("department"));
        e.setSalary(Double.parseDouble(req.getParameter("salary")));

        EmployeeDAO.update(e);

        res.sendRedirect("listEmployee");
    }
}