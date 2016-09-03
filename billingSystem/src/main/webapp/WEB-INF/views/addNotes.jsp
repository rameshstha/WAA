<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/adminHead.jsp"%>
<!-- container section start -->
<section id="container" class="">
	<%@ include file="/WEB-INF/views/template/adminHeader.jsp"%>
	<!--header end-->

	<!--sidebar start-->
	<%@ include file="/WEB-INF/views/template/adminNav.jsp"%>
	<!--sidebar end-->

	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">
			<!--overview start-->
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">
						<i class="fa fa-laptop"></i> Dashboard
					</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="../user/default">Home</a></li>
						<li><i class="fa fa-laptop"></i>Dashboard</li>
					</ol>
				</div>
			</div>
			<div class="container">
				<f:form class="form-horizontal" action="../admin/addNote"
					ModelAttribute="notes" method="post">
					<fieldset>

						<!-- Form Name -->
						<legend>Add Note</legend>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-2 control-label" for="username">Notes</label>
							<div class="col-md-8">
								<textarea name="note" id="note" placeholder=""
									class="form-control input-md" value=" " rows="5" cols="15"></textarea>
							</div>
						</div>
						<!-- Register Button -->
						<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-8">
								<button id="addNotes" class="btn btn-success">Add Note</button>
							</div>
						</div>
					</fieldset>
				</f:form>

			</div>
		</section>
	</section>
	<!--main content end-->
</section>
<!-- container section start -->

</body>
</html>
