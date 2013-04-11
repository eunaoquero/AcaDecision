<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/styles.css" />
<title>AcaDecision :: Home</title>
</head>
<body>

<div id="container">
	<div id="header">
		<div id="header_text"><h1>AcaDecision</h1></div>

		<div id="main_menu">
		<ul id="menu">
			<li><a href="index.jsp">Home</a></li>
			<li><a href="dashboard.jsp">Dashboards</a></li>
			<li><a href="administration.jsp">Admin</a></li>
		</ul>
		</div>
	</div>
	<div id="sidebar">
		<form method="post" action="home.jsp">
			<p>Username: </p>
			<p><input type="text" name=""></p>
			<p>Password:</p>
			<p><input type="text" name=""></p>
			<p> 
			<input type="submit" value="Login"></p>
		</form>
	</div>
	<div id="main">
	<h2>About AcaDecision</h2>
	<p>AcaDecision is a visualization tool created to help facilitate the decision making of college administrators and department heads. It allows for a quick and easy way to see the current status of a college using different graphs and table summaries.</p>
	<p>2013 Spring Project for MIST 7570</p>
	<p>
	<ul>
		<li>Davis Buckheister</li>
		<li>Brian Lord</li>
		<li>Rafael Silva</li>
		<li>Rodney Pacis</li>
	</ul>
	</p>
	</div>
	<div id="footer">
		<p>&copy; 2013 AcaDecision :: MIST 7530</p>
		<p>Buckheister | Lord | Pacis | Silva</p>
	</div>
</div>

</body>
</html>