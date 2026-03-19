package com.studentcrud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
	  private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "delete from students where id=?");

            ps.setInt(1, id);

            ps.executeUpdate();

            response.sendRedirect("view.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}