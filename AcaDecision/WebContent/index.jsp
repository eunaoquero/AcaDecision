<%
	/** 
	 * Main index page
	 * @author rpacis
	 **/
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://fonts.googleapis.com/css?family=Noto+Sans:400,400italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/styles.css" />
<title>AcaDecision :: Home</title>
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
					<li><a href="Controller">Dashboards</a></li>
					<li><a href="Admin">Admin</a></li>
				</ul>
			</div>
		</div>
		<div id="sidebar">
			<%@ include file="sidebar.jsp" %>
		</div>
		<div id="main">
			<h3>About AcaDecision</h3>
			<p>AcaDecision is a visualization tool created to help facilitate
				the decision making of college administrators and department heads.
				It allows for a quick and easy way to see the current status of a
				college using different graphs and table summaries.</p>
			<p>Data for the charts in this application are retrieved via a web service
			connected to an external operational data store.</p>
			<p>
			<u>Default user logins for this demo are:</u><br/>
			<em>Administrator</em><br/>
			Username: admin@acadecision.com<br/>
			Password: admin<br/><br/>
			<em>Super User</em><br/>
			Username: charles@acadecision.com<br/>
			Password: charles<br/>
			</p>
		</div>
		<div id="footer">
			<p>&copy; 2013 AcaDecision :: MIST 7530</p>
			<p>Buckheister | Lord | Pacis | Silva</p>
		</div>
	</div>

</body>
</html>