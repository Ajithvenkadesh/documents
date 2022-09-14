package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		final PrintWriter out = response.getWriter();
		final Cookie cookie = new Cookie("name", "");
		
		response.setContentType("text/html");
		request.getRequestDispatcher("link.html").include(request, response);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		out.print("you are successfully logged out!");
	}
}
