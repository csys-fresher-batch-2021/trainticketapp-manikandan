
package in.mani.servlet;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.mani.dto.TrainDTO;
import in.mani.service.TrainDetailSevices;

/**
 * Servlet implementation class AddTrainServlet
 */

@WebServlet("/AddTrainServlet")
public class AddTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String trainName = request.getParameter("trainName");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String classType = request.getParameter("classType");
		try {
			int trainNumber = Integer.parseInt(request.getParameter("trainNumber"));
			LocalTime sourceTime = LocalTime.parse(request.getParameter("sourcetime"));
			Time sourcetime = Time.valueOf(sourceTime);
			LocalTime destinationTime = LocalTime.parse(request.getParameter("destinationtime"));
			Time destinationtime = Time.valueOf(destinationTime);
			int classTypeFare = Integer.parseInt(request.getParameter("classTypeFare"));
			int classTypeAvailability = Integer.parseInt(request.getParameter("classTypeAvailability"));
			TrainDTO trainDTO=TrainDTO.getInstance();
			trainDTO.setTrainNumber(trainNumber);
			trainDTO.setTrainName(trainName);
			trainDTO.setSource(source);
			trainDTO.setDestination(destination);
			trainDTO.setSourceTime(sourcetime);
			trainDTO.setDestinationTime(destinationtime);
			trainDTO.setClassType(classType);
			trainDTO.setClassTypeFare(classTypeFare);
			trainDTO.setClassTypeAvailability(classTypeAvailability);
			TrainDetailSevices.addTrain(trainDTO);
			String infoMessage="Successfully added Train Details";
			response.sendRedirect("addTrains.jsp?infoMessage=" + infoMessage);
		}
		catch(Exception e){
			String errorMessage=e.getMessage();
			e.printStackTrace();
			response.sendRedirect("addTrains.jsp?errorMessage=" + errorMessage);
		}
	}

}
