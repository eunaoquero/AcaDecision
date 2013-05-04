/**
 * 
 */
package admin;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Test methods for the UserGroup class
 * @author blord
 *
 */
public class UserGroupTest {

	/**
	 * Tests for UserGroup Class
	 *  
	 */
	@Test
	public void testUserGroupClass() {
		
		/**
		 * Test Default Constructor
		 */
		UserGroup group1 = new UserGroup(1, "groupName1", "groupName1 Description");	
		assertNotNull(group1);

		/**
		 * Test Non-Arguments Constructor
		 */
		UserGroup group2 = new UserGroup();
		assertNotNull(group2);

		/**
		 * GroupID Setter and Getter
		 */
		group2.setGroupID(2);
		assertEquals("UserID: ", 2, group2.getGroupID());

		/**
		 * GroupID Setter and Getter
		 */
		group2.setGroupName("groupName2");
		assertEquals("Group Name: ", "groupName2", group2.getGroupName());
		
		/**
		 * GroupDesc Setter and Getter
		 */
		group2.setGroupDescription("groupName2 description");
		assertEquals("Group Description: ", "groupName2 description", group2.getGroupDescription());
		
		/**
		 * Test Add Role Method
		 */
		GroupRole role1 = new GroupRole(1, "Role1 Name", "Role1 Description","Role1 method");
		GroupRole role2 = new GroupRole(2, "Role2 Name", "Role2 Description","Role2 method");

		/**
		 * Create a List and add to group
		 */
		role1.getRoleName();
		ArrayList<GroupRole> roleList = new ArrayList<GroupRole>();
		roleList.add(role1);
		group2.addRoleList(roleList);
		assertTrue(group2.getRoles().equals(roleList));
		
		/**
		 * Add Role in the Group's List
		 */
		group2.addRole(role2);
		assertTrue(group2.getRoles().contains(role2));
		
	}

}
