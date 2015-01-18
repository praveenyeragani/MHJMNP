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
			<sf:form class="form-horizontal" action="${pageContext.request.contextPath}/insertSubscription" method="post" commandName="subscription">
			<div class="form-body">
			<div class="row">
				<div class="col-md-10">
					<!-- BEGIN SAMPLE TABLE PORTLET-->
					<div class="portlet">
						
						
						<div class="form-group">
										<label class="control-label col-md-3">Milk/Paper
										<span class="required">
											 *
										</span>
										</label>
										<div class="col-md-4">
											<select class="form-control" id="SubscriptionType" name="SubscriptionType" onchange="this.form.submit()">
												
												<option value="1" ${SubscriptionType == 1 ? 'selected="selected"' : ''}>Milk</option>
												<option value="2" ${SubscriptionType == 2 ? 'selected="selected"' : ''}>Paper</option>
											</select>
										</div>
						</div>
						
						<div class="form-group">
										<label class="control-label col-md-3">Milk
										<span class="required">
											 *
										</span>
										</label>
										<div class="col-md-4">
										
										<select name="milksub.milkname" class="form-control">
										
										    <c:forEach items="${milkList}" var="item" varStatus="loop">
										        <option value=${loop.index}>${item}</option>
										    </c:forEach>
										</select>
<%-- 											<sf:select path="${milk.name}"  class="form-control"> --%>
<!-- 												<option value="">Select...</option> -->
<%-- 												<sf:options items="${milkList}" ></sf:options> --%>
<%-- 										    </sf:select> --%>
										    <%-- <sf:select path="name" items="${categorylist}" ></sf:select> --%>
										</div>
						</div>
						
						
						<div class="form-group">
										<label class="control-label col-md-3">quantity
										<span class="required">
											 *
										</span>
										</label>
										<div class="col-md-4">
											<input type="text" name="milksub.quantity" data-required="1" class="form-control"/>
										</div>
						</div>
					
						
						<div class="form-group">
										<label class="control-label col-md-3">Paper
										<span class="required">
											 *
										</span>
										</label>
										<div class="col-md-4">
										
										<select name="papersub.papername"  class="form-control">
										
										    <c:forEach items="${paperList}" var="item" varStatus="loop">
										        <option value=${loop.index}>${paperList[loop.index]}</option>
										    </c:forEach>
										</select>
<%-- 											<sf:select path="${milk.name}"  class="form-control"> --%>
<!-- 												<option value="">Select...</option> -->
<%-- 												<sf:options items="${milkList}" ></sf:options> --%>
<%-- 										    </sf:select> --%>
										    
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
			<!-- END PAGE CONTENT-->
						<div class="portlet">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-bell-o"></i>Subscription Details
							</div>
							
						</div>
						</div>
						<div class="portlet-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-advance table-hover">
								<thead>
								<tr>
									<th>
										User Name
									</th>
									<th class="hidden-xs">
										 Milk Name detials
									</th>
									<th>
										Paper name
									</th>
									
								</tr>
								</thead>
								<tbody>
								
								
								<tr>
								<td>
									 <c:out value="${username}" />
								</td>
								<td>
									<c:forEach items="${milksub}" var="milk">
									 <c:out value="${milkList[milk.milkname]} - ${milk.quantity}" /> <br />
									 </c:forEach>
								</td>
								<td>
									<c:forEach items="${papersub}" var="paper">
									 <c:out value="${paperList[paper.papername]}" /><br />
									 </c:forEach>
								</td>
								
								<sf:form></sf:form>
<!-- 								<td> -->
<%-- 										<c:url value="approve" var="approve"/> --%>
<%-- 										<a href="#" onclick="document.getElementById('${user.id}').submit()" class="btn default btn-xs black"> --%>
<!-- 											<i class="fa fa-edit"></i> approve -->
											
<!-- 										</a> -->
<%-- 										<sf:form style="visibility: hidden" id="${user.id}" action="${pageContext.request.contextPath}/approve" method="post"> --%>
<%-- 											 <input type="hidden" name="userid" value="${user.id}" /> --%>
<!-- 											 <input type="submit" class="btn default btn-xs black" value="Approve" /> -->
<%-- 										</sf:form>	 --%>
<!-- 								</td> -->
<!-- 								<td> -->
<%-- 										<c:url value="reject" var="reject"/> --%>
<%-- 										<a href="#" onclick="document.getElementById('${user.id}reject').submit()" class="btn default btn-xs black"> --%>
<!-- 											<i class="fa fa-edit"></i> reject -->
<!-- 										</a> -->
<%-- 										<sf:form style="visibility: hidden" id="${user.id}reject" action="${reject}" method="post"> --%>
<%-- 											 <input type="hidden" name="userid" value="${user.id}" /> --%>
<!-- 											 <input type="submit" class="btn default btn-xs black" value="Approve" /> -->
<%-- 										</sf:form>	 --%>
<!-- 								</td>	 -->
								</tr>
								
								</tbody>
								</table>
							</div>
						</div>
					
						
						 						
					
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<%@include file="../common/footer.jsp" %>