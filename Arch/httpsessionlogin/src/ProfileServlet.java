import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		final PrintWriter out = response.getWriter();
		final HttpSession session = request.getSession(false);
		
		response.setContentType("text/html");
		request.getRequestDispatcher("link.html").include(request, response);
		
		if (session != null) {
			out.print("Hello, " + (String) session.getAttribute("name") + " Welcome to Profile");
		} else {
			out.print("Please login first");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}
}
