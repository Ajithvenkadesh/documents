import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		final PrintWriter printWriter = response.getWriter();
		final HttpSession session = request.getSession();
		
		response.setContentType("text/html");
		request.getRequestDispatcher("link.html").include(request, response);
		session.invalidate();
		printWriter.print("You are successfully logged out!");
		printWriter.close();
	}
}
