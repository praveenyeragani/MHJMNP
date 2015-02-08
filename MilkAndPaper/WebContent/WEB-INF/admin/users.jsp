<%@include file="../common/header.jsp" %>
<%@include file="navigation.jsp" %>
			<!-- BEGIN PAGE CONTENT-->
			<sf:form class="form-horizontal" action="${pageContext.request.contextPath}/usersType" method="post">
			<div class="form-body">
			<div class="row">
				<div class="col-md-10">
					<!-- BEGIN SAMPLE TABLE PORTLET-->
					<div class="portlet">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-bell-o"></i>Advance Table
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse">
								</a>
								<a href="#portlet-config" data-toggle="modal" class="config">
								</a>
								<a href="javascript:;" class="reload">
								</a>
								<a href="javascript:;" class="remove">
								</a>
							</div>
						</div>
						<div class="form-group">
										<label class="control-label col-md-12">
										<c:url value="newUser" var="newUser"/>
										<a href="${newUser}" class="btn default btn-xs black">
											<i class="fa fa-edit"></i> New User Reg
											
										</a>	
										</label>
										
						</div>
						<div class="form-group">
										<label class="control-label col-md-3">isRegistered/isEnabled
										<span class="required">
											 *
										</span>
										</label>
										<div class="col-md-4">
											<select class="form-control" id="userType" name="userType" onchange="this.form.submit()">
												
												<option value="1" ${usersType == 1 ? 'selected="selected"' : ''}>To be Approved</option>
												<option value="2" ${usersType == 2 ? 'selected="selected"' : ''}>Approved</option>
											</select>
										</div>
						</div>
												
						<div class="portlet-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-advance table-hover">
								<thead>
								<tr>
									<th>
										First Name
									</th>
									<th class="hidden-xs">
										 User Name
									</th>
									<th>
										 Contact No
									</th>
									<th>
										Email
									</th>
									<th>
										Approve status
									</th>
									<th>
										Enable status
									</th>
								</tr>
								</thead>
								<tbody>
								<c:if test="${usersType==1}">
								<c:forEach items="${userList}" var="user">
								<tr>
								<td>
									 <c:out value="${user.firstname}" />
								</td>
								<td>
									 <c:out value="${user.username}" />
								</td>
								<td>
									 <c:out value="${user.phoneno}" />
								</td>
								<td class="center">
									 <c:out value="${user.email}" />
								</td>
								<td class="center">
									 <c:out value="${user.enabled}" />
								</td>
								<td class="center">
									 <c:out value="${user.isApproved}" />
								</td>
								<sf:form></sf:form>
								<td>
										<c:url value="approve" var="approve"/>
										<a href="#" onclick="document.getElementById('${user.id}').submit()" class="btn default btn-xs black">
											<i class="fa fa-edit"></i> approve
											
										</a>
										<sf:form style="visibility: hidden" id="${user.id}" action="${pageContext.request.contextPath}/approve" method="post">
											 <input type="hidden" name="userid" value="${user.id}" />
<!-- 											 <input type="submit" class="btn default btn-xs black" value="Approve" /> -->
										</sf:form>	
								</td>
								<td>
										<c:url value="reject" var="reject"/>
										<a href="#" onclick="document.getElementById('${user.id}reject').submit()" class="btn default btn-xs black">
											<i class="fa fa-edit"></i> reject
										</a>
										<sf:form style="visibility: hidden" id="${user.id}reject" action="${reject}" method="post">
											 <input type="hidden" name="userid" value="${user.id}" />
<!-- 											 <input type="submit" class="btn default btn-xs black" value="Approve" /> -->
										</sf:form>	
								</td>	
								</tr>
								</c:forEach>
								</c:if>
								<c:if test="${usersType==2}">
								<c:forEach items="${userList}" var="user">
								<tr>
								<td>
									 <c:out value="${user.firstname}" />
								</td>
								<td>
									 <c:out value="${user.username}" />
								</td>
								<td>
									 <c:out value="${user.phoneno}" />
								</td>
								<td class="center">
									 <c:out value="${user.email}" />
								</td>
								<td class="center">
									 <c:out value="${user.enabled}" />
								</td>
								<td class="center">
									 <c:out value="${user.isApproved}" />
								</td>
								<sf:form></sf:form>
								<td>
										<c:url value="edit" var="edit"/>
										<a href="#" onclick="document.getElementById('${user.id}edit').submit()" class="btn default btn-xs black">
											<i class="fa fa-edit"></i> edit
											<input type="hidden" name="userid" value="${user.id}" />
										</a>
										<sf:form style="visibility: hidden" id="${user.id}edit" action="${edit}" method="post">
											 <input type="hidden" name="userid" value="${user.id}" />
<!-- 											 <input type="submit" class="btn default btn-xs black" value="Approve" /> -->
										</sf:form>	
								</td>
								<td>
										<c:url value="disable" var="disable"/>
										<a href="#" onclick="document.getElementById('${user.id}disable').submit()"  class="btn default btn-xs black">
											<i class="fa fa-edit"></i> disable
										</a>
										<sf:form style="visibility: hidden" id="${user.id}disable" action="${disable}" method="post">
											 <input type="hidden" name="userid" value="${user.id}" />
<!-- 											 <input type="submit" class="btn default btn-xs black" value="Approve" /> -->
										</sf:form>	
										
								</td>	
								</tr>
								</c:forEach>
								</c:if>
								</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- END SAMPLE TABLE PORTLET-->
				</div>
			</div>
			</div>
			</sf:form>
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
<script src="${pageContext.request.contextPath}/assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<script src="${pageContext.request.contextPath}/assets/scripts/core/app.js"></script>
<script>
jQuery(document).ready(function() {       
   // initiate layout and plugins
   App.init();
});
</script>
</body>
<!-- END BODY -->
</html>
