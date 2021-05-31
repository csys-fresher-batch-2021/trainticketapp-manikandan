package in.mani.service;

import java.util.List;

import in.mani.converter.TrainConverter;
import in.mani.dao.TrainDAO;
import in.mani.dto.TrainDTO;
import in.mani.exception.DBException;
import in.mani.exception.ServiceException;
import in.mani.model.Train;
import in.mani.util.NameValidation;
import in.mani.validation.TrainNumberValidator;
import in.mani.validation.TrainValidator;

public class TrainDetailSevices {

	private TrainDetailSevices() {
		// Default Constructor
	}

	/**
	 * This Method is used to add Trains
	 * 
	 * @param trainDTO
	 */
	public static void addTrain(TrainDTO trainDTO) {
		try {
			TrainValidator.isValidTrainDetails(trainDTO);

			Train train = TrainConverter.toTrain(trainDTO);
			TrainDAO trainDAO = TrainDAO.getInstance();
			trainDAO.addTrain(train);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * This Method is Used to fetch All Trains
	 * 
	 * @return
	 */
	public static List<TrainDTO> getTrains() {
		TrainDAO trainDAO = TrainDAO.getInstance();
		List<Train> allTrains = trainDAO.getAllTrains();
		return TrainConverter.toTrainDTO(allTrains);
	}

	public static void deleteTrain(int trainNumber, String trainName) {
		try {
			TrainNumberValidator.isValidtrainNumber(trainNumber);
			NameValidation.isValidName(trainName);
			TrainDAO trainDAO = TrainDAO.getInstance();
			trainDAO.deleteTrain(trainNumber, trainName);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public static List<TrainDTO> searchTrainByKeyword(String keyword) {

		List<Train> trains = null;

		try {
			NameValidation.isValidName(keyword);
			TrainDAO trainDAO = TrainDAO.getInstance();
			trains = trainDAO.searchTrainByKeyword(keyword);
			TrainValidator.isTrainExists(trains);

		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}

		return TrainConverter.toTrainDTO(trains);
	}

	public static List<TrainDTO> searchTrainByPlaces(String source, String destination) {
		List<Train> trains = null;

		try {
			NameValidation.isValidName(destination);
			NameValidation.isValidName(source);
			TrainDAO trainDAO = TrainDAO.getInstance();
			trains = trainDAO.searchTrainByPlaces(source, destination);
			TrainValidator.isTrainExistsToBook(trains);

		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}

		return TrainConverter.toTrainDTO(trains);
	}
}
