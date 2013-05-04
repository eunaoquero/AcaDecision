/**
 * 
 */
package admin;

/**
 * User's Data Transfer Object Class
 * @author dbuckheister
 *
 */
public class User {
	
	int userID;
	String firstName; 
	String lastName; 
	String email;
	String password;
	int groupID;
	String groupName;

	/**
	 * Default Constructor 
	 * (all initial arguments required)
	 * 
	 * @param userID User Identification Number
	 * @param firstName User's First Name
	 * @param lastName User's Last Name
	 * @param email User's Email
	 * @param password User's Password
	 * @param groupID Identification Number of User's Group
	 */
	public User(int userID, String firstName, String lastName, String email,
			String password, int groupID) {
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.groupID = groupID;
	}


	/**
	 * Non-Arguments Constructor 
	 */
	public User() {

	}


	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}


	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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



	
	
}
