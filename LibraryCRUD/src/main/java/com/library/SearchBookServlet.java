package com.library;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SearchBookServlet")
public class SearchBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String title = req.getParameter("title");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM books WHERE title LIKE ?"
            );

            ps.setString(1, "%" + title + "%");

            ResultSet rs = ps.executeQuery();

            req.setAttribute("result", rs);
            RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
            rd.forward(req, res);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}