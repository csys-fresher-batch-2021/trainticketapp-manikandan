package in.mani.service;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class TrainDetailServiceTest {

	@Test
	public void testTrainDetails() {
		Map<Integer,String> trainList = TrainDetailSevices.getAllTrainList();
		assertEquals(3, trainList.size());
	}

}
