package com.library;

import java.io.IOException;
import java.sql.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String category = req.getParameter("category");
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO books(title, author, category, quantity) VALUES(?,?,?,?)"
            );

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, category);
            ps.setInt(4, quantity);

            ps.executeUpdate();

            res.sendRedirect("viewBooks.jsp");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}