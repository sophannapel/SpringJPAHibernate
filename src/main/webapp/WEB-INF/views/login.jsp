<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HR System Login Page</title>
<style type="text/css">
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

</head>

<!-- when the form is loaded, set focus to j_username component -->
<body onload="document.f.j_username.focus();">

	<h3>HR System Custom Login Page</h3>

	<!-- to see if there is an error in response, if it is then display all of it -->
	<!-- error is passed form home controller in login method -->
	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login was unsucessful. <br /> Caused:
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

	<!-- j_username, j_password, j_spring_security_check are the convention that required by spring security framework -->
	<form action="j_spring_security_check" name="f" method="post">
		<p>
			Username: <input type="text" name="j_username" value="" />
		</p>
		<p>
			Password: <input type="password" name="j_password" />
		</p>
		<p>
			<input type="submit" name="Submit" value="Submit" /> <input
				type="reset" name="Reset" value="Reset" />
		</p>
	</form>

</body>
</html>