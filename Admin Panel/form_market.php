<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="description" content="Neon Admin Panel" />
	<meta name="author" content="" />
	
	<title>Neon | Advanced Plugins</title>
	

	<link rel="stylesheet" href="assets/js/jquery-ui/css/no-theme/jquery-ui-1.10.3.custom.min.css">
	<link rel="stylesheet" href="assets/css/font-icons/entypo/css/entypo.css">
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Noto+Sans:400,700,400italic">
	<link rel="stylesheet" href="assets/css/bootstrap.css">
	<link rel="stylesheet" href="assets/css/neon-core.css">
	<link rel="stylesheet" href="assets/css/neon-theme.css">
	<link rel="stylesheet" href="assets/css/neon-forms.css">
	<link rel="stylesheet" href="assets/css/custom.css">

	<script src="assets/js/jquery-1.11.0.min.js"></script>

	<!--[if lt IE 9]><script src="assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	
</head>
<body class="page-body" data-url="http://neon.dev">

<div class="page-container"><!-- add class "sidebar-collapsed" to close sidebar by default, "chat-visible" to make chat appear always -->	
	
	<div class="sidebar-menu">
		
			
		<header class="logo-env">
			
			<!-- logo -->
			<div class="logo">
				<a href="index.html">
					<img src="assets/images/logo@2x.png" width="120" alt="" />
				</a>
			</div>
			
						<!-- logo collapse icon -->
						
			<div class="sidebar-collapse">
				<a href="#" class="sidebar-collapse-icon with-animation"><!-- add class "with-animation" if you want sidebar to have animation during expanding/collapsing transition -->
					<i class="entypo-menu"></i>
				</a>
			</div>
			
									
			
			<!-- open/close menu icon (do not remove if you want to enable menu on mobile devices) -->
			<div class="sidebar-mobile-menu visible-xs">
				<a href="#" class="with-animation"><!-- add class "with-animation" to support animation -->
					<i class="entypo-menu"></i>
				</a>
			</div>
			
		</header>
				
		
		<ul id="main-menu" class="">
			<!-- add class "multiple-expanded" to allow multiple submenus to open -->
			<!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
			<!-- Search Bar -->
			<li class="active opened active">
				<a href="index.html">
					<span>Home Part</span>
				</a>
			</li>
			<li>
				<a href="layout-api.html">
					<i class="entypo-layout"></i>
					<span>Dealers</span>
				</a>
				<ul>
					<li>
						<a href="forms-main.html">
							<span>Add Elements</span>
						</a>
					</li>
					<li>
						<a href="forms-advanced.html">
							<span>Display Elements</span>
						</a>
					</li>
				</ul>	
			</li>
			<li>
				<a href="index.html" target="_blank">
					<i class="entypo-monitor"></i>
					<span>Market price</span>
				</a>
				<ul>
					<li>
						<a href="forms-main.html">
							<span>Add Elements</span>
						</a>
					</li>
					<li>
						<a href="forms-advanced.html">
							<span>Display Elements</span>
						</a>
					</li>
				</ul>	
			</li>
			<li>
				<a href="ui-panels.html">
					<i class="entypo-newspaper"></i>
					<span>Machinery</span>
				</a>
				<ul>
					<li>
						<a href="forms-main.html">
							<span>Add Elements</span>
						</a>
					</li>
					<li>
						<a href="forms-advanced.html">
							<span>Display Elements</span>
						</a>
					</li>
				</ul>	
			</li>
		</ul>
				
		
				
		
				
	</div>	
	<div class="main-content">
	
	

<hr />
			<ol class="breadcrumb bc-3">
						<li>
				<a href="index.html"><i class="entypo-home"></i>Home</a>
			</li>
					<li>
			
							<a href="forms-main.html">Dealers</a>
					</li>
				<li class="active">
			
							<strong>Insert Data</strong>
					</li>
					</ol>
			
<h2>Dealers Database</h2>
<br />


<div class="row">
	<div class="col-md-12">
		
		<div class="panel panel-primary" data-collapsed="0">
		
			<div class="panel-heading">
				<div class="panel-title">
					Dealers data
				</div>
			</div>
			
			<div class="panel-body">
			
				<form role="form" class="form-horizontal form-groups-bordered">
					
					<div class="form-group">
						<label class="col-sm-3 control-label">Date Range Picker</label>
						
						<div class="col-sm-5">
							
							<input type="text" class="form-control" />
							
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-3 control-label">Selected Date Range</label>
						
						<div class="col-sm-5">
							
							<input type="text" class="form-control"/>
							
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-3 control-label">Disabled Date Range</label>
						
						<div class="col-sm-5">
							
							<input type="text" class="form-control " />
							
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-3 control-label">Date Range Callback</label>
						
						<div class="col-sm-5">
							
							<input type="text" class="form-control" />
							
						</div>
					</div>
					
				</form>
			
			</div>
			
		</div>
		<input type="submit" name="submit" action="submit"></input>
	</div>
</div>


<br />

<br />

<!-- iCheck - Custom checkbox and radio buttons --><div class="row">
	
</div>




<br />
<br />
	
	</div>



	<link rel="stylesheet" href="assets/js/select2/select2-bootstrap.css">
	<link rel="stylesheet" href="assets/js/select2/select2.css">
	<link rel="stylesheet" href="assets/js/selectboxit/jquery.selectBoxIt.css">
	<link rel="stylesheet" href="assets/js/daterangepicker/daterangepicker-bs3.css">
	<link rel="stylesheet" href="assets/js/icheck/skins/minimal/_all.css">
	<link rel="stylesheet" href="assets/js/icheck/skins/square/_all.css">
	<link rel="stylesheet" href="assets/js/icheck/skins/flat/_all.css">
	<link rel="stylesheet" href="assets/js/icheck/skins/futurico/futurico.css">
	<link rel="stylesheet" href="assets/js/icheck/skins/polaris/polaris.css">

	<!-- Bottom Scripts -->
	<script src="assets/js/gsap/main-gsap.js"></script>
	<script src="assets/js/jquery-ui/js/jquery-ui-1.10.3.minimal.min.js"></script>
	<script src="assets/js/bootstrap.js"></script>
	<script src="assets/js/joinable.js"></script>
	<script src="assets/js/resizeable.js"></script>
	<script src="assets/js/neon-api.js"></script>
	<script src="assets/js/select2/select2.min.js"></script>
	<script src="assets/js/bootstrap-tagsinput.min.js"></script>
	<script src="assets/js/typeahead.min.js"></script>
	<script src="assets/js/selectboxit/jquery.selectBoxIt.min.js"></script>
	<script src="assets/js/bootstrap-datepicker.js"></script>
	<script src="assets/js/bootstrap-timepicker.min.js"></script>
	<script src="assets/js/bootstrap-colorpicker.min.js"></script>
	<script src="assets/js/daterangepicker/moment.min.js"></script>
	<script src="assets/js/daterangepicker/daterangepicker.js"></script>
	<script src="assets/js/jquery.multi-select.js"></script>
	<script src="assets/js/icheck/icheck.min.js"></script>
	<script src="assets/js/neon-chat.js"></script>
	<script src="assets/js/neon-custom.js"></script>
	<script src="assets/js/neon-demo.js"></script>

</body>
</html>