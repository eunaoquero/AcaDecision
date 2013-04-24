/**
 * 
 */
package admin;

/**
 * Contains information about a user profile
 * @author rsilva
 *
 */
public class User {

	
	int userID;
	String firstName; 
	String lastName; 
	String email;
	String password;
	int groupID;


	/**
	 * @param userID
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param groupID
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


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getGroupID() {
		return groupID;
	}


	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	
	
}
