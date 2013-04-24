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
	 * @param roleID
	 * @param roleName
	 * @param roleDescription
	 * @param method
	 */
	public GroupRole(int roleID, String roleName, String roleDescription,
			String method) {
		this.roleID = roleID;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.method = method;
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
