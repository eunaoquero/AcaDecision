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
	PreparedStatement getAuthenticatedUserStatement;
	PreparedStatement getUserByEmailStatement;
	PreparedStatement addUserStatement;
	PreparedStatement delUserByIDStatement;
	PreparedStatement getGroupByNameStatement;
	PreparedStatement addGroupStatement;
	PreparedStatement getRoleByIdStatement;
	PreparedStatement addRoleStatement;
	PreparedStatement getGroup_RoleStatement;
	PreparedStatement addGroup_RoleStatement;

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
			getUserByEmailStatement = conn
					.prepareStatement("select * from acadecision.Users where email = ?"); // output: userID,firstName,lastName,email,password,groupID
			addUserStatement = conn
					.prepareStatement("insert into acadecision.Users (firstName, lastName, email, password, Groups_groupID) values (?,?,?,?,?)");
			delUserByIDStatement = conn
					.prepareStatement("delete from acadecision.Users where userID = ?");
			getGroupByNameStatement = conn
					.prepareStatement("select * from acadecision.Groups where groupName = ?"); // output:groupID,groupName,groupDescription 
			addGroupStatement = conn
					.prepareStatement("insert into acadecision.Groups (groupName, groupDescription) values (?,?)");
			getRoleByIdStatement = conn
					.prepareStatement("select * from acadecision.Roles where roleId = ?"); // output:roleID,roleName,roleDescription, method
			addRoleStatement = conn
					.prepareStatement("insert into acadecision.Roles (roleName, roleDescription, method) values (?,?,?)");
			getGroup_RoleStatement = conn
					.prepareStatement("select Roles_roleID from acadecision.Group_Roles where groupID = ?");
			addGroup_RoleStatement = conn
					.prepareStatement("insert into acadecision.Group_Roles (groupID, roleID) values (?,?)");

		} catch (Exception e) {
			System.out.println("Error in constructor: "
					+ e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
		}

	}

	// addUserStatement =
	// conn.prepareStatement("insert into Users (firstName, lastName, email, password, Groups_groupID) values (?,?,?,?,?)");
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

	public boolean addUser(User user) {
		return this.addUser(user.getFirstName(), user.getLastName(),
				user.getEmail(), user.getPassword(), user.getGroupID());

	}

	public User getUser(String email) {

		User user = null;
		ResultSet queryResult;

		try {
			getUserByEmailStatement.setString(1, email);

			queryResult = getUserByEmailStatement.executeQuery();

			while (queryResult.next()) {

				int userID = queryResult.getInt("userID");
				;
				String firstName = queryResult.getString("firstName");
				;
				String lastName = queryResult.getString("lastName");
				String password = queryResult.getString("password");
				;
				int groupID = queryResult.getInt("groupID");

				user = new User(userID, firstName, lastName, email, password,
						groupID);
			}
		}

		catch (Exception e) {
			System.out.println("Getting User by Name\n"
					+ e.getClass().getName() + ": " + e.getMessage());
		}

		return user;

	}

	public boolean delUser(int userID) {

		boolean queryResult = false;
		try {
			delUserByIDStatement.setInt(1, userID);

			queryResult = delUserByIDStatement.execute();
		} catch (Exception e) {
			System.out.println("Deletting User by ID \n"
					+ e.getClass().getName() + ": " + e.getMessage());

		}

		return queryResult;
	}

	public UserGroup getGroup(String groupName) {

		UserGroup group = null;
		ResultSet queryResult;
		int groupID = -1;

		try {
			getGroupByNameStatement.setString(1, groupName);

			queryResult = getGroupByNameStatement.executeQuery();

			while (queryResult.next()) {
				groupID = queryResult.getInt("groupID");
				String groupDescription = queryResult
						.getString("groupDescription");

				group = new UserGroup(groupID, groupName, groupDescription);
			}
		}

		catch (Exception e) {
			System.out.println("Getting Group by Name\n"
					+ e.getClass().getName() + ": " + e.getMessage());
		}

		group.addRoleList(getRolesByGroup(groupID));
		return group;

	}

	public GroupRole getRole(int roleID) {

		GroupRole role = null;
		ResultSet queryResult;

		try {
			getRoleByIdStatement.setInt(1, roleID);

			queryResult = getRoleByIdStatement.executeQuery();

			while (queryResult.next()) {

				String roleName = queryResult.getString("roleName");
				String roleDescription = queryResult
						.getString("roleDescription");
				String method = queryResult.getString("method");

				role = new GroupRole(roleID, roleName, roleDescription, method);
			}
		}

		catch (Exception e) {
			System.out.println("Getting Item by ID\n" + e.getClass().getName()
					+ ": " + e.getMessage());
		}

		return role;

	}

	public ArrayList<GroupRole> getRolesByGroup(int groupID) {

		ArrayList<GroupRole> roles = new ArrayList<GroupRole>();
		ResultSet queryResult;
		GroupRole roleTmp = null;

		try {
			getGroup_RoleStatement.setInt(1, groupID);

			queryResult = getGroup_RoleStatement.executeQuery();

			while (queryResult.next()) {
				int roleID = queryResult.getInt("Roles_roleID");
				roleTmp = getRole(roleID);
				roles.add(roleTmp);
			}
		}

		catch (Exception e) {
			System.out.println("Getting Item by ID\n" + e.getClass().getName()
					+ ": " + e.getMessage());
		}
		return roles;
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
				user.setFirstName(rs.getString("lastName"));
				user.setLastName(rs.getString("firstName"));
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

}