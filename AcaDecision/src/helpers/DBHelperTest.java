package helpers;


import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Test methods for the DBHelper class
 * Tests methods for adding, updating and deleting users
 * Tests methods for managing roles and user groups.
 * @author rsilva
 *
 */

public class DBHelperTest {
	   
		/**
		 * Add some users and verify if they are there
		 * 
		 */
		@Test
		public void testAddUsers() {
			DBHelper instance = new DBHelper();
			instance.addUser("fred", "flintstone", "ff@stoneage.com", "rockrocks", 1);
			instance.addUser("peter", "parker", "pp@nyc.com", "spidersecret", 1);
			
			assertEquals("first user: ", "fred", instance.getUser("ff@stoneage.com").getFirstName());
	}

}