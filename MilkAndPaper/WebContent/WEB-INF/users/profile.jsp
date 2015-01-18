
<%@include file="../common/header.jsp" %>
<%@include file="../common/navigation.jsp" %>
	<!-- BEGIN PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
					User Information <small>profile </small>
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
								User information
							</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="#">
								profile
							</a>
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
			<div class="row profile">
				<div class="col-md-12">
					<!--BEGIN TABS-->
					<div class="tabbable tabbable-custom tabbable-full-width">
						<ul class="nav nav-tabs">
							
							<li class="active">
								<a href="#tab_1_3" data-toggle="tab">
									 Account
								</a>
							</li>
							
						</ul>
						<div class="tab-content">
							<!--tab_1_2-->
							<div class="tab-pane active" id="tab_1_3">
								<div class="row profile-account">
									<div class="col-md-3">
									
										<ul class="ver-inline-menu tabbable margin-bottom-10">
											<li class="${profileActive}">
												<a data-toggle="tab" href="#tab_1-1">
													<i class="fa fa-cog"></i> Personal info
												</a>
												<span class="after">
												</span>
											</li>
											<li class="${passwordActive}">
												<a data-toggle="tab" href="#tab_3-3">
													<i class="fa fa-lock"></i> Change Password
												</a>
											</li>
											
										</ul>
									</div>
									<div class="alert alert-danger display-hide">
										<button class="close" data-close="alert"></button>
										You have some form errors. Please check below.
									</div>
									<%if((String)request.getAttribute("message")!=null){ %>
									<div class="alert alert-success ">
										<button class="close" data-close="alert"></button>
										${message}
									</div>
									<%} %>
									<div class="col-md-9">
										<div class="tab-content">
											<div id="tab_1-1" class="tab-pane ${profileActive}">
												<sf:form role="form"  action="${pageContext.request.contextPath}/updateUserProfile" method="post" >
													<div class="form-group">
														<label class="control-label">First Name</label>
														<input type="text" name="firstname" value="${user.firstname}" class="form-control"/>
													</div>
													<div class="form-group">
														<label class="control-label">Last Name</label>
														<input type="text" name="lastname" value="${user.lastname}" class="form-control"/>
													</div>
													<div class="form-group">
														<label class="control-label">Mobile Number</label>
														<input type="text" name="phoneno" value="${user.phoneno}" class="form-control"/>
													</div>
													
													<div class="form-group">
														<label class="control-label">Email</label>
														<input type="text" name="email" value="${user.email}" class="form-control"/>
													</div>
													<div class="form-group">
														<label class="control-label">Block no</label>
														
														<select name="blockname" class="form-control">
														         <c:forEach items="${blockNames}" var="blockName" varStatus="loop">
																      <option value=${blockName} ${blockName==user.blockname? 'selected="selected"' : ''} >${blockName}</option>
																 </c:forEach>
													   													   
														</select>
													</div>
													<div class="form-group">
														<label class="control-label">Floor Number</label>
														<select name="floorno" class="form-control">
														         <c:forEach items="${floorNos}" var="floorNo" varStatus="loop">
																      <option value=${floorNo}  ${floorNo ==user.floorno  ? 'selected="selected"' : ''}>${floorNo}</option>
																 </c:forEach>
													   													   
														</select>
													</div>
													
													<div class="form-group">
														<label class="control-label">Flot Number</label>
														<select name="flotno" class="form-control">
														         <c:forEach items="${flotNos}" var="flotNo" varStatus="loop">
																      <option value=${flotNo}  ${flotNo==user.flotno? 'selected="selected"' : ''}>${flotNo}</option>
																 </c:forEach>
													   	</select>
													</div>
													
													<div class="form-actions fluid">
															<div class="col-md-offset-3 col-md-9">
																<button type="submit" class="btn green">Save Changes</button>
																<button type="button" class="btn default">Cancel</button>
															</div>
													</div>
												</sf:form>
											</div>
											<div id="tab_3-3" class="tab-pane ${passwordActive}" >
												<sf:form id="changePassword" action="${pageContext.request.contextPath}/changePassword" method="post">
													<div class="form-group">
														<label class="control-label">Current Password</label>
														<input type="password" name="currentPassword" class="form-control"/>
													</div>
													<div class="form-group">
														<label class="control-label">New Password</label>
														<input type="password" name="newPassword" class="form-control"/>
													</div>
													<div class="form-group">
														<label class="control-label">Re-type New Password</label>
														<input type="password" class="form-control"/>
													</div>
													<div class="margin-top-10">
														<a href="#" onclick="document.getElementById('changePassword').submit()"   class="btn green">
															 Change Password
														</a>
														<a href="#" class="btn default">
															 Cancel
														</a>
													</div>
												</sf:form>
											</div>
										</div>
									</div>
									<!--end col-md-9-->
								</div>
							</div>
							<!--end tab-pane-->
							
						</div>
					</div>
					<!--END TABS-->
				</div>
			</div>
			<!-- END PAGE CONTENT-->
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<%@include file="../common/footer.jsp" %>