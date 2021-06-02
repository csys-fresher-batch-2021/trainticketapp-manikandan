package in.mani.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class FareEstimationServiceTest {

	@Test
	public void testWithValidTrainNumber() {
		try {
			int actual = FareEstimationService.getPrice(21653, 2);
			assertEquals(2491,actual);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testWithNegativeNumber() {

		try {
			int actual = FareEstimationService.getPrice(21653, -2);
			assertEquals(1251,actual);
			fail();
		} catch (Exception e) {
			assertEquals("Number should not be Negative", e.getMessage());
		}

	}
	

}
