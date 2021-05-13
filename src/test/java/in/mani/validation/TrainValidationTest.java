package in.mani.validation;

import static org.junit.Assert.*;

import org.junit.Test;

import in.mani.service.TrainDetailSevices;

public class TrainValidationTest {

	/**
	 * This test case is for valid Train Details
	 */
	@Test
	public void testValidTrainDetails() {
		try {
			TrainDetailSevices.addTrains(12623, "Madurai Express");
			assertTrue(true);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail();
		}

	}

	/**
	 * This test case is for Exists Train Name
	 */
	@Test
	public void testExistsTrainName() {
		try {
			TrainDetailSevices.addTrains(23416, "tejasexpress");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Train Name already Exists", e.getMessage());
		}
	}

	/**
	 * This test case is for Exists Train Number
	 */
	@Test
	public void testExitsTrainNumber() {
		try {
			TrainDetailSevices.addTrains(12613, "Vaigai Express");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Train Number already Exists", e.getMessage());
		}
	}

	/**
	 * This test case is for Exists Train Name
	 */
	@Test
	public void testWhiteSpace() {
		try {
			TrainDetailSevices.addTrains(23916, "       ");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid Train Name", e.getMessage());
		}
	}
}
