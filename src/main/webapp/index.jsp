<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.database.DatabaseConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div {
		width: 60%;
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;
		margin: auto;
	}
	div form {
		margin-bottom: 20px;
	}
	div table {
		width: 100%;
		background-color: red;
	}
	thead tr {
		background-color: grey;
	}
	tbody tr {
		background-color: lightgrey;
	}
	th {
		color: white;
	}
</style>
</head>
<body>
<div>
<%
	DatabaseConnection connect = new DatabaseConnection();
	String eid = request.getParameter("id");
	if(eid != null) {
		out.print("<form action='edit' method='post'>");
		try (Connection con = connect.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id=?");){
			int userId = Integer.parseInt(eid);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				out.print("<input type='text' name='id' value='"+rs.getInt("id")+"' hidden>");
				out.print("<input type='text' name='name' value='"+rs.getString("name")+"' required>");
				out.print("<input type='password' name='pass' value='"+rs.getString("password")+"' required>");
				out.print("<input type='text' name='location' value='"+rs.getString("location")+"' required>");
				out.print("<input type='email' name='email' value='"+rs.getString("email")+"' required>");
				out.print("<input type='submit' value='edit'>");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	} else {
		out.print("<form action='create' method='post'>");
%>
		
		<input type="text" name="name" required>
		<input type="password" name="pass" required>
		<input type="text" name="location" required>
		<input type="email" name="email" required>
		<input type="submit" value="submit">
<%      
	}
%>

	</form>
	<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Password</th>
			<th>Location</th>
			<th>Email</th>
		</tr>
	</thead>
	<tbody>
	<%
		try(Connection con = connect.getConnection();PreparedStatement ps = con.prepareStatement("SELECT * FROM users")) {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String pass = rs.getString("password");
				String location = rs.getString("location");
				String email = rs.getString("email");
				
				out.print("<tr>");
				out.print("<td>"+id+"</td>");	
				out.print("<td>"+name+"</td>");	
				out.print("<td>"+pass+"</td>");	
				out.print("<td>"+location+"</td>");
				out.print("<td>"+email+"</td>");
				out.print("<td><a href='index.jsp?id="+id+"'>edit</a></td>");
				out.print("<td><a href='delete?id="+id+"'>delete</a></td>");
				out.print("</tr>");
				
			}
		}
	
	%>
	</tbody>
	</table>
</div>
	<img alt="images/border1.png" src="images/border1.png">
</body>
</html>