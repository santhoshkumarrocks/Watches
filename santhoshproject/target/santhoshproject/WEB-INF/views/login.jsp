 <style>
body {
    background-image: url("data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSI1IiBoZWlnaHQ9IjUiPgo8cmVjdCB3aWR0aD0iNSIgaGVpZ2h0PSI1IiBmaWxsPSIjZmZmIj48L3JlY3Q+CjxyZWN0IHdpZHRoPSIxIiBoZWlnaHQ9IjEiIGZpbGw9IiNjY2MiPjwvcmVjdD4KPC9zdmc+");
}

.box-shadow {
	-webkit-box-shadow: 0px 10px 20px 0px rgba(50, 50, 50, 0.52);
	-moz-box-shadow:    0px 10px 20px 0px rgba(50, 50, 50, 0.52);
	box-shadow:         0px 10px 20px 0px rgba(50, 50, 50, 0.52)
}
  </style>
  <body>
  <jsp:include page="header.jsp"></jsp:include>
  	<div class="container">
      <div class="row">
        <div class="col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3 col-md-5 col-md-offset-4 col-lg-4 col-lg-offset-4">

          <h3>LOGIN</h3>
          
          <div class="panel panel-default box-shadow">
            <div class="panel-heading">
              <span class="text-primary">Authentication</span>
              <span class="text-muted pull-right today" title="Today"></span>              
            </div><!--.panel-heading-->

            <div class="panel-body">
              <form action="signin">

                <div class="form-group">
                  <label for="email">Email</label>
                  <div class="input-group">
                    <div class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></div>
                    <input autofocus required type="email" id="usename" class="form-control" placeholder="Your email" tabindex="1" name="userpassword">
                  </div>
                </div>

                <div class="form-group">
                  <label for="password">Password</label>
                  <a href="#forget-password" class="btn btn-xs btn-link" tabindex="4">Forget password?</a>
                  <div class="input-group">
                    <div class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></div>
                    <input required type="password" class="form-control" placeholder="Your password" tabindex="2" id="usename" name="userpassword">
                  </div>
                </div>
                
                <div class="checkbox">
                    <label><input type="checkbox"> Remember me</label>
                </div>

                <button type="submit" class="btn btn-block btn-primary" tabindex="3"></a>SUBMIT</button>
                <p class="text-center text-muted h4">
                  or
                </p>
                <a href="signup" class="btn btn-block btn-success" tabindex="5">Create account</a>
              </form>
            </div>
          </div><!--.panel-->
        </div><!--.cols-->
      </div><!--.row-->
    </div><!--.container-->
  </body>
  <jsp:include page="footer.jsp"></jsp:include>