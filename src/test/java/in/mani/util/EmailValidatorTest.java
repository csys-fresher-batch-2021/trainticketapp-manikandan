package in.mani.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmailValidatorTest {

	@Test
	public void testwithValidEmail() {

		try {
			EmailValidation.isValidEmail("smani06022000@gmail.com");
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	/**
	 * In this test case Email Id is Entered as Empty String
	 */
	@Test
	public void testwithEmailAsEmptyString() {
		try {
			EmailValidation.isValidEmail("");
			fail();
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals("Email Field should not be empty", e.getMessage());
		}
	}

}
