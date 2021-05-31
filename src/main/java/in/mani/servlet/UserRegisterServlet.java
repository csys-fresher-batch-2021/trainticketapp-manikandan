package in.mani.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.mani.dto.UserDTO;
import in.mani.service.UserRegisterService;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserRegisterServlet() {
        super();
    }
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String userName=request.getParameter("userName");
		String newPassword=request.getParameter("newPassword");
		String confirmPassword=request.getParameter("confirmPassword");
		try {
			Long mobileNumber=Long.parseLong(request.getParameter("mobileNumber"));
			UserDTO userDTO=UserDTO.getInstance();
			userDTO.setFirstName(firstName);
			userDTO.setLastName(lastName);
			userDTO.setEmail(email);
			userDTO.setMobileNumber(mobileNumber);
			userDTO.setUserName(userName);
			userDTO.setNewpassword(newPassword);
			UserRegisterService.registerUser(userDTO,confirmPassword);
			String infoMessage="Successfully Registered User";
			response.sendRedirect("registerUser.jsp?infoMessage=" + infoMessage);
		}catch(Exception e) {
			e.printStackTrace();
			String errorMessage=e.getMessage();
			response.sendRedirect("registerUser.jsp?errorMessage=" + errorMessage);
		}
	}

}
