/**
 * 
 */
package admin;

import java.util.ArrayList;



/**
 * User Group Data Transfer Object Class
 * @author blord
 *
 */
public class UserGroup {
	
	int groupID; 
	String groupName;
	String groupDescription;
	private ArrayList<GroupRole> roles;
	
	
	/**
	 * Default Constructor 
	 * (all initial arguments required)
	 * 
	 * @param groupID Group Identification Number
	 * @param groupName Group's Name
	 * @param groupDescription Group's Description
	 * @param roles List of Group's Roles
	 */
	public UserGroup(int groupID, String groupName, String groupDescription) {
		this.groupID = groupID;
		this.groupName = groupName;
		this.groupDescription = groupDescription;
		this.roles = new ArrayList<GroupRole>();
	}

	/**
	 * Test Non-Arguments Constructor
	 */
	public UserGroup(){
		
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

	/**
	 * @return the Roles List
	 */
	public ArrayList<GroupRole> getRoles(){
		return roles;
	}
	
	/**
	 * Method to add a new Role within this Group Class
	 * @param newRole
	 */
	public void addRole(GroupRole newRole){
		roles.add(newRole);
	}
	
	/**
	 * Method to add List of Roles within this Group Class
	 * @param rolesTmp
	 */
	public void addRoleList(ArrayList<GroupRole> rolesTmp){
		this.roles = rolesTmp;
	}
	

}
