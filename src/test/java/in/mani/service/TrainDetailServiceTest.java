package in.mani.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrainDetailServiceTest {

	@Test
	public void testWithValidTrainName() {
		try {
			TrainDetailSevices.searchTrainByKeyword("TEJAS");
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testWithInValidTrainName() {

		try {
			TrainDetailSevices.searchTrainByKeyword("POTHIGAI");
			fail();
		} catch (Exception e) {
			assertEquals("NO Matching Train Found", e.getMessage());
		}

	}

	@Test
	public void testWithValidSource() {
		try {
			TrainDetailSevices.searchTrainByKeyword("MADURAI");
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testWithInValidSource() {

		try {
			TrainDetailSevices.searchTrainByKeyword("SIVAKASI");
			fail();
		} catch (Exception e) {
			assertEquals("NO Matching Train Found", e.getMessage());
		}

	}

	@Test
	public void testWithValidDestination() {
		try {
			TrainDetailSevices.searchTrainByKeyword("CHENNAI");
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testWithInValidDestination() {

		try {
			TrainDetailSevices.searchTrainByKeyword("SIVAKASI");
			fail();
		} catch (Exception e) {
			assertEquals("NO Matching Train Found", e.getMessage());
		}

	}

}
