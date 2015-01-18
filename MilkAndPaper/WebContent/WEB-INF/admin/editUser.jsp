<%@include file="../common/header.jsp" %>
<%@include file="../common/navigation.jsp" %>
			<!-- BEGIN PAGE CONTENT-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN VALIDATION STATES-->
					<div class="portlet box green">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-reorder"></i>Order Invoice
							</div>
							
						</div>
						<div class="portlet-body form">
							<!-- BEGIN FORM-->
							<form action="invoice" id="form_sample_3" class="form-horizontal">
								<div class="form-body">
									
									<div class="alert alert-danger display-hide">
										<button class="close" data-close="alert"></button>
										You have some form errors. Please check below.
									</div>
									<div class="alert alert-success display-hide">
										<button class="close" data-close="alert"></button>
										Your form validation is successful!
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">First Name
										<span class="required">
											 *
										</span>
										</label>
										<div class="col-md-4">
											<input type="text" name="firstname" data-required="1" class="form-control" value="${user.firstname}"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">Email
										<span class="required">
											 *
										</span>
										</label>
										<div class="col-md-4">
											<input type="text" id="name" name="email" data-required="1" class="form-control" value="${user.email}"/>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-md-3">Phone No
										<span class="required">
											 *
										</span>
										</label>
										<div class="col-md-4">
											<input type="text" id="city" name="phoneno" data-required="1" class="form-control"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">Block name
										<span class="required">
											 *
										</span>
										</label>
										<div class="col-md-4">
										<select  id="block" class="select2 form-control" name="blockno">
											<option value=""></option>
											<option value="1">PEARL</option>
											<option value="2">2</option>
											
										</select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-md-3">Floor no
										<span class="required">
											 *
										</span>
										</label>
										<div class="col-md-4">
											<select  id="floor" class="select2 form-control" name="floorno">
											<option value=""></option>
											<option value="01">01</option>
											<option value="02">02</option>
											<option value="03">03</option>
											<option value="04">04</option>
											<option value="05">05</option>
											<option value="06">06</option>
											<option value="07">07</option>
											<option value="08">08</option>
											<option value="09">09</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
											<option value="13">13</option>
											<option value="14">14</option>
											
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">Username
										<span class="required">
											 *
										</span>
										</label>
										<div class="col-md-4">
											<input type="text" id="user.name"  name="user.name" data-required="1" class="form-control" value="${user.username}" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-md-3">Password
										<span class="required">
											 *
										</span>
										</label>
										<div class="col-md-4">
											<input type="text" name="password" data-required="1" class="form-control" value="${user.password}" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">Approve Status
										<span class="required">
											 *
										</span>
										</label>
										<div class="col-md-4">
											<select  class="form-control" name="isApproved">
												<option value="">Select...</option>
												<option value="0" ${user.isApproved=='false'?'selected="selected"' : ''}>false</option>
												<option value="1" ${user.isApproved=='true'?'selected="selected"' : ''}>true</option>
										        
										    <select>
											
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">Enable Status
										<span class="required">
											 *
										</span>
										</label>
										<div class="col-md-4">
											<select  class="form-control" name="enabled">
												<option value="">Select...</option>
												<option value="0" ${user.enabled=='false'?'selected="selected"' : ''}>false</option>
												<option value="1" ${user.enabled=='true'?'selected="selected"' : ''}>true</option>
										        
										    <select>
											
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">User Role
										<span class="required">
											 *
										</span>
										</label>
										<div class="col-md-4">
											<sf:select  path="userRole.role" class="form-control">
												<option value="">Select...</option>
												<sf:options items="${userRoles}" itemValue="1"  itemLabel="1" ></sf:options>
										    </sf:select>
										    <%-- <sf:select path="name" items="${categorylist}" ></sf:select> --%>
										</div>
									</div>					
								
								</div>
								<div class="form-actions fluid">
									<div class="col-md-offset-3 col-md-9">
										<button type="submit" class="btn green">Submit</button>
										<button type="button" class="btn default">Cancel</button>
									</div>
								</div>
							</form>
							<!-- END FORM-->
						</div>
						<!-- END VALIDATION STATES-->
					</div>
				</div>
			</div>
			<!-- END PAGE CONTENT-->
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<div class="footer">
	<div class="footer-inner">
		 2014 &copy; Metronic by keenthemes.
	</div>
	<div class="footer-tools">
		<span class="go-top">
			<i class="fa fa-angle-up"></i>
		</span>
	</div>
</div>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="assets/plugins/respond.min.js"></script>
<script src="assets/plugins/excanvas.min.js"></script> 
<![endif]-->
<script src="assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="assets/plugins/jquery-validation/dist/jquery.validate.min.js"></script>
<script type="text/javascript" src="assets/plugins/jquery-validation/dist/additional-methods.min.js"></script>
<script type="text/javascript" src="assets/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="assets/plugins/bootstrap-wysihtml5/wysihtml5-0.3.0.js"></script>
<script type="text/javascript" src="assets/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.js"></script>
<script type="text/javascript" src="assets/plugins/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="assets/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script type="text/javascript" src="assets/plugins/bootstrap-markdown/lib/markdown.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL STYLES -->
<script src="assets/scripts/core/app.js"></script>
<script src="assets/scripts/custom/form-validation.js"></script>
<!-- END PAGE LEVEL STYLES -->
<script>
jQuery(document).ready(function() {   
   // initiate layout and plugins
   App.init();
   FormValidation.init();
});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>