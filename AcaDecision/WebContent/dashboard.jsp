<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <jsp:useBean class="helpers.WebServiceHelper" id="webServiceHelper"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/styles.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.4.4/underscore-min.js"></script>
<script>
/**
 * Javascript function uses Highcharts and Underscore.js libraries
 * to display the HTML5 charts. Data comes from the webServiceHelper.
 */
var enrollmentChart;
$(function() {
    var colors = Highcharts.getOptions().colors;
    var jsonData =  ${jsonData };   
    var categories = _.pluck(jsonData, 'MAJOR_DESC'); 
    var data = [];

for(var i = 0, jsonDataLength = jsonData.length ; i < jsonDataLength ; i++ )
    {
        var enrollment = jsonData[i];
        data.push({y: parseInt(enrollment.STUDENTS) , color: colors[ i % colors.length] });
    }
    
enrollmentChart = new Highcharts.Chart({
       chart: {
          renderTo: 'graph1',
          type: 'bar',
          backgroundColor:'rgba(255, 255, 255, 0.1)'
       },
       title: {
          text: '${term } Enrollment - College of Engineering'
       },
		credits: {
           enabled: false
       },
		tooltip: {
               formatter: function() {
                   return '<b>'+ this.x +'</b><br>Students Enrolled: '+this.y;
               }
           },
       xAxis: {
          categories: categories,
          labels: {
              style: {
                  fontSize: '10px',
                  fontFamily: 'Helvetica Neue,Helvetica,Arial,sans-serif',
                  color: 'black',
                  lineColor: 'transparent'
              }
          }
       },
       yAxis: {
          title: {
             text: 'Students Enrolled',
             style: {
                 fontSize: '10px',
                 fontFamily: 'Helvetica Neue,Helvetica,Arial,sans-serif',
                 color: 'black',
                 fontWeight: 'normal',
                 lineColor: 'transparent',
                 min: 0, 
                 max: 2700
             }
          }
       },
       legend: {
           enabled: false
       },
       tooltip:{
          enabled: false
       },
       series: [{
          name: 'Majors',
          data: data,
          dataLabels: {
              enabled: true,
           }      
         }
       ],
       exporting: {
           enabled: false
       }
    });
 });
</script>
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
			<p>
				Welcome! <strong>Vincent Van Gogh</strong>, <em>logout?</em>
			</p>
			<p>College News:</p>
		</div>
		<div id="main">
			<form method="post" action="Controller">
				<SELECT NAME="term_code">
					<OPTION VALUE="">Choose Term
					<OPTION VALUE="2012%20Fall">Fall 2012
					<OPTION VALUE="2011%20Fall">Fall 2011
					<OPTION VALUE="2010%20Fall">Fall 2010
				</SELECT> <input type="submit" value="View Results">
			</form>
			<div id="graph1" style="min-width: 400px; height: 550px; margin: 0 auto"></div>
		</div>
		<div id="footer">
			<p>&copy; 2013 AcaDecision :: MIST 7530</p>
			<p>Buckheister | Lord | Pacis | Silva</p>
		</div>
	</div>

</body>
</html>