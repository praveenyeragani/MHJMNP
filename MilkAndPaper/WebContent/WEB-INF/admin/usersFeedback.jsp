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
										Name
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
										Feedback Type
									</th>
									<th>
										Description
									</th>
									<th>
										Status
									</th>
								</tr>
								</thead>
								<tbody>
																
								<c:forEach items="${feedbacks}" var="feedback">
								<tr>
								<td>
									 <c:out value="${feedback[0].firstname}" />
								</td>
								<td>
									 <c:out value="${feedback[0].username}" />
								</td>
								<td>
									 <c:out value="${feedback[0].phoneno}" />
								</td>
								<td class="center">
									 <c:out value="${feedback[0].email}" />
								</td>
								<td class="center">
									 <c:out value="${feedback[1].feedbackType}" />
								</td>
								<td class="center">
									 <c:out value="${feedback[1].description}" />
								</td>
								<td class="center">
									 <c:out value="${feedback[1].status}" />
								</td>
								<sf:form></sf:form>
								<td>
										<c:url value="close" var="close"/>
										<a href="#" onclick="document.getElementById('${feedback[0].id}close').submit()" class="btn default btn-xs black">
											<i class="fa fa-edit"></i> close
											<input type="hidden" name="id" value="${feedback[0].id}" />
										</a>
										<sf:form style="visibility: hidden" id="${feedback[0].id}close" action="${close}" method="post">
											 <input type="hidden" name="id" value="${feedback[0].id}" />
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
