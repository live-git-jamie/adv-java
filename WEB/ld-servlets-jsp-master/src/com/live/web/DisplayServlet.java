package com.live.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String URL = "jdbc:mysql://localhost:3306/";
	private String USER = "root";
	private String PASS = "my#1SQLroot";
	
	private final String dbName = "ezshopdb";
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<!DOCTYPE html>");
		printWriter.println("<html>");
		printWriter.println("<head>");
		printWriter.println("<title>Display List</title>");
		printWriter.println("</head>");
		printWriter.println("<body>");
		printWriter.println("<h1>uer details..</h1>");
		// create the connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(URL+dbName,USER,PASS);
			System.out.println("Connection Established!");

			// create the statement
			Statement statement = connection.createStatement();
			System.out.println("Statement created!");
			// Fetch the results by executing the query
			ResultSet resultSet = statement.executeQuery("select * from product");
			
			// Iterate the resultSet
			Product product = new Product();
			while (resultSet.next()) {
				product.setProductID(resultSet.getString(("product_id")));
				product.setProductName(resultSet.getString("product_name"));
				product.setPrice(resultSet.getFloat("price"));
				product.setQuantity(resultSet.getInt("quantity"));
		
				printWriter.println("<h4>" + product.getProductID() + "</h4>");
				printWriter.println("<h4>" + product.getProductName() + "</h4>");
				printWriter.println("<h4>" + product.getPrice() + "</h4>");
				printWriter.println("<h4>" + product.getQuantity() + "</h4>");
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		printWriter.println("</body>");
		printWriter.println("</html>");
	}
}