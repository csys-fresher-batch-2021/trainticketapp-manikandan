package in.mani.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.mani.dto.TrainDTO;
import in.mani.service.TrainDetailSevices;

@WebServlet("/TrainDetailServlet")
public class TrainDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TrainDetailServlet() {
		super();
	}

	/**
	 * This Servlet is used to diplay Train Details
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<TrainDTO> trains = TrainDetailSevices.getTrains();
		request.setAttribute("TRAIN_LIST", trains);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("trainList.jsp");
		requestDispatcher.forward(request, response);
	}

}
