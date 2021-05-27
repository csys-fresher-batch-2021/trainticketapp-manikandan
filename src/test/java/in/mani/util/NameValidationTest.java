package in.mani.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class NameValidationTest {

	/**
	 * This test case is for valid Name
	 */
	@Test
	public void testValidName() {
		try {
			NameValidation.isValidName("Manikandan S");
			assertTrue(true);
		} catch (RuntimeException e) {
			fail();
		}

	}

	/**
	 * In this Test Case Name is Entered as Null
	 */
	@Test
	public void testwithNameAsNull() {
		try {
			NameValidation.isValidName(null);
			fail();
		} catch (RuntimeException e) {
			assertEquals("Name Field should not be Empty", e.getMessage());
		}
	}

	/**
	 * In this Test Case Name is Entered Which has Numbers
	 */
	@Test
	public void testwithNameHasNumber() {
		try {
			NameValidation.isValidName("Mani375");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid Name", e.getMessage());
		}
	}

	/**
	 * In this Test Case Name is Entered Which has Special Characters
	 */
	@Test
	public void testwithNameHasSpecialCharacters() {
		try {
			NameValidation.isValidName("Mani@!");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid Name", e.getMessage());
		}
	}

}
