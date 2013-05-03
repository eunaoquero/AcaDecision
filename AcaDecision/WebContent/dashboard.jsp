<%
	/** 
	 * Dashboard.jsp page displays the graphs for the Acadecision site.
	 * @author rpacis
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
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.4.4/underscore-min.js"></script>
<c:choose>
	<c:when test="${!empty enrollmentData }">
		<script>
			/**
			 * Javascript function uses jQuery, Highcharts and Underscore.js libraries
			 * to display the HTML5 charts. Data comes from the webServiceHelper.
			 * jQuery (http://jquery.com/)
			 * Highcharts (http://www.highcharts.com/)
			 * Underscore (http://underscorejs.org/)
			 */

			$(function() {
				// set the theme
				Highcharts
						.setOptions({
							chart : {
								backgroundColor : 'rgba(255, 255, 255, 0.1)'
							},
							xAxis : {

							},
							yAxis : {

							},
							legend : {
								enabled : false
							},
							credits : {
								enabled : false
							},
							 plotOptions: {
					                pie: {
					                    allowPointSelect: true,
					                    cursor: 'pointer',
					                    dataLabels: {
					                        enabled: true,
					                        borderWidth: 2,
					                        borderColor: '#0F4A58',
					                        backgroundColor: 'rgba(252, 255, 197, 0.7)',
					                        padding: 5,
					                        borderRadius: 5,
					                        distance: -1,
					                        color: '#C73C25',
					                        formatter: function() {
					                            return '<b>'+ this.point.name +'</b>: '+ Highcharts.numberFormat(this.point.y,0);
					                        }
					                    }
					                }
							 }
						});

				// default options
				var options = {};
				var colors = Highcharts.getOptions().colors;
				var jsonData = ${enrollmentData};
				var data = [];
				var genderData = [];
				var gradData = [];

				//parse the JSON data for chart 1
				var categories = _.pluck(jsonData, 'MAJOR_DESC');
				for ( var i = 0, jsonDataLength = jsonData.length; i < jsonDataLength; i++) {
					var enrollment = jsonData[i];
					data.push({
						y : parseInt(enrollment.STUDENTS),
						color : colors[i % colors.length]
					});
				}

				// create the charts
				var chart1Options = {
					chart : {
						type : 'bar',
						renderTo : 'graph1',
						height: 550
					},
				    title: {
					          text: '${term } Enrollment By Major - College of Engineering'
					},
					xAxis : {
						categories : categories,
					},
					tooltip : {
						formatter : function() {
							return '<b>' + this.x
									+ '</b><br>Students Enrolled: ' + this.y;
						}
					},
					series : [ {
						name : 'Majors',
						data : data,
						dataLabels : {
							enabled : true,
						}
					} ]
				};
				
				//parse the JSON data for chart 2
				jsonData = ${enrollmentGenderData};
				for ( var i = 0, jsonDataLength = jsonData.length; i < jsonDataLength; i++) {
					genderData.push(
							[ jsonData[i]['GENDER'], parseInt(jsonData[i]['STUDENTS']) ]
					);
				}

				var chart2Options = {
					chart : {
						renderTo : 'graph2',
						height: 250
					},
				    title: {
				          text: '${term } Enrollment by Gender'
					},

					series : [ {
						type: 'pie',
						name : 'Students',
						size:'100%',
						data : genderData,
					} ]
				};
				
				//parse the JSON data for chart 3
				jsonData = ${enrollmentGradData};
				for ( var i = 0, jsonDataLength = jsonData.length; i < jsonDataLength; i++) {
					gradData.push(
							[ jsonData[i]['DEGREE_LEVEL'], parseInt(jsonData[i]['STUDENTS']) ]
					);
				}
				
				//chart options for chart 3
				var chart3Options = {
						chart : {
							renderTo : 'graph3',
							height: 250
						},
					    title: {
					          text: '${term } Enrollment by Degree Level'
						},

						series : [ {
							type: 'pie',
							name : 'Degree Level',
							size:'100%',
							data : gradData,
						} ]
					};
				
				//display chart 1
				chart1Options = jQuery.extend(true, {}, options, chart1Options);
				var chart1 = new Highcharts.Chart(chart1Options);
				
				//display chart 2
				chart2Options = jQuery.extend(true, {}, options, chart2Options);
				var chart2 = new Highcharts.Chart(chart2Options);
				
				//display chart 3
				chart3Options = jQuery.extend(true, {}, options, chart3Options);
				var chart3 = new Highcharts.Chart(chart3Options);
			});
		</script>
	</c:when>
</c:choose>
<title>AcaDecision :: Dashboard</title>
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
					<li><a href="/Controller">Dashboards</a></li>
					<li><a href="/Admin">Admin</a></li>
				</ul>
			</div>
		</div>
		<div id="sidebar">
			<%@ include file="sidebar.jsp" %>
		</div>
		<div id="main">
			<h3>Dashboard Page</h3>
			<%-- Check if user is logged in --%>
			<c:choose>
				<c:when test="${!empty sessionScope.userName}">
				<p>
				<small>The charts on this page render live data from the operational data store. The AcaDecision team developed a simple web service
				that connects to the database and outputs the data in JSON format. This is then rendered into HTML5 charts using the
				HighCharts JS library (http://www.highcharts.com/).</small>
				</p>
				<p>
				<small>To start, please select a Fall Term from the drop-down below, and click <em>View Data</em>.</small>
				</p>
				<form method="post" action="Controller">
					<SELECT NAME="term_code">
						<OPTION VALUE="">Choose Term
						<OPTION VALUE="2012%20Fall">Fall 2012
						<OPTION VALUE="2011%20Fall">Fall 2011
						<OPTION VALUE="2010%20Fall">Fall 2010
						<OPTION VALUE="2009%20Fall">Fall 2009
						<OPTION VALUE="2008%20Fall">Fall 2008
					</SELECT> <input type="submit" value="View Data">
				</form>
				<div id="graph1" style="min-width: 400px; margin: 0 auto"></div>
				<div id="graph2" style="min-width: 350px; margin: 0 auto; float:left; border: 0px solid black"></div>
				<div id="graph3" style="min-width: 350px; margin: 0 auto; float:right; border: 0px solid black"></div>
				</c:when>
				<c:otherwise>
					<p>Please login to view the dashboard page.</p>
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