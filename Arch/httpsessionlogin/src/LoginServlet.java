import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		final PrintWriter printWritter = response.getWriter();
		final String name = request.getParameter("name");
		final String password = request.getParameter("password");
		final LoginDao loginDao = new LoginDao();
		
		response.setContentType("text/html");
		request.getRequestDispatcher("link.html").include(request, response);
		System.out.println(loginDao.validate(name, password));

		if (loginDao.validate(name, password)) {			
			final HttpSession session = request.getSession();
			
			session.setAttribute("name", name);
			session.setMaxInactiveInterval(10);
			printWritter.print("Welcome, " + name);			
		} else {
			printWritter.print("Sorry, username or password error!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		printWritter.close();
	}

}
