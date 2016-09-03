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
              
        				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box brown-bg">
						<i class="fa fa-credit-card"></i>
						<div class="count">${billno}</div>
						<div class="title">Total Bills</div>						
					</div><!--/.info-box-->			
				</div><!--/.col-->	
				
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box dark-bg">
						<i class="fa fa-thumbs-o-up"></i>
						<div class="count">${billtotal}</div>
						<div class="title">Total Sales(Rs)</div>						
					</div><!--/.info-box-->			
				</div><!--/.col-->
				
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box green-bg">
						<i class="fa fa-cubes"></i>
						<div class="count">1.426</div>
						<div class="title">Total Added Items</div>						
					</div><!--/.info-box-->			
				</div><!--/.col-->
				
			</div><!--/.row-->
          </section>
      </section>
      <!--main content end-->
  </section>
  <!-- container section start -->

  </body>
</html>
