package in.mani.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.mani.validation.UserLoginValidator;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserLoginServlet() {
        super();
    }
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		try {
			// validating UserName and Password
			UserLoginValidator.isValidLogin(userName, password);
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", userName);
			String infoMessage = "Successfully Logged In";
			// Redirecting to Home Page
			response.sendRedirect("index.jsp?infoMessage=" + infoMessage);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			// Printing Error Message
			response.sendRedirect("userLogin.jsp?errorMessage=" + errorMessage);
		}
	}

}
