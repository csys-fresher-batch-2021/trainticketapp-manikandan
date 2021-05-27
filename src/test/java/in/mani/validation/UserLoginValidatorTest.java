package in.mani.validation;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserLoginValidatorTest {

	@Test
	public void testWithValidUser() {
		try {
			UserLoginValidator.isValidLogin("Muthu533", "pass@6789");
			assertTrue(true);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testWithInValidUser() {
		try {
			UserLoginValidator.isValidLogin("Muthu", "pass79");
			fail();
		} catch (RuntimeException e) {
			e.printStackTrace();
			assertEquals("Invalid Login", e.getMessage());
		}
	}

	@Test
	public void testWithNull() {
		try {
			UserLoginValidator.isValidLogin(null, null);
			fail();
		} catch (RuntimeException e) {
			e.printStackTrace();
			assertEquals("User Name or Password should not be empty", e.getMessage());
		}
	}
}
