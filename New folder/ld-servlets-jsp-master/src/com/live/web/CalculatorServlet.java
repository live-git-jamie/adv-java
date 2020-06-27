package com.live.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String number1 = req.getParameter("number1");
		String number2 = req.getParameter("number2");
		int num1 = Integer.parseInt(number1);
		int num2 = Integer.parseInt(number2);
		
		double total = 0;
		
		String op = req.getParameter("option");
		System.out.println(op);
//		switch(op) {
//		case "+":
//			total = num1 + num2;
//			break;
//		case "-":
//			total = num1 - num2;
//			break;
//		case "*":
//			total = num1 * num2;
//			break;
//		case "/":
//			total = num1 / num2;
//			break;
//		}
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("The total is: " + total);
	}
	
}
