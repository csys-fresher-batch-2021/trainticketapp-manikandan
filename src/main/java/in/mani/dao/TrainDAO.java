package in.mani.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import in.mani.exception.DBException;
import in.mani.model.Train;
import in.mani.util.ConnectionUtil;

public class TrainDAO {

	private TrainDAO() {
		// Default Constructor
	}

	private static final TrainDAO instance = new TrainDAO();

	public static TrainDAO getInstance() {
		return instance;
	}

	public void addTrain(Train train) throws DBException {

		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into trains (trainnumber,trainname,train_source,train_destination,source_time,destination_time,class_type,fare,availability) values (?,?,?,?,?,?,?,?,?)";

			pst = connection.prepareStatement(sql);

			pst.setInt(1, train.getTrainNumber());
			pst.setString(2, train.getTrainName());
			pst.setString(3, train.getSource());
			pst.setString(4, train.getDestination());
			pst.setTime(5, train.getSourceTime());
			pst.setTime(6, train.getDestinationTime());
			pst.setString(7, train.getClassType());
			pst.setInt(8, train.getClassTypeFare());
			pst.setInt(9, train.getClassTypeAvailability());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Add train");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	public List<Train> getAllTrains() throws DBException {

		List<Train> trains = new ArrayList<>();
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement pst = null;

		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select * from trains";

			pst = connection.prepareStatement(sql);

			result = pst.executeQuery();

			while (result.next()) {
				Train train = new Train();
				int trainNumber = result.getInt("trainnumber");
				String trainName = result.getString("trainname");
				String source = result.getString("train_source");
				String destination = result.getString("train_destination");
				Time sourceTime = result.getTime("source_time");
				Time destinationTime = result.getTime("destination_time");
				String classType = result.getString("class_type");
				int fare = result.getInt("fare");
				int availability = result.getInt("availability");

				train.setTrainNumber(trainNumber);
				train.setTrainName(trainName);
				train.setSource(source);
				train.setDestination(destination);
				train.setSourceTime(sourceTime);
				train.setDestinationTime(destinationTime);
				train.setClassType(classType);
				train.setClassTypeFare(fare);
				train.setClassTypeAvailability(availability);

				trains.add(train);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Get train Details");

		} finally {
			ConnectionUtil.close(pst, connection, result);
		}
		return trains;

	}

	/**
	 * This Method will Delete the Train in DataBase
	 * 
	 * @param name
	 * @param actor
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void deleteTrain(int trainNumber, String trainName) throws DBException {

		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// Get the Connection
			connection = ConnectionUtil.getConnection();

			// SQL Command
			String sql = "delete from trains where trainnumber= ? and trainname= ? ";

			// Executing the Query
			pst = connection.prepareStatement(sql);

			pst.setInt(1, trainNumber);
			pst.setString(2, trainName);

			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Delete Train");
		} finally {
			// Closing the Connection
			ConnectionUtil.close(pst, connection);
		}
	}

	public List<Train> searchTrainByKeyword(String keyword) throws DBException {
		final List<Train> trains = new ArrayList<>();
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement pst = null;

		try {
			// Get the Connection

			connection = ConnectionUtil.getConnection();

			// Query Statement

			String sql = "select * from trains where trainname ILIKE ? or train_source ILIKE ? or train_destination ILIKE ?;";

			// Executing Query Statement

			pst = connection.prepareStatement(sql);

			pst.setString(1, "%" + keyword + "%");
			pst.setString(2, "%" + keyword + "%");
			pst.setString(3, "%" + keyword + "%");

			result = pst.executeQuery();

			while (result.next()) {

				Train train = new Train();
				int trainNumber = result.getInt("trainnumber");
				String trainName = result.getString("trainname");
				String source = result.getString("train_source");
				String destination = result.getString("train_destination");
				Time sourceTime = result.getTime("source_time");
				Time destinationTime = result.getTime("destination_time");
				String classType = result.getString("class_type");
				int fare = result.getInt("fare");
				int availability = result.getInt("availability");

				train.setTrainNumber(trainNumber);
				train.setTrainName(trainName);
				train.setSource(source);
				train.setDestination(destination);
				train.setSourceTime(sourceTime);
				train.setDestinationTime(destinationTime);
				train.setClassType(classType);
				train.setClassTypeFare(fare);
				train.setClassTypeAvailability(availability);

				trains.add(train);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Fetch Trains");
		} finally {
			// Closing the Connection
			ConnectionUtil.close(pst, connection, result);
		}
		return trains;

	}

}
