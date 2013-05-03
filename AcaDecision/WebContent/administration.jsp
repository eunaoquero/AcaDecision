<%
	/** 
	 * The administration page of the Auction site
	 * @author rsilva
	 **/
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://fonts.googleapis.com/css?family=Noto+Sans:400,400italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/styles.css" />
<title>AcaDecision :: Administration</title>
</head>
<body>

	<div id="container">
		<div id="header">
			<div id="header_text">
				<h1>AcaDecision</h1>
			</div>

			<div id="main_menu">
				<ul id="menu">
					<li><a href="/">Home</a></li>
					<li><a href="dashboard.jsp">Dashboards</a></li>
					<li><a href="/Admin">Admin</a></li>
				</ul>
			</div>
		</div>
		<div id="sidebar">
			<%@ include file="sidebar.jsp" %>
		</div>
		<div id="main">
			<h3>Administration Panel</h3>
			<%-- Check if user is logged in --%>
			<c:choose>
				<c:when test="${!empty sessionScope.userName}">
					<c:choose>
						<c:when test="${sessionScope.groupID == 1}">
							<p>
							<small><em>Admins</em> have access to all pages, <em>SuperUsers</em> have access to just the Dashboard page.</small>
							</p>
														<form method="post" action="Admin">
								<table cellspacing="3" cellpadding="3">
									<tr><td bgcolor="#C9C7BA" colspan="2"><em>Register User (all fields required)</em></td></tr>
									<c:choose>
					  					<c:when test="${!empty addUserError}">
											<tr>
												<td colspan="2"><span style="font-weight:bold; color: red;">User registration failed! All fields are required!</span></td>
											</tr>
									  	</c:when>
									</c:choose>
									<tr><td>First Name: </td><td><input type="text" size="30" name="firstName"></td></tr>
									<tr><td>Last Name: </td><td><input type="text" size="30" name="lastName"></td></tr>
									<tr><td>Email/Username: </td><td><input type="text" size="30" name="email"></td></tr>
									<tr><td>Password: </td><td><input type="password" size="30" name="password"></td></tr>
									<tr><td>Group: </td><td>
									<select name="groupID">
										<%-- Loop through all groups and use as options of the select --%>
										<c:forEach items="${groupList }" var="group">
											<option value="${group.groupID}">${group.groupName}</option>
										</c:forEach>
									</select>
									</td></tr>
									<tr><td colspan="2"><input type="submit" value="Register"></td></tr>
								</table>
								<input type="hidden" name="method" value="addUser"><input type="hidden" name="referrer" value="/administration.jsp">
							</form><br/>
							<table border="1" width="80%" cellpadding="2" cellspacing="2">
								<tr>
								<td colspan="4" bgcolor="#C9C7BA"><strong><em>User List</em></strong></td>
								</tr>
								<tr>
									<td width="20%" bgcolor="#CACACA"><strong>Last Name</strong></td>
									<td width="20%" bgcolor="#CACACA"><strong>First Name</strong></td>
									<td width="40%" bgcolor="#CACACA"><strong>Username/Email</strong></td>
									<td width="20%" bgcolor="#CACACA"><strong>Group</strong></td>
								</tr>
								<%-- Loop through the user list --%>
								<c:forEach items="${userList}" var="user">
									<tr>
										<td>${user.lastName}</td>
										<td>${user.firstName}</td>
										<td>${user.email}</td>
										<td>${user.groupName}</td>
									</tr>
								</c:forEach>
							</table><br/>
						</c:when>
						<c:otherwise>
							<p>You do not have the privileges to view this page.</p>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<p>Please log in as an administrator</p>
				</c:otherwise>
			</c:choose>
		</div>
		<div id="footer">
			<p>&copy; 2013 AcaDecision :: MIST 7530</p>
			<p>Buckheister | Lord | Pacis | Silva</p>
		</div>
	</div>

</body>
</html>