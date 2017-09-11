<!DOCTYPE html>
<html lang="en">

<head>
  <title>Bootstrap Example</title>
  <link rel="shortct icon" href="resources/images/icon.ico">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Alpha Watches</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar" style="float:right">
      <ul class="nav navbar-nav">
        <li class="active"><a href="home">HOME</a></li>
        <li><a href="contactus">CONTACTUS</a></li>
        <li><a href="aboutus">ABOUTUS</a></li>
        <li><a href="addcate">CATEGORY</a></li>
        <li><a href="addsupp">SUPPLIER</a></li>
        <li><a href="addpro">PRODUCT</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
 
        <li><a href="signup"><span class="glyphicon glyphicon-user"></span> SIGNUP</a></li>
        <li><a href=""><span>Welcome</span>$(sessionScope.userName)  !</a></li>
        <c:if test=$(sessionScope.userName!=null)>
        <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> LOGIN</a></li>
        </c:if>
          <c:if test=$(sessionScope.userName==null)>
         <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> logout</a></li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>
  </body>
</html>
