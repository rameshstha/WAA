<%@ include file="/WEB-INF/views/template/header.jsp"%>
  <!-- Bootstrap CSS -->    
    <link href="../resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="../resources/css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="../resources/css/elegant-icons-style.css" rel="stylesheet" />
    <link href="../resources/css/font-awesome.min.css" rel="stylesheet" />    
    <!-- Custom styles -->
	
    <link href="../resources/css/style.css" rel="stylesheet">
    <link href="../resources/css/style-responsive.css" rel="stylesheet" />
	<link href="../resources/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
      <script src="../resources/js/html5shiv.js"></script>
      <script src="../resources/js/respond.min.js"></script>
      <script src="../resources/js/lte-ie7.js"></script>
    <![endif]-->
  <!-- container section start -->
  <section id="container" class="">
     
     <!--main content start-->
      <section id="main-content">
          <section class="wrapper">            
              <!--overview start-->
			  <div class="row">
				<div class="col-lg-12">
					<h3 class="page-header"><i class="fa fa-laptop"></i> Welcome!!</h3>
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
				<a href="../user/bill">
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box green-bg">
						<i class="fa fa-cubes"></i>
						<div class="count"></div>
						<div class="title">Add Bills</div>						
					</div><!--/.info-box-->			
				</div><!--/.col-->
				</a>
			</div><!--/.row-->
          </section>
      </section>
      <!--main content end-->
  </section>
  <!-- container section start -->

   <%@ include file="/WEB-INF/views/template/footer.jsp"%>
