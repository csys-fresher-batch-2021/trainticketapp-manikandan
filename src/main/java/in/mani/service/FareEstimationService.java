package in.mani.service;

import java.util.List;

import in.mani.dao.TrainDAO;
import in.mani.exception.ServiceException;
import in.mani.model.Train;
import in.mani.util.NumberValidator;

public class FareEstimationService {
	
	private FareEstimationService() {
		
	}
	/**
	 * This Method is get Fare Amount
	 * @param trainNumber
	 * @param noOfTickets
	 * @return
	 */
	public static int getPrice(int trainNumber, int noOfTickets) {

		int totalPrice = 0;
		try {
			NumberValidator.isValidNumber(trainNumber);
			NumberValidator.isValidNumber(noOfTickets);
			TrainDAO trainDAO = TrainDAO.getInstance();
			List<Train> trains = trainDAO.getAllTrains();
			int price = 0;
			for (Train train : trains) {
				if (trainNumber == train.getTrainNumber()) {
					price = train.getClassTypeFare();
					int baseFare = price * noOfTickets;
					int conveniencePrice = 11;
					totalPrice = (baseFare + conveniencePrice);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return totalPrice;

	}

}
