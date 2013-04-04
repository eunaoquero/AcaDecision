<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<div id="header_text"><h1>AcaDecision</h1></div>

		<div id="main_menu">
		<ul id="menu">
			<li><a href="index.jsp">Home</a></li>
			<li><a href="dashboard.jsp">Dashboards</a></li>
			<li><a href="#">About</a></li>
		</ul>
		</div>
	</div>
	<div id="sidebar">
		<p>Welcome!
		<strong>Vincent Van Gogh</strong>, <em>logout?</em></p>
		<p>
		College News:
		</p>
	</div>
	<div id="main">
		<form method="post" action="dashboard.jsp">
			<SELECT NAME="dashboardType">
				<OPTION VALUE="">Choose the information Type
				<OPTION VALUE="Student Enrollment Statistics">Student Enrollment Statistics
				<OPTION VALUE="College Financials">College Financials
				<OPTION VALUE="Total Research Expenditures" >Total Research Expenditures
			</SELECT>
			<input type="submit" value="View Results"> 
		</form>
		<br/>
		<img src="dash.jpg" width="98%"></div>
		<div id="footer">
			<p>&copy; 2013 AcaDecision :: MIST 7530</p>
			<p>Buckheister | Lord | Pacis | Silva</p>
		</div>
</div>

</body>
</html>