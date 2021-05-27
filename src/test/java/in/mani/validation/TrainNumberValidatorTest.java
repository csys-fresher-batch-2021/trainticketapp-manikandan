package in.mani.validation;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrainNumberValidatorTest {

	@Test
	public void testWithValidTrainNumber() {
		try {
			TrainNumberValidator.isValidtrainNumber(21653);
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testWithInvalidTrainNumber() {
		try {
			TrainNumberValidator.isValidtrainNumber(2165);
			fail();
		} catch (RuntimeException e) {
			e.printStackTrace();
			assertEquals("Invalid Train Number", e.getMessage());
		}
	}
}
