
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="contact-us">
		<div class="container">
			<div class="contact-form">
				<div class="row">
					<div class="col-sm-7">
						<form id="ajax-contact" method="post"
							action="contact-form-mail.php" role="form">
							<div class="messages" id="form-messages"></div>
							<div class="controls">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="form_name">Firstname </label> <input
												id="form_name" type="text" name="name" class="form-control"
												placeholder="Please enter your firstname "
												required="required" data-error="Firstname is required.">
											<div class="help-block with-errors"></div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="form_lastname">Lastname </label> <input
												id="form_lastname" type="text" name="surname"
												class="form-control"
												placeholder="Please enter your lastname "
												required="required" data-error="Lastname is required.">
											<div class="help-block with-errors"></div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="form_email">Email </label> <input
												id="form_email" type="email" name="email"
												class="form-control" placeholder="Please enter your email "
												required="required" data-error="Valid email is required.">
											<div class="help-block with-errors"></div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="form_phone">Phone</label> <input id="form_phone"
												type="tel" name="phone" class="form-control"
												placeholder="Please enter your phone" required
												oninvalid="setCustomValidity('Plz enter your correct phone number ')"
												onchange="try{setCustomValidity('')}catch(e){}">

										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label for="form_message">Message </label>
											<textarea id="form_message" name="message"
												class="form-control" placeholder="Message for me " rows="4"
												required="required" data-error="Please,leave us a message."></textarea>
											<div class="help-block with-errors"></div>
										</div>
									</div>
									<div class="col-md-12">
										<input type="submit" class="btn btn-black"
											value="Send message">
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<br> <small class="text-muted"><strong>*</strong>
											These fields are required.</small>
									</div>
								</div>
							</div>

						</form>

					</div>
					<div class="col-sm-5">
						<div class="row col1">
							<div class="col-xs-3">
								<i class="fa fa-map-marker" style="font-size: 16px;"></i>  
								Address
							</div>
							<div class="col-xs-9">
								3/326, Velayuthampalayam(po), Avinashi 641654,<br> Tirupur
								, Tamilnadu
							</div>
						</div>
						<br>
						<div class="row col1">
							<div class="col-sm-3">
								<i class="fa fa-phone"></i>   Phone
							</div>
							<div class="col-sm-9">+(91) 9788646410</div>
						</div>
						<div class="row col1">
							<div class="col-sm-3">
								<i class="fa fa-phone"></i>   Phone
							</div>
							<div class="col-sm-9">+(91) 9843124251</div>
						</div>
						<br>
						<div class="row col1">
							<div class="col-sm-3">
								<i class="fa fa-envelope"></i>   Email
							</div>
							<div class="col-sm-9">
								<a href="mailto:santhoshsaravanansp@gmail.com">santhoshsaravanansp@gmail.com</a>
								<br> <a href="mailto:saravanan_1965@rediffmail.com.com">saravanan_1965@rediffmail.com</a>
							</div>
						</div>
						<br>
						<iframe width="100%" height="280" frameborder="0"
							style="border-radius: 0px;" scrolling="no" marginheight="0"
							marginwidth="0"
							src="https://www.mapsdirections.info/en/custom-google-maps/map.php?width=100%&height=600&hl=ru&q=NIIT%2Cganthipuram%2Ccoimbatore+(NIIT)&ie=UTF8&t=&z=18&iwloc=A&output=embed"
							frameborder="0" scrolling="no" marginheight="0" marginwidth="0">
							<a href="https://www.mapsdirections.info/en/custom-google-maps/">Create
								a custom Google Map</a> by <a
								href="https://www.mapsdirections.info/en/">UK Maps</a>
						</iframe>
					</div>
				</div>

			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>