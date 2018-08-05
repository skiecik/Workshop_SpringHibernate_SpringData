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
	<%@ include file="/WEB-INF/fragments/header.jsp"%>
	<br>
	<div class="container">
		<div class="row">
			<div class="container col-lg-4 col-md-4">
				<form:form method="post" modelAttribute="skieet"
					action="start/add/skieet">
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Add skieet</label>
						<form:textarea path="text" class="form-control"
							id="exampleFormControlTextarea1" rows="3" />
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form:form>
			</div>
		</div>
		<div class="container align-items-center">
			<c:forEach items="${skieets}" var="skieet">
				<div class="card container border-primary" style="width: 22rem;">
					<div class="row">
						<div class="card-body">
							<h5 class="card-title">
								<a class="btn btn-secondary"
									href="user/${skieet.getUser().getId() }" role="button"> <c:out
										value="${skieet.getUser().getUserName()}" />
								</a>
							</h5>
							<h6 class="card-subtitle mb-2 text-muted">
								<c:out value="${skieet.getDate()}" />
							</h6>
							<p class="card-text">
								<c:out value="${skieet.getText()}" />
							</p>
							<a href="skieet/${skieet.getId()}"
								class="btn btn-success card-link">Details</a>
							<button type="button"
								class="btn btn-outline-info btn-sm card-link"
								data-toggle="collapse"
								data-target="#addComment${skieet.getId()}">Add comment</button>
						</div>
						<div class="container collapse" id="addComment${skieet.getId()}">
							<form id="commentForm" method="post" action="start/add/comment">
								<div class="form-group">
									<label for="message-text" class="col-form-label">Message:</label>
									<textarea name="commentText" class="form-control"
										id="message-text"></textarea>
								</div>
								<div class="form-group">
									<input type="hidden" name="commentSkieetId"
										value="${skieet.getId()}">
								</div>
							</form>
						</div>
						<!-- 						<button type="button" class="btn btn-primary card-link" -->
						<%-- 							data-toggle="modal" data-target="#commentModal${skieet.getId()}">Add --%>
						<!-- 							Comment</button> -->
						<%-- 						<div class="modal fade" id="commentModal${skieet.getId()}" --%>
						<!-- 							tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" -->
						<!-- 							aria-hidden="true"> -->
						<!-- 							<div class="modal-dialog" role="document"> -->
						<!-- 								<div class="modal-content"> -->
						<!-- 									<div class="modal-header"> -->
						<!-- 										<h5 class="modal-title" id="exampleModalLabel">Modal -->
						<!-- 											title</h5> -->
						<!-- 										<button type="button" class="close" data-dismiss="modal" -->
						<!-- 											aria-label="Close"> -->
						<!-- 											<span aria-hidden="true">&times;</span> -->
						<!-- 										</button> -->
						<!-- 									</div> -->
						<!-- 									<div class="modal-body"> -->
						<%-- 										<form id="commentForm" method="post" --%>
						<%-- 											action="start/add/comment"> --%>
						<!-- 											<div class="form-group"> -->
						<!-- 												<label for="message-text" class="col-form-label">Message:</label> -->
						<!-- 												<textarea name="commentText" class="form-control" -->
						<!-- 													id="message-text"></textarea> -->
						<!-- 											</div> -->
						<!-- 											<div class="form-group"> -->
						<!-- 												<input type="hidden" name="commentSkieetId" -->
						<%-- 													value="${skieet.getId()}"> --%>
						<!-- 											</div> -->
						<%-- 										</form> --%>
						<!-- 									</div> -->
						<!-- 									<div class="modal-footer"> -->
						<!-- 										<button type="button" class="btn btn-secondary" -->
						<!-- 											data-dismiss="modal">Close</button> -->
						<!-- 										<button type="submit" form="commentForm" -->
						<!-- 											class="btn btn-primary">Submit</button> -->
						<!-- 									</div> -->
						<!-- 								</div> -->
						<!-- 							</div> -->
						<!-- 						</div> -->
						<button type="button"
							class="btn btn-outline-info btn-sm card-link"
							data-toggle="collapse" data-target="#commentDiv${skieet.getId()}">Show
							comments</button>
					</div>
					<div class="card-footer text-muted collapse"
						id="commentDiv${skieet.getId()}">
						<c:forEach items="${skieet.fiveNewestComments()}" var="comment">
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
			</c:forEach>
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