package com.insertUser;

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
 * Servlet implementation class UserServlet
 */
@WebServlet("/create")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String location = request.getParameter("location");
		String email = request.getParameter("email");
		DatabaseConnection database = new DatabaseConnection();
		
		try (Connection con = database.getConnection();PreparedStatement ps = con.prepareStatement("INSERT INTO users (name, password, location, email) VALUES (?, ?, ?, ?)");)
		{
			ps.setString(1, name);
			ps.setString(2, pass);
			ps.setString(3, location);
			ps.setString(4, email);			
			ps.executeUpdate();
			response.sendRedirect("index.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
