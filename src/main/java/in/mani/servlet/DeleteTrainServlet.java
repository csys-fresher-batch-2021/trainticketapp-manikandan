package in.mani.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.mani.service.TrainDetailSevices;

/**
 * Servlet implementation class DeleteTrainServlet
 */
@WebServlet("/DeleteTrainServlet")
public class DeleteTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteTrainServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String trainName = request.getParameter("trainName");
		try {
			int trainNumber = Integer.parseInt(request.getParameter("trainNumber"));
			TrainDetailSevices.deleteTrain(trainNumber, trainName);
			String infoMessage = "Successfully Deleted Train";
			response.sendRedirect("trainList.jsp?infoMessage=" + infoMessage);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			response.sendRedirect("trainList.jsp?errorMessage=" + errorMessage);
		}
	}
}
