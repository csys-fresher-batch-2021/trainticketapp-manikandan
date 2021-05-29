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
 * Servlet implementation class SearchTrainToBookServlet
 */
@WebServlet("/SearchTrainToBookServlet")
public class SearchTrainToBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchTrainToBookServlet() {
        super();
    }
    
    @Override
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String source = request.getParameter("source");
   		String destination = request.getParameter("destination");
   		try {
   			List<TrainDTO> trains = TrainDetailSevices.searchTrainByPlaces(source,destination);
   			request.setAttribute("TRAIN_LIST", trains);
   			RequestDispatcher requestDispatcher = request.getRequestDispatcher("trainlist.jsp");
   			requestDispatcher.forward(request, response);
   		} catch (Exception e) {
   			e.printStackTrace();
   			String errorMessage=e.getMessage();
   			response.sendRedirect("index.jsp?errorMessage=" + errorMessage);
   		}
   		
   	}
    
    

}
