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
<%@ include file="/WEB-INF/fragments/header.jsp" %>
<br>
	<div class="container">
		<div class="container">
			<div class="card text-center">
				<div class="card-header">
					<c:out value="${skieet.getUser().getUserName()}" />
				</div>
				<div class="card-body">
					<h5 class="card-title">
						<c:out value="${skieet.getDate()}" />
					</h5>
					<p class="card-text">
						<c:out value="${skieet.getText()}" />
					</p>
				</div>
				<div class="card-footer text-muted">
					<c:forEach items="${skieet.getComments()}" var="comment">
						<div class="card container" style="width: 18rem;">
							<div class="card-body">
								<h5 class="card-title">
									<c:out value="${comment.getUser().getUserName()}" />
								</h5>
								<h6 class="card-subtitle mb-2 text-muted">
									<c:out value="${comment.getCreated()}" />
								</h6>
								<p class="card-text">
									<c:out value="${comment.getText()}" />
								</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
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