package com.emp;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/listEmployee")
public class ListEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // 🔥 FETCH DATA FROM DAO
        req.setAttribute("list", EmployeeDAO.getAll());

        // 🔥 DEBUG (optional)
        System.out.println(EmployeeDAO.getAll());

        // 🔥 FORWARD TO JSP
        RequestDispatcher rd = req.getRequestDispatcher("view.jsp");
        rd.forward(req, res);
    }
}