<%-- Check if user is logged in --%>
<c:choose>
	<c:when test="${empty sessionScope.userName}">
		<form method="post" action="Admin">
			<p>Username:</p>
			<p>
				<input type="text" name="userName">
			</p>
			<p>Password:</p>
			<p>
				<input type="password" name="userPassword">
			</p>
			<p>
				<input type="hidden" name="referrer" value="${pageContext.request.servletPath}">
				<input type="hidden" name="method" value="login">
				<input type="submit" value="Login">
			</p>
			<c:choose>
				<c:when test="${userNotFound == 'Yes'}">
					<p><span style="font-weight:bold; color: red;"><em>You have entered an incorrect username and login!</em></span></p>
				</c:when>
			</c:choose>
		</form>
	</c:when>
	<c:otherwise>
		<p>Hello, ${sessionScope.firstName} ${sessionScope.lastName}!<br/><a href="Admin?method=logout&referrer=${pageContext.request.servletPath}">Logout</a></p>
	</c:otherwise>
</c:choose>