package com.emp;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        int id=Integer.parseInt(req.getParameter("id"));
        EmployeeDAO.delete(id);
        res.sendRedirect("listEmployee");
    }
}