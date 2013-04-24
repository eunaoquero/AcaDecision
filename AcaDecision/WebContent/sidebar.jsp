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
		</form>
	</c:when>
	<c:otherwise>
		<p><small>Welcome, ${sessionScope.firstName} ${sessionScope.lastName}, <a href="Admin?method=logout&referrer=${pageContext.request.servletPath}">logout?</a></small></p>
	</c:otherwise>
</c:choose>