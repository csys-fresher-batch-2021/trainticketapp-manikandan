package in.mani.service;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class TrainDetailsTest {

	@Test
	public void testTrainDetails() {
		HashMap<Long, HashMap<String, Integer>> trainList = TrainDetails.displayTrainDetails();
		assertEquals(3, trainList.size());
	}
}
