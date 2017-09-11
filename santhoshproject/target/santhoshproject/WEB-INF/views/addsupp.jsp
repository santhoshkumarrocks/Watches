<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
<script>
	$(document).ready(function() {
		$('#sup_id').dataTable({
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
<div style="margin-bottom: -15pt">
<jsp:include page="header.jsp"></jsp:include>
</div>
<body style="background-color: white";>
<c:if test="${check}">
	<form:form  modelAttribute="supplier" action="getsupplier" method="post"
		class="form-horizontal" style="color:black">
		<fieldset>
			<center>
				<legend>
					<a style="color: black";>ADMIN</a>
				</legend>
			</center>
			<h3>SUPPLIER</h3>
			<br>
			<div class="form-group">
				<label class="col-md-4 control-label" for="add_date">SUPPLIER NAME</label>
				<div class="col-md-4">
					<form:input id="add_date" name="add_date" placeholder="supplier"
						class="form-control input-md" required="true" type="text"
						path="name" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="add_date">ADDRESS</label>
				<div class="col-md-4">
					<form:input id="add_date" name="add_date" placeholder="supplier"
						class="form-control input-md" required="true" type="text"
						path="address" />

				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="add_date">PHONE
					NO</label>
				<div class="col-md-4">
					<form:input id="add_date" name="add_date" placeholder="supplier"
						class="form-control input-md" required="true" type="text"
						path="phonenumber" />

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
	<form:form  modelAttribute="supplier" action="updsupp" method="post"
		class="form-horizontal" style="color:black">
		<fieldset>
			<center>
				<legend>
					<a style="color: black";>ADMIN</a>
				</legend>
			</center>
			<h3>SUPPLIER</h3>
			<br>
			<div class="form-group">
				<label class="col-md-4 control-label" for="add_date"></label>
				<div class="col-md-4">
					<form:input id="add_date" name="add_date" placeholder="supplier"
						class="form-control input-md" required="true" type="hidden"
						path="id" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="add_date">SUPPLIER NAME</label>
				<div class="col-md-4">
					<form:input id="add_date" name="add_date" placeholder="supplier"
						class="form-control input-md" required="true" type="text"
						path="name" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="add_date">ADDRESS</label>
				<div class="col-md-4">
					<form:input id="add_date" name="add_date" placeholder="supplier"
						class="form-control input-md" required="true" type="text"
						path="address" />

				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="add_date">PHONE
					NO</label>
				<div class="col-md-4">
					<form:input id="add_date" name="add_date" placeholder="supplier"
						class="form-control input-md" required="true" type="text"
						path="phonenumber" />

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
			<table id="sup_id" class="table table-bordered">
				<thead>
					<tr>
						<th>SUPPLIER ID</th>
						<th>SUPPLIER NAME</th>
						<th>SUPPLIER ADDRESS</th>
						<th>SUPPLIER PHONE NO</th>
						<th>EDIT/DELETE</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cz}" var="ci">
						<tr>
							<td>${ci.getId()}</td>
							<td>${ci.getName()}</td>
							<td>${ci.getAddress()}</td>
							<td>${ci.getPhonenumber()}</td>
							<td><div>
							<a class="btn icon-btn btn-success"
										href="editsupp?getsuppid=${ci.getId()}"><span
										class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Edit</a>
									<a class="btn icon-btn btn-danger"
										href="delsupp/${ci.getId()}"><span
										class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span>Delete</a>
							</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>