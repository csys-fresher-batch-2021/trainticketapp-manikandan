package in.mani.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class MobileNumberValidatorTest {

	/**
	 * In this test Case Valid Mobile Number is Entered
	 */
	@Test
	public void testwithValidMobileNumber() {

		try {
			MobileNumberValidation.isValidMobileNumber(9514915914L);
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * In this test Case InValid Mobile Number is Entered
	 */
	@Test
	public void testwithInValidMobileNumber() {

		try {
			MobileNumberValidation.isValidMobileNumber(1234567890L);
			fail();
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals("Invalid Mobile Number", e.getMessage());
		}
	}

	/**
	 * In this test Case Mobile Number which has less than 10 numbers is Entered
	 */

	@Test
	public void testwithMobileNumberLessThanTenNumbers() {
		try {
			MobileNumberValidation.isValidMobileNumber(123456L);
			fail();
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals("Invalid Mobile Number", e.getMessage());
		}
	}

	/**
	 * In this test Case Mobile Number is Entered as Null
	 */
	@Test
	public void testwithMobileNumberAsNull() {
		try {
			MobileNumberValidation.isValidMobileNumber(null);
			fail();
		} catch (Exception e) {
			assertEquals("Mobile Number Should not be empty", e.getMessage());
		}
	}

}
