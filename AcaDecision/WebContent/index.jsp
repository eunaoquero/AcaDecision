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
			<li><a href="#">About</a></li>
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
	<div id="main">Lorem ipsum dolor sit amet, ddfdf sconsectetur adipiscing elit. 
	Duis egestas, dolor eu venenatis consectetur, eros urna pretium dui, eu 
	varius massa lorem venenatis dui. Ut tristique hendrerit lacus, eu gravida arcu mollis non. 
	Integer vehicula nisl eget arcu consequat at aliquet nulla rhoncus. 
	Etiam a libero porta libero feugiat pulvinar.</div>
	<div id="footer">
		<p>&copy; 2013 AcaDecision :: MIST 7530</p>
		<p>Buckheister | Lord | Pacis | Silva</p>
	</div>
</div>

</body>
</html>