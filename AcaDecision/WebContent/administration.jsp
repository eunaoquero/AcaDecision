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
<link rel="stylesheet" href="css/styles.css" />
<title>AcaDecision :: Dashboards</title>
</head>
<body>

	<div id="container">
		<div id="header">
			<div id="header_text">
				<h1>AcaDecision</h1>
			</div>

			<div id="main_menu">
				<ul id="menu">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="dashboard.jsp">Dashboards</a></li>
					<li><a href="administration.jsp">Admin</a></li>
				</ul>
			</div>
		</div>
		<div id="sidebar">
			<%@ include file="sidebar.jsp" %>
		</div>
		<div id="main">
			<h2>Administration Panel</h2>
			<%-- Check if user is logged in --%>
			<c:choose>
				<c:when test="${!empty sessionScope.userName}">
					<c:choose>
						<c:when test="${sessionScope.groupID == 1}">
							<jsp:useBean class="helpers.DBHelper" id="dbHelper"/>
							<table border="1" width="80%" cellpadding="3" cellspacing="2">
								<tr>
									<td width="20%" bgcolor="#CACACA"><strong>Last Name</strong></td>
									<td width="20%" bgcolor="#CACACA"><strong>First Name</strong></td>
									<td width="40%" bgcolor="#CACACA"><strong>Username/Email</strong></td>
									<td width="20%" bgcolor="#CACACA"><strong>Group</strong></td>
								</tr>
								<%-- Loop through the user list --%>
								<c:forEach items="${dbHelper.userList }" var="user">
									<tr>
										<td>${user.lastName}</td>
										<td>${user.firstName}</td>
										<td>${user.email}</td>
										<td>${user.groupName}</td>
									</tr>
								</c:forEach>
							</table>
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