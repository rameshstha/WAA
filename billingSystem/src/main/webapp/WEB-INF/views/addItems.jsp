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
					<h3 class="page-header"><i class="fa fa-laptop"></i> Dashboard</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="../user/default">Home</a></li>
						<li><i class="fa fa-laptop"></i>Dashboard</li>						  	
					</ol>
				</div>
			</div>
              <div class="container">
		     <f:form class="form-horizontal" commandName="additems" action="../admin/addItem" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Add Items</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="itemName">Item Name</label>  
					<div class="col-md-4">
						<input id="itemName" path="itemName" name="itemName" type="text" placeholder="" class="form-control input-md" />

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="unitPrice">Unit Price</label>  
					<div class="col-md-4">
						<input id="unitPrice" path="unitPrice" name="unitPrice" type="text"  class="form-control input-md"  />
					</div>
				</div>

				
				<!-- Register Button -->
				<div class="form-group">
				<label class="col-md-4 control-label"></label>
					<div class="col-md-8">
						<f:button id="addItems" class="btn btn-success">Add Item</f:button>
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
