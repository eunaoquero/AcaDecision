package helpers;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import admin.*;



/**
 * Test methods for the DBHelper class
 * @author rsilva
 *
 */

public class DBHelperTest {
	   
		/**
		 * Test All Db Helper Methods
		 * 
		 */
		@Test
		public void testDBHelperMethods() {
			DBHelper instance = new DBHelper();
			
			//Testing addUser Method
			instance.addUser("fred", "flintstone", "ff@stoneage.com", "fredPass", 1);
			
			//Testing getUser Method
			User userTest1 = instance.getUser("ff@stoneage.com");
			assertEquals("User Name: ", "fred" , userTest1.getFirstName());
			
			//Testing getUserList Method
			ArrayList<User> userList = instance.getUserList();
			boolean success = false;
			
			//check if fred is in the Database
			for (int i = 0; i< userList.size() ; i++){
				if (userList.get(i).getFirstName().equals("fred")) success = true;}			
			assertTrue(success);
			
			//testing authentication method
			User userTest2 = instance.authenticateUser(userTest1.getEmail(), userTest1.getPassword());			
			assertEquals("Authenticated: ","ff@stoneage.com", userTest2.getEmail() );
			
			userTest2 = instance.authenticateUser("wrong username", userTest1.getPassword());
			assertEquals("Authenticated: ","User not found", userTest2.getEmail() );
			
			userTest2 = instance.authenticateUser(userTest1.getEmail(), "wrong Password");
			assertEquals("Authenticated: ","User not found", userTest2.getEmail() );
			
			//Testing delete user function
			assertTrue(instance.delUser(userTest1.getEmail()));
			assertNull(instance.getUser("ff@stoneage.com"));
			
			//Testing get Group method
			ArrayList<UserGroup> groupList = instance.getGroupList();
			success = false;
			for (int i = 0; i< groupList.size() ; i++){
				if (groupList.get(i).getGroupName().equals("admin")) success = true;}			
			assertTrue(success);
			
		}
		

}