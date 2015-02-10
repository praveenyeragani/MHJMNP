<%@include file="../common/header.jsp" %>
<%@include file="../common/navigation.jsp" %>
			<!-- BEGIN PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
					User Information <small>Subscription </small>
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="index.html">
								Home
							</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="#">
								User Information
							</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="#">
								Subscription
							</a>
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
			<sf:form class="form-horizontal" action="${pageContext.request.contextPath}/feedbackSubmit" method="post" id="form_sample_3">
			<div class="form-body">
			<div class="row">
				<div class="col-md-10">
					<!-- BEGIN SAMPLE TABLE PORTLET-->
					<div class="portlet">
						
															
							<div class="form-group">
								<label class="control-label col-md-3">Feedback/Complaint
								<span class="required">
									 *
								</span>
								</label>
								<div class="col-md-6">
								
								<select name="feedbackType"  class="form-control">
								   <option value="feedback">feedback</option>
								   <option value="complaint">complaint</option>
								</select>
								</div>
															    
							</div>
											
							<div class="form-group">
								<label class="control-label col-md-3">Description
								<span class="required">
									 *
								</span>
								</label>
								<div class="col-md-6">
									<textarea name="description" data-required="1" class="form-control" rows="5"></textarea>
									
								</div>
							</div>
						</div>
						
						<div class="form-actions fluid">
									<div class="col-md-offset-3 col-md-9">
										<button type="submit" class="btn green">Submit</button>
										<button type="button" class="btn default">Cancel</button>
									</div>
						</div>
						</div>
					<!-- END SAMPLE TABLE PORTLET-->
				</div>
			</div>
			</div>
			</sf:form>
					
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<%@include file="../common/footer.jsp" %>