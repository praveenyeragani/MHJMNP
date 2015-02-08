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
						
																		
						<div class="portlet-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-advance table-hover">
								<thead>
								<tr>
									<th>
										User old details
									</th>
									<th class="hidden-xs">
										 User Request details
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
								
								<c:forEach items="${users}" var="user">
									 
								<tr>
								<td>
									<c:out value="name:${user[0].firstname}" /> &nbsp;
									<c:out value="${user[0].lastname}" /> <br />
									<c:out value="username:${user[0].username}" /> <br />
									<c:out value="block name:${user[0].blockName}" /> <br />
									<c:out value="floorno:${user[0].floorno}" /> <br />
									<c:out value="flotno :${user[0].flotno}" /> <br />
									<c:out value="reqest time :${user[0].updateReqTime}" /> <br />
								
								</td>
								<td>
									
									<c:out value="name:${user[1].firstname}" /> &nbsp;
									<c:out value="${user[1].lastname}" /> <br />
									<c:out value="username:${user[1].username}" /> <br />
									<c:out value="block name:${user[1].blockName}" /> <br />
									<c:out value="floorno:${user[1].floorno}" /> <br />
									<c:out value="flotno :${user[1].flotno}" /> <br />
								
								</td>
									
								</td>
								
								<sf:form></sf:form>
								<td>
										<c:url value="approve" var="approve"/>
										<a href="#" onclick="document.getElementById('${user[0].id}').submit()" class="btn default btn-xs black">
											<i class="fa fa-edit"></i> approve
											
										</a>
										<sf:form style="visibility: hidden" id="${user[0].id}" action="${pageContext.request.contextPath}/approveChangeReq" method="post">
											 <input type="hidden" name="username" value="${user[1].username}" />
											  <input type="hidden" name="updateReqTime" value="${user[0].updateReqTime}" />
<!-- 											 <input type="submit" class="btn default btn-xs black" value="Approve" /> -->
										</sf:form>	
								</td>
								<td>
										<c:url value="reject" var="reject"/>
										<a href="#" onclick="document.getElementById('${user[1].username}reject').submit()" class="btn default btn-xs black">
											<i class="fa fa-edit"></i> reject
										</a>
										<sf:form style="visibility: hidden" id="${user[1].username}reject" action="${reject}" method="post">
											 <input type="hidden" name="username" value="${user[1].username}" />
<!-- 											 <input type="submit" class="btn default btn-xs black" value="Approve" /> -->
										</sf:form>	
								</td>	
								</tr>
								</c:forEach>
								
								
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
