package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final PrintWriter printWriter = response.getWriter();
		final String name = request.getParameter("name");
		final String password = request.getParameter("password");
		
		response.setContentType("text/html");
		request.getRequestDispatcher("link.html").include(request, response);		

		if ("admin123".equals(password)) {
			printWriter.print("You are successfully logged in!");
			printWriter.print("<br>Welcome, " + name);			
			response.addCookie(new Cookie("name", name));
		} else {
			printWriter.print("sorry, username or password error!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		printWriter.close();
	}

}
