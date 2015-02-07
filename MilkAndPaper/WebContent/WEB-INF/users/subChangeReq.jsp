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
			<sf:form class="form-horizontal" id="form_sample_3" action="${pageContext.request.contextPath}/change">
			<div class="form-body">
			<div class="row">
				<div class="col-md-10">
					<!-- BEGIN SAMPLE TABLE PORTLET-->
					<div class="portlet">
						
															
							<div class="form-group">
								<label class="control-label col-md-3">change/stop
								<span class="required">
									 *
								</span>
								</label>
								<div class="col-md-6">
								
								<select name="changeReqType"  class="form-control">
								   <option value="change">change request</option>
								   <option value="stop">temporary stop request</option>
								</select>
								</div>
															    
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">Milk or Papaer
								<span class="required">
									 *
								</span>
								</label>
								<div class="col-md-6">
								
								<select name="stopReqType"  class="form-control">
								   <option value="milk">Only Milk</option>
								   <option value="paper">Only Paper</option>
								    <option value="milkNpaper">Both Milk and Paper</option>
								</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-3">From
								<span class="required">
									 *
								</span>
								</label>
								<div class="col-md-6">
									<div class="input-group input-medium date date-picker" data-date-format="dd-mm-yyyy" data-date-start-date="+0d">
										<input type="text" class="form-control" name="from" id="from">
										<span class="input-group-btn">
											<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
										</span>
									</div>
									<!-- /input-group -->
									<span class="help-block">
										 Select date
									</span>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-3">To
								<span class="required">
									 *
								</span>
								</label>
								<div class="col-md-6">
									<div class="input-group input-medium date date-picker" data-date-format="dd-mm-yyyy" data-date-start-date="+0d">
										<input type="text" class="form-control" id="to" name="to" >
										<span class="input-group-btn">
											<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
										</span>
									</div>
									<!-- /input-group -->
									<span class="help-block">
										 Select date
									</span>
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