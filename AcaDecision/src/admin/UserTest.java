/**
 * 
 */
package admin;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test methods for the User class
 * @author dbuckheister
 *
 */
public class UserTest {

	/**
	 * Tests for User Class
	 *  
	 */
	@Test
	public void testUserClass() {

		/**
		 * Test Default Constructor
		 */
		User user1 = new User(1, "firstName1", "lastName1", "email1",
				"password1", 1 );		
		assertNotNull(user1);

		/**
		 * Test Non-Arguments Constructor
		 */
		User user2 = new User();
		assertNotNull(user2);

		/**
		 * UserID Setter and Getter
		 */
		user2.setUserID(2);
		assertEquals("UserID:", 2, user2.getUserID());

		/**
		 * firstName Setter and Getter
		 */
		user2.setFirstName("firstName2");
		assertEquals("First Name:", "firstName2", user2.getFirstName());

		/**
		 * LastName Setter and Getter
		 */
		user2.setLastName("lastName2");
		assertEquals("Last Name:", "lastName2", user2.getLastName());

		/**
		 * Email Setter and Getter
		 */
		user2.setEmail("email2");
		assertEquals("Email:", "email2", user2.getEmail());

		/**
		 * Password Setter and Getter
		 */
		user2.setPassword("password2");
		assertEquals("Password:", "password2", user2.getPassword());		
		
		/**
		 * GroupID Setter and Getter
		 */
		user2.setGroupID(2);
		assertEquals("GroupID:", 2, user2.getGroupID());		
		
	}


}
