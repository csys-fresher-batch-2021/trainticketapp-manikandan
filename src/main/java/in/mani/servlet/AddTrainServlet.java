
package in.mani.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.mani.service.TrainDetailSevices;

/**
 * Servlet implementation class AddTrainServlet
 */

@WebServlet("/AddTrainServlet")
public class AddTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String trainName = request.getParameter("trainName");
		try {
			int trainNumber = Integer.parseInt(request.getParameter("trainNumber"));
			TrainDetailSevices.addTrains(trainNumber, trainName);
			String infoMessage="Successfully added Train Details";
			response.sendRedirect("addTrains.jsp?infoMessage=" + infoMessage);
		}
		catch(Exception e){
			String errorMessage=e.getMessage();
			response.sendRedirect("addTrains.jsp?errorMessage=" + errorMessage);
		}
	}

}
