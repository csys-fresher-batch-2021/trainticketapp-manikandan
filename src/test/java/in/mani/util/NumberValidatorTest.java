package in.mani.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberValidatorTest {

	@Test
	public void testWithValidNumber() {
		try {
			NumberValidator.isValidNumber(95);
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testwithInValidNumber() {

		try {
			NumberValidator.isValidNumber(-95);
			fail();
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals("Number should not be Negative", e.getMessage());
		}
	}

}
