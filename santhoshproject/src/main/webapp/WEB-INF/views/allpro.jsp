<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	<div class="row">
    	<!-- BEGIN PRODUCTS -->
    	<c:forEach items="${protable}" var="ci">
  		<div class="col-md-3 col-sm-6">
    		<span class="thumbnail text-center">
      			<img src="resources/productimages/${ci.getId()}.jpg">
      			<h4 class="text-danger">${ci.getName()}</h4>
      			<p>Rs.${ci.getPrice()}</p>
      			
      			<div class="ratings">
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star-empty"></span>
                </div>
      			<p>Auction End in 5 days</p>
      			<hr class="line">
      			<div class="row">
      				<div class="col-md-6 col-sm-6">
      					<a href="singlepro?id=${ci.getId()}"><button class="btn btn-danger right" >VIEW</button></a>
      				</div>
      				<div class="col-md-6 col-sm-6">
      					<a href="addtocart/${ci.getId()}"><button class="btn btn-danger right" >ADD TO CART</button></a>
      				</div>
      				
      			</div>
    		</span>
  		</div>
  		</c:forEach>
  		
<style>
	.thumbnail:hover{
		opacity:1.00;
		box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
		transition: box-shadow 0.5s;
		
		}
</style>
<br>
<br>
<br>
<br>
<jsp:include page="footer.jsp"></jsp:include>