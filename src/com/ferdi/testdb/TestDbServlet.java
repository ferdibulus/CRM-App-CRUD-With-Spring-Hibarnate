package com.ferdi.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setuo connection variables
		String user = "hbstudent";
		String password = "hbstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3307/web_customer_tracker?useSSL=false";
		
		String driver = "com.mysql.jdbc.Driver";
				
		// get connection to database
		
		try {
			PrintWriter p = response.getWriter();
			p.println("Connection to database " + jdbcUrl);
			Class.forName(driver);
			Connection con = DriverManager.getConnection(jdbcUrl,user,password);
			p.println("Succesful!!");
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
