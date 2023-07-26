package com.edit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DatabaseConnection;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseConnection connect = new DatabaseConnection();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String loca = request.getParameter("location");
		String email = request.getParameter("email");
		try(Connection con = connect.getConnection(); PreparedStatement ps = con.prepareStatement("UPDATE users SET name=?, password=?, location=?, email=? WHERE id=?")) {
			ps.setString(1, name);
			ps.setString(2, pass);
			ps.setString(3, loca);
			ps.setString(4, email);
			ps.setInt(5, id);
			ps.executeUpdate();
			response.sendRedirect("index.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
