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

/**
 * Servlet implementation class SearchTrainServlet
 */
@WebServlet("/SearchTrainServlet")
public class SearchTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchTrainServlet() {
        super();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		try {
			List<TrainDTO> trains = TrainDetailSevices.searchTrainByKeyword(keyword);
			request.setAttribute("TRAIN_LIST", trains);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("searchTrain.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage=e.getMessage();
			response.sendRedirect("searchTrain.jsp?errorMessage=" + errorMessage);
		}
		
	}


}
