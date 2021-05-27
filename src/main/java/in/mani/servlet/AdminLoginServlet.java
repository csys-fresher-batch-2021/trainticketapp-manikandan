package in.mani.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.mani.validation.AdminLoginValidator;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String adminId = request.getParameter("adminId");
		String password = request.getParameter("password");
		try {
			AdminLoginValidator.validateAdminLogin(adminId, password);
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_ADMIN", adminId);
			session.setAttribute("ROLE", "ADMIN");
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage=e.getMessage();
			response.sendRedirect("adminLogin.jsp?errorMessage=" + errorMessage);
		}
	}

}
