/**
 * 
 */
package admin;

/**
 * Contains information about a GroupRole 
 * A GroupRole allows a user access to different areas
 * of the application
 * @author rpacis
 *
 */
public class GroupRole {
	
	int roleID;
	String roleName;
	String roleDescription;
	String method;
	
	
	/**
	 * Default Constructor 
	 * (all initial arguments required)
	 * 
	 * @param roleID Role Identification Number
	 * @param roleName Role's Name
	 * @param roleDescription Role's Description
	 * @param method Role's Method
	 */
	public GroupRole(int roleID, String roleName, String roleDescription,
			String method) {
		this.roleID = roleID;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.method = method;
	}
	
	/**
	 * Test Non-Arguments Constructor
	 */
	public GroupRole(){
			
	}


	/**
	 * @return the roleID
	 */
	public int getRoleID() {
		return roleID;
	}


	/**
	 * @param roleID the roleID to set
	 */
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}


	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}


	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	/**
	 * @return the roleDescription
	 */
	public String getRoleDescription() {
		return roleDescription;
	}


	/**
	 * @param roleDescription the roleDescription to set
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}


	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}


	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

}
