/**
 * 
 */
package admin;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test methods for the GroupRole class
 * @author rpacis
 *
 */
public class GroupRoleTest {

	/**
	 * Tests for GroupRole Class
	 *  
	 */
	@Test	public void testGroupRoleClass() {
		
		/**
		 * Test Default Constructor
		 */
		GroupRole role1 = new GroupRole(1, "Role1Name", "Role1Description", "Role1Method");	
		assertNotNull(role1);

		/**
		 * Test Non-Arguments Constructor
		 */
		GroupRole role2 = new GroupRole();
		assertNotNull(role2);
		
		/**
		 * RoleID Setter and Getter
		 */
		role2.setRoleID(2);
		assertEquals("RoleID: ", 2, role2.getRoleID());
		
		/**
		 * roleName Setter and Getter
		 */
		role2.setRoleName("role2Name");
		assertEquals("Role Name: ", "role2Name", role2.getRoleName());

		/**
		 * roleDescription Setter and Getter
		 */
		role2.setRoleDescription("role2Description");
		assertEquals("Role Description: ", "role2Description", role2.getRoleDescription());
		
		/**
		 * roleMethod Setter and Getter
		 */
		role2.setMethod("role2Method");
		assertEquals("Role Method: ", "role2Method", role2.getMethod());

		
	}

}
