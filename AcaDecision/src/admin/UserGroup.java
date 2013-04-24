/**
 * 
 */
package admin;

import java.util.ArrayList;



/**
 * Contains information about a User Group
 * @author rsilva
 *
 */
public class UserGroup {
	
	int groupID; 
	String groupName;
	String groupDescription;
	private ArrayList<GroupRole> roles;
	
	
	/**
	 * @param groupID
	 * @param groupName
	 * @param groupDescription
	 */
	public UserGroup(int groupID, String groupName, String groupDescription) {
		this.groupID = groupID;
		this.groupName = groupName;
		this.groupDescription = groupDescription;
		this.roles = new ArrayList<GroupRole>();
	}


	/**
	 * @return the groupID
	 */
	public int getGroupID() {
		return groupID;
	}


	/**
	 * @param groupID the groupID to set
	 */
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}


	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}


	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	/**
	 * @return the groupDescription
	 */
	public String getGroupDescription() {
		return groupDescription;
	}


	/**
	 * @param groupDescription the groupDescription to set
	 */
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	
	
	public void addRole(GroupRole newRole){
		roles.add(newRole);
	}
	
	public void addRoleList(ArrayList<GroupRole> rolesTmp){
		this.roles = rolesTmp;
	}
	

}
