package in.mani.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import in.mani.exception.ServiceException;
import in.mani.service.FareEstimationService;

/**
 * Servlet implementation class GetFareServlet
 */
@WebServlet("/GetFareServlet")
public class GetFareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetFareServlet() {
        super();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
		try {
			Integer numberOfTickets = Integer.parseInt(request.getParameter("tickets"));
			Integer trainNumber = Integer.parseInt(request.getParameter("trainNumber"));
			int totalPrice = FareEstimationService.getPrice(trainNumber , numberOfTickets);
			Gson gson = new Gson();
			String json = gson.toJson(totalPrice);
			PrintWriter writer = response.getWriter();
			writer.print(json);
			writer.flush();
		} catch (ServiceException e) {
			JsonObject object = new JsonObject();
			object.addProperty("errorMessage", e.getMessage());
			out.println(object);
		}
		out.flush();
		
	}


}
