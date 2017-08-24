<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
<script>
	$(document).ready(function() {
		$('#cat_id').dataTable({
			"pagingType" : "full_numbers",
			"lengthMenu" : [ [ 2, 5, 10, -1 ], [ 2, 5, 10, "All" ] ]
		});
	}); 
</script>
<style>
.btn-glyphicon {
	padding: 8px;
	background: #ffffff;
	margin-right: 4px;
}

.icon-btn {
	padding: 1px 15px 3px 2px;
	border-radius: 50px;
}
</style>
<jsp:include page="header.jsp"></jsp:include>
<body style="background-color: white";>
<c:if test="${check}">
	<form:form modelAttribute="category" action="getcategory" method="post"
		class="form-horizontal" style="color:black">
		<fieldset>
			<center>
				<legend>
					<a style="color: black";>ADMIN</a>
				</legend>
			</center>
			<h3>CATEGORY</h3>
			<br>
			<div class="form-group">
				<label class="col-md-4 control-label">CATEGORY NAME</label>
				<div class="col-md-4">
					<form:input id="add_date" name="add_date" placeholder="category"
						class="form-control input-md" required="true" type="text"
						path="name" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label">DESCRIPTION</label>
				<div class="col-md-4">
					<form:input id="add_date" name="add_date" placeholder="category"
						class="form-control input-md" required="true" type="text"
						path="description" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for=""></label>
				<div class="col-md-4">
					<button id="" name="" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</fieldset>
	</form:form>
	</c:if>
	<c:if test="${!check}">
	<form:form modelAttribute="category" action="updcat" method="post"
		class="form-horizontal" style="color:black">
		<fieldset>
			<center>
				<legend>
					<a style="color: black";>ADMIN</a>
				</legend>
			</center>
			<h3>CATEGORY</h3>
			<br>
			<div class="form-group">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-4">
					<form:input id="add_date" name="add_date" placeholder="category"
						class="form-control input-md" required="true" type="hidden"
						path="id" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label">CATEGORY NAME</label>
				<div class="col-md-4">
					<form:input id="add_date" name="add_date" placeholder="category"
						class="form-control input-md" required="true" type="text"
						path="name" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label">DESCRIPTION</label>
				<div class="col-md-4">
					<form:input id="add_date" name="add_date" placeholder="category"
						class="form-control input-md" required="true" type="text"
						path="description" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for=""></label>
				<div class="col-md-4">
					<button id="" name="" class="btn btn-primary">Update</button>
				</div>
			</div>
		</fieldset>
	</form:form>
	</c:if>
	<div>
		<div class="container">
			<h2>Table</h2>
			<table id="cat_id" class="table table-bordered">
				<thead>
					<tr>
						<th>CATEGORY ID</th>
						<th>CATEGORY NAME</th>
						<th>CATEGORY DESCRIPTION</th>
						<th>EDIT/DELETE</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cg}" var="ci">
						<tr>
							<td>${ci.getId()}</td>
							<td>${ci.getName()}</td>
							<td>${ci.getDescription()}</td>
							<td><div>
									<a class="btn icon-btn btn-success"
										href="editcat?getcatid=${ci.getId()}"><span
										class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Edit</a>
									<a class="btn icon-btn btn-danger"
										href="delcat/${ci.getId()}"><span
										class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span>Delete</a>
								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
	<br>
	<br>
	<br>	
<jsp:include page="footer.jsp"></jsp:include>
