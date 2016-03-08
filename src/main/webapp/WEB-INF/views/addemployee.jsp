<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/r/bs-3.3.5/jq-2.1.4,dt-1.10.8/datatables.min.css" />

<script
	src="https://cdn.datatables.net/r/bs-3.3.5/jqc-1.11.3,dt-1.10.8/datatables.min.js"></script>
<script charset="utf-8">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>

<style>
.error {
	color: red;
}
</style>

<title><spring:message code="title" /></title>
</head>
<body>
	<i class="glyphicon glyphicon-flag"><a href="?language=en">English</a>
		|</i>
	<i class="glyphicon glyphicon-flag"><a href="?language=zh">Chinese</a></i>

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<table id="example" class="display" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Age</th>
						</tr>
					</thead>
					<c:forEach items="${employeeList}" var="employee">
						<tr>
							<td>${employee.id}</td>
							<td>${employee.name}</td>
							<td>${employee.age}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<form:form action="addemployee" method="post" commandName="employee"
					role="form">
					<div class="form-group">
						<label for="name"><spring:message code="employee_name" />:</label>
						<form:input path="name" type="text" class="form-control" />
						<form:errors path="name" class="error" />
					</div>

					<div class="form-group">
						<label for="age"><spring:message code="employee_age" />:</label>
						<form:input path="age" type="number" class="form-control" />
						<form:errors path="age" class="error" />
					</div>

					<form:button type="submit" class="btn btn-default">
						<spring:message code="btn_add" />
					</form:button>
				</form:form>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		// For demo to fit into DataTables site builder...
		$('#example').removeClass('display').addClass(
				'table table-striped table-bordered');
	</script>

</body>
</html>