<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
	integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B"
	crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SkietApp</title>
</head>
<body>
	<div class="container">
		<form:form method="post" modelAttribute="user">
			<div class="form-group">
				<label for="exampleInputPassword2">User Name</label>
				<form:input path="userName" type="text" class="form-control"
					id="exampleInputPassword2" value="${user.getUserName()}"
					placeholder="UserName" />
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label>
				<form:input path="email" type="email" class="form-control"
					id="exampleInputEmail1" value="${user.getEmail()}"
					aria-describedby="emailHelp" placeholder="Enter email" />
				<small id="emailHelp" class="form-text text-muted">We'll
					never share your email with anyone else.</small>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label>
				<form:input path="password" type="password" class="form-control"
					id="exampleInputPassword1" value="${user.getPassword()}"
					placeholder="Password" />
			</div>
			<div class="form-group">
				<label for="exampleInputPassword3">Enabled</label>
				<form:input path="enabled" type="text" class="form-control"
					id="exampleInputPassword3" placeholder="Enabled" />
			</div>
			<form:hidden path="id" value="${user.getId()}" />
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"
		integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em"
		crossorigin="anonymous"></script>
</body>
</html>