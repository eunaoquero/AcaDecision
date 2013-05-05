/**
 * 
 */
package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import admin.*;

/**
 * Manages database access for administrator functions
 * 
 * @author rsilva
 * 
 */
public class DBHelper {

	static String JDBC_URL = "jdbc:mysql://97.74.31.15/acadecision";
	PreparedStatement getUserListStatement;
	PreparedStatement getGroupListStatement;
	PreparedStatement getAuthenticatedUserStatement;
	PreparedStatement getUserByEmailStatement;
	PreparedStatement addUserStatement;
	PreparedStatement delUserByEmailStatement;


	/**
	 * Establish a connection to the database and create the PreparedStatements
	 */

	public DBHelper() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL,"acadecision", "D3c1d3@551");
			System.out.println("Connected to Acadecision remote database");

			getAuthenticatedUserStatement = conn
					.prepareStatement("select * from acadecision.Users NATURAL JOIN acadecision.Groups where email = (?) and password = (?) limit 0,1");
			getUserListStatement = conn
					.prepareStatement("select * from acadecision.Users NATURAL JOIN acadecision.Groups order by lastName");
			getGroupListStatement = conn
					.prepareStatement("SELECT * FROM acadecision.Groups");
			getUserByEmailStatement = conn
					.prepareStatement("select * from acadecision.Users where email = ?"); 
			addUserStatement = conn
					.prepareStatement("insert into acadecision.Users (firstName, lastName, email, password, groupID) values (?,?,?,?,?)");
			delUserByEmailStatement = conn
					.prepareStatement("delete from acadecision.Users where email = ?");

		} catch (Exception e) {
			System.out.println("Error in constructor: "
					+ e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * Add User into Database receiving all Parameters 
	 * @param firstName User's First Name
	 * @param lastName User's Last Name
	 * @param email User's Email
	 * @param password User's Password
	 * @param groupID Identification Number of User's Group
	 * @return was the operation successful?
	 */
	public boolean addUser(String firstName, String lastName, String email,
			String password, int groupID) {

		boolean success = false;
		try {

			addUserStatement.setString(1, firstName);
			addUserStatement.setString(2, lastName);
			addUserStatement.setString(3, email);
			addUserStatement.setString(4, password);
			addUserStatement.setInt(5, groupID);
			addUserStatement.executeUpdate();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}

		/**
		 * Add User Object into Database 
		 * @param user Object to be added within the Database
		 * @return was the operation successful?
		 */
	public boolean addUser(User user) {
		return this.addUser(user.getFirstName(), user.getLastName(),
				user.getEmail(), user.getPassword(), user.getGroupID());

	}
	
	/**
	 * Retrieve User Object into Database
	 * @param email
	 * @return user Object form Database
	 */
	public User getUser(String email) {
		User user = null;
		ResultSet queryResult;
		try {
			getUserByEmailStatement.setString(1, email);

			queryResult = getUserByEmailStatement.executeQuery();

			if (queryResult.next()) {

				int userID = queryResult.getInt("userID");
				String firstName = queryResult.getString("firstName");
				String lastName = queryResult.getString("lastName");
				String password = queryResult.getString("password");				
				int groupID = queryResult.getInt("groupID");

				user = new User(userID, firstName, lastName, email, password,
						groupID);
			} else user = null;
		}
		catch (Exception e) {
			System.out.println("Getting User by Name\n"
					+ e.getClass().getName() + ": " + e.getMessage());
		}
		return user;
	}

	/**
	 * Delete User from Database
	 * @param email
	 * @return
	 */
	public boolean delUser(String email) {

		boolean success = false;

		try {
			delUserByEmailStatement.setString(1, email);
			delUserByEmailStatement.execute();
			success = true;

		} catch (Exception e) {
			System.out.println("Deletting User using email \n"
					+ e.getClass().getName() + ": " + e.getMessage());

		}

		return success;
	}


	/**
	 * Returns a user with details assigned if authentication is successful
	 * @param userName the username, userPassword the password
	 * @return User object
	 */
	public User authenticateUser(String userName, String userPassword) {
		User user = new User();
		ResultSet rs;
		try {
			getAuthenticatedUserStatement.setString(1, userName);
	        getAuthenticatedUserStatement.setString(2, userPassword);
	        rs = getAuthenticatedUserStatement.executeQuery();
	        
			// if rs not empty, it means password matches a record
			if (rs.next()) {
				user.setEmail(rs.getString("email"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setGroupID(rs.getInt("groupID"));
			} else
				user.setEmail("User not found");
			
		} catch (Exception e) {
			System.out.println("Error in authenticating user from database "
					+ e.getClass().getName() + ": " + e.getMessage());
		}
		return user;
	}
	
	/**
	 * Returns the user list
	 * @return ArrayList of User objects
	 */
	public ArrayList<User> getUserList() {
		ArrayList<User> userList = new ArrayList<User>();
		ResultSet rs;
		try {
			rs = getUserListStatement.executeQuery();

			// Loop through results and add to arraylist
			while (rs.next()) {
				User user = new User();
				user.setEmail(rs.getString("email"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setGroupName(rs.getString("groupName"));
				user.setUserID(rs.getInt("userID"));
				user.setGroupID(rs.getInt("groupID"));
				userList.add(user);
			}
			
		} catch (Exception e) {
			System.out.println("Error getting user list "
					+ e.getClass().getName() + ": " + e.getMessage());
		}
		return userList;
	}
	
	/**
	 * Returns the group list
	 * @return ArrayList of UserGroup objects
	 */
	public ArrayList<UserGroup> getGroupList() {
		ArrayList<UserGroup> groupList = new ArrayList<UserGroup>();
		ResultSet rs;
		try {
			rs = getGroupListStatement.executeQuery();

			// Loop through results and add to arraylist
			while (rs.next()) {
				UserGroup group = new UserGroup();
				group.setGroupID(rs.getInt("groupID"));
				group.setGroupName(rs.getString("groupName"));
				group.setGroupDescription(rs.getString("groupDescription"));
				groupList.add(group);
			}
			
		} catch (Exception e) {
			System.out.println("Error getting group list "
					+ e.getClass().getName() + ": " + e.getMessage());
		}
		return groupList;
	}

}