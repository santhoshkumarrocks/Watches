<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
	<div class="row">
		<div class="col-sm-12 col-md-10 col-md-offset-1">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Product</th>
						<th class="text-center">Price</th>
						<th class="text-center">Total</th>
						<th> </th>
						<th></th>
						<th>Quantity</th>
						<th></th>

					</tr>
				</thead>
				<c:forEach items="${protable}" var="ci">

					<tbody>
						<form action="incprod">
							<tr>
								<td class="col-md-6">
									<div class="media">
										<a class="thumbnail pull-left" href="#"> <img
											class="media-object"
											src="resources/productimages/${ci.getProductid()}.jpg"
											style="width: 72px; height: 72px;">
										</a>
										<div class="media-body">
											<h4 class="media-heading">
												<a href="#">${ci.getProductname()}</a>
											</h4>


										</div>
									</div>
								</td>

								<td class="col-md-1 text-center"><strong>Rs.${ci.getPrice()}</strong></td>
								<td class="col-md-1 text-center"><strong>Rs.${ci.getTotal()}</strong></td>
								<td class="col-md-1">
									<button type="button" class="btn btn-danger">
										<a href="delcartprod/${ci.getId() }"> <span
											class="glyphicon glyphicon-remove"></span> Remove 
									</button> &nbsp;
								</td>
								<form action="inccart">
								<td class="col-md-1" style="text-align: center">

									<a href="redcart?getprodid=${ci.getProductid()}"><button type="button" class="btn btn-success">-</button></a>
								</td>
								<td><input type="text" class="form-control" id="quant"
									value="${ci.getQuantity() }" name="quant"></td>
								<td><a href="inccart?getprodid=${ci.getProductid()}"><button type="button" class="btn btn-success">
										+</button></a></td>
								<td></td>
						</form>
						</td>
						</tr>
						</form>
				</c:forEach>
				<tr>
					<td> </td>
					<td> </td>
					<td> </td>
					<td><h3>Total</h3></td>
					<td class="text-right"><h3>
							<strong>Rs.<span>${total}</span></strong>
						</h3></td>
				</tr>
				<tr>
					<td> </td>
					<td> </td>
					<td> </td>
					<td>
						<a href="allpro"><button type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-shopping-cart"></span> Continue
							Shopping
						</button></a>
					</td>
					<td>
						<a href="checkout"><button type="button" class="btn btn-success">
							Checkout <span class="glyphicon glyphicon-play"></span>
						</button></a>
					</td>
					
				</tr>
				</tbody>

			</table>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
