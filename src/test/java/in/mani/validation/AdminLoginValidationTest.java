package in.mani.validation;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdminLoginValidationTest {

	/**
	 * This test case is for Valid Admin Login
	 */
	@Test
	public void testValidAdminLogin() {
		try {
			AdminLoginValidator.validateAdminLogin("admin", "admin123");
			assertTrue(true);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail();
		}

	}

	/**
	 * This test case is for Invalid Admin ID
	 */
	@Test
	public void testInvalidAdminID() {
		try {
			AdminLoginValidator.validateAdminLogin("User", "admin123");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid Admin ID", e.getMessage());
		}
	}

	/**
	 * This test case is for Invalid Password
	 */
	@Test
	public void testInvalidPassword() {
		try {
			AdminLoginValidator.validateAdminLogin("admin", "admin678");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid Password", e.getMessage());
		}
	}

	/**
	 * This test case is for Invalid Credential
	 */
	@Test
	public void testInvalidCredential() {
		try {
			AdminLoginValidator.validateAdminLogin("User", "admin678");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid Credential", e.getMessage());
		}
	}

}
