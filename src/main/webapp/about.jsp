<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="author" content="Untree.co">
  <link rel="shortcut icon" href="${path}/assets/images/cow.png">

  <meta name="description" content="" />
  <meta name="keywords" content="bootstrap, bootstrap4" />
  <style type="text/css">

 .img-fluid.mr-3 {
    width: 216px;
    height: 160px;
    object
  }
  
  </style>

		<!-- Bootstrap CSS -->
		<link href="assets/css/bootstrap.min.css" rel="stylesheet">
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
		<link href="assets/css/tiny-slider.css" rel="stylesheet">
		<link href="assets/css/style.css" rel="stylesheet">
		<title>눕소 개발진</title>
	</head>

	<body>

		<!-- Start Header/Navigation -->
		<jsp:include page="assets/common/user/header.jsp"></jsp:include>
		<!-- End Header/Navigation -->

		<!-- Start Hero Section -->
			<div class="hero">
				<div class="container">
					<div class="row justify-content-between">
						<div class="col-lg-5">
							<div class="intro-excerpt">
								<h1>눕고 싶다,<br>자고 싶다.</h1>
								<p class="mb-4">하루종일 누워있고만 싶어라</p>
								<p><a href="${path}/front?key=furniture&methodName=selectFurnitureList" class="btn btn-secondary me-2"
								style="margin-top:10px;">상품 보러 가기</a></p>
							</div>
						</div>
						<div class="col-lg-7">
							<div class="hero-img-wrap">
								<img src="${path}/assets/images/about_us.png" class="img-fluid">
							</div>
						</div>
					</div>
				</div>
			</div>
		<!-- End Hero Section -->


		<!-- Start Team Section -->

		<!-- End Team Section -->

		<br><br>
<div class="col-md-6 mb-5">
<div class="d-flex align-items-center"" style="padding: 20px; border: 1px solid #ccc; border-radius: 5px;">
        <img src="${path}/assets/images/changhoon.jpg" class="img-fluid mr-3">
        <div style="margin-left: 20px;">
            <h3>신창훈</h3>
            <p>팀원 중 한 분이 도망가는 상황에서 팀의 사기가 저하되었음에도 불구하고, 
            남은 팀원들이 끝까지 최선을 다해주셨습니다. 이번 프로젝트에서 각자 맡은 기능을 열심히 수행하고, 
            팀의 목표를 위해 노력한 모든 팀원들에게 감사드립니다!!</p>
        </div>
    </div>
    <br>
<div class="d-flex align-items-center"" style="padding: 20px; border: 1px solid #ccc; border-radius: 5px;">
        <img src="${path}/assets/images/yunguk.jpg" class="img-fluid mr-3">
        <div style="margin-left: 20px;">
            <h3>김윤국</h3>
            <p>이번 2차 프로젝트를 진행하며 개인적으로 부족했던 역량을 키울 수 있었습니다. 
            또한 팀장으로서 프로젝트를 무사히 마치기 위해 일정 관리 및 팀을 어떻게 이끌어 나가야 할 지 고민할 수 있었던 
            좋은 기회가 되었습니다. 이번 프로젝트 기간 동안 함께 고생한 팀원분들에게도 감사하다는 말씀 드립니다.</p>
        </div>
    </div>
    <br>
 <div class="d-flex align-items-center"" style="padding: 20px; border: 1px solid #ccc; border-radius: 5px;">
        <img src="${path}/assets/images/youhan.jpg" class="img-fluid mr-3">
        <div style="margin-left: 20px;">
            <h3>박유한</h3>
            <p>프로젝트를 진행하면서 우여곡절이 많았습니다. 그럴 때마다 팀원들의 도움으로 해결할 수 있었습니다. 
            이 자리를 빌려 감사하다고 말씀드리고 싶습니다. 
            덕분에 이 프로젝트에서 한 부분을 맡을 수 있었고 그 책임을 다할 수 있었습니다. 
            기대치에 맞게 성장했는지는 모르겠지만 한 단계 한 단계 나아간다는 느낌을 받을 수 있었습니다. 
            프로젝트를 함께할 수 있어서 감사했습니다.</p>
        </div>
    </div>
    <br>
    <div class="d-flex align-items-center" style="padding: 20px; border: 1px solid #ccc; border-radius: 5px;">
        <img src="${path}/assets/images/dahee.png" class="img-fluid mr-3">
        <div style="margin-left: 20px;">
            <h3>정다희</h3>
            <p>팀프로젝트를 할 때마다 각자 다양한 스타일과 성향이 있는 것을 새삼 느낍니다. 
            여러 사람이 모여서 작업하는 과정이 처음엔 어색하기도 하지만 모르는 걸 
            새롭게 알게 되기도 하고 결국엔 혼자 할 때보다 훨씬 시너지를 낼 수 있는 것 같습니다. 
            레고를 맞추듯 다른 사람이 한 것을 하나하나 연결해보는 과정이 어렵기도, 재밌기도 했습니다.  
            MVC구조를 익힌 것을 바탕으로 이후 프레임워크 부분도 많이 연습해보고 싶습니다. 
            부족한 부분을 항상 친절하게 알려준 다른 팀원 분들께 감사합니다.</p>
        </div>
    </div>
    <br>
    <div class="d-flex align-items-center" style="padding: 20px; border: 1px solid #ccc; border-radius: 5px;">
        <img src="${path}/assets/images/soonho.png" class="img-fluid mr-3">
        <div style="margin-left: 20px;">
            <h3>홍순호</h3>
            <p>처음 시작할 때 mvc 구조에 대해서 헷갈리던 부분이 있었는데 프로젝트를 진행하면서 데이터의 
            흐름에 대해서 알게 되었습니다. 또한 팀원들과 협업하는 과정에서 좀 더 많이 말하고 의견을 공유할수록 
            더 탄탄하고 좋은 서비스가 탄생할 수 있다는 것을 느끼게 되었습니다</p>
        </div>
    </div>
</div>
		

		<!-- Start Testimonial Slider -->
		<div class="testimonial-section before-footer-section">
			<div class="container">
				<div class="row">
					<div class="col-lg-7 mx-auto text-center">
						<h2 class="section-title">후원자들의 후기</h2>
					</div>
				</div>

				<div class="row justify-content-center">
					<div class="col-lg-12">
						<div class="testimonial-slider-wrap text-center">

							<div id="testimonial-nav">
								<span class="prev" data-controls="prev"><span class="fa fa-chevron-left"></span></span>
								<span class="next" data-controls="next"><span class="fa fa-chevron-right"></span></span>
							</div>

							<div class="testimonial-slider">
								
								<div class="item">
									<div class="row justify-content-center">
										<div class="col-lg-8 mx-auto">

											<div class="testimonial-block text-center">
												<blockquote class="mb-5">
													<p>&ldquo;제가 봤던 쇼파홈페이지중 최고였어요...&rdquo;</p>
												</blockquote>

												<div class="author-info">
													<div class="author-pic">
														<img src="assets/images/jang.jpg" alt="Maria Jones" class="img-fluid">
													</div>
													<h3 class="font-weight-bold">장희정</h3>
													<span class="position d-block mb-3">CEO, Co-Founder, KOSTA Inc.</span>
												</div>
											</div>

										</div>
									</div>
								</div> 
								<!-- END item -->

								<div class="item">
									<div class="row justify-content-center">
										<div class="col-lg-8 mx-auto">

											<div class="testimonial-block text-center">
												<blockquote class="mb-5">
													<p>&ldquo;이 사이트면 마누라랑 자식도 바꿀수 있다&rdquo;</p>
												</blockquote>

												<div class="author-info">
													<div class="author-pic">
														<img src="assets/images/Lee.jpg" alt="Maria Jones" class="img-fluid">
													</div>
													<h3 class="font-weight-bold">이건회</h3>
													<span class="position d-block mb-3">CEO, Co-Founder, SamSon Inc.</span>
												</div>
											</div>

										</div>
									</div>
								</div> 
								<!-- END item -->
								
								<div class="item">
									<div class="row justify-content-center">
										<div class="col-lg-8 mx-auto">

											<div class="testimonial-block text-center">
												<blockquote class="mb-5">
													<p>&ldquo;Don't cross the line&rdquo;</p>
												</blockquote>

												<div class="author-info">
													<div class="author-pic">
														<img src="assets/images/Jonna.jpg" alt="Maria Jones" class="img-fluid">
													</div>
													<h3 class="font-weight-bold">Jonna</h3>
													<span class="position d-block mb-3">CEO, Co-Founder, IKEA Inc.</span>
												</div>
											</div>

										</div>
									</div>
								</div> 
								<!-- END item -->


							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Testimonial Slider -->

		

		<!-- Start Footer Section -->
		<footer class="footer-section">
			<div class="container relative">

				<div class="sofa-img">
					<img src="assets/images/sofa.png" alt="Image" class="img-fluid">
				</div>

				<div class="row">
					<div class="col-lg-8">
						<div class="subscription-form">
							<h3 class="d-flex align-items-center"><span class="me-1"><img src="assets/images/envelope-outline.svg" alt="Image" class="img-fluid"></span><span>Subscribe to Newsletter</span></h3>

							<form action="#" class="row g-3">
								<div class="col-auto">
									<input type="text" class="form-control" placeholder="Enter your name">
								</div>
								<div class="col-auto">
									<input type="email" class="form-control" placeholder="Enter your email">
								</div>
								<div class="col-auto">
									<button class="btn btn-primary">
										<span class="fa fa-paper-plane"></span>
									</button>
								</div>
							</form>

						</div>
					</div>
				</div>

				<div class="row g-5 mb-5">
					<div class="col-lg-4">
						<div class="mb-4 footer-logo-wrap"><a href="#" class="footer-logo">Furni<span>.</span></a></div>
						<p class="mb-4">Donec facilisis quam ut purus rutrum lobortis. Donec vitae odio quis nisl dapibus malesuada. Nullam ac aliquet velit. Aliquam vulputate velit imperdiet dolor tempor tristique. Pellentesque habitant</p>

						<ul class="list-unstyled custom-social">
							<li><a href="#"><span class="fa fa-brands fa-facebook-f"></span></a></li>
							<li><a href="#"><span class="fa fa-brands fa-twitter"></span></a></li>
							<li><a href="#"><span class="fa fa-brands fa-instagram"></span></a></li>
							<li><a href="#"><span class="fa fa-brands fa-linkedin"></span></a></li>
						</ul>
					</div>

					<div class="col-lg-8">
						<div class="row links-wrap">
							<div class="col-6 col-sm-6 col-md-3">
								<ul class="list-unstyled">
									<li><a href="#">About us</a></li>
									<li><a href="#">Services</a></li>
									<li><a href="#">Blog</a></li>
									<li><a href="#">Contact us</a></li>
								</ul>
							</div>

							<div class="col-6 col-sm-6 col-md-3">
								<ul class="list-unstyled">
									<li><a href="#">Support</a></li>
									<li><a href="#">Knowledge base</a></li>
									<li><a href="#">Live chat</a></li>
								</ul>
							</div>

							<div class="col-6 col-sm-6 col-md-3">
								<ul class="list-unstyled">
									<li><a href="#">Jobs</a></li>
									<li><a href="#">Our team</a></li>
									<li><a href="#">Leadership</a></li>
									<li><a href="#">Privacy Policy</a></li>
								</ul>
							</div>

							<div class="col-6 col-sm-6 col-md-3">
								<ul class="list-unstyled">
									<li><a href="#">Nordic Chair</a></li>
									<li><a href="#">Kruzo Aero</a></li>
									<li><a href="#">Ergonomic Chair</a></li>
								</ul>
							</div>
						</div>
					</div>

				</div>

				<div class="border-top copyright">
					<div class="row pt-4">
						<div class="col-lg-6">
							<p class="mb-2 text-center text-lg-start">Copyright &copy;<script>document.write(new Date().getFullYear());</script>. All Rights Reserved. &mdash; Designed with love by <a href="https://untree.co">Untree.co</a> Distributed By <a hreff="https://themewagon.com">ThemeWagon</a>  <!-- License information: https://untree.co/license/ -->
            </p>
						</div>

						<div class="col-lg-6 text-center text-lg-end">
							<ul class="list-unstyled d-inline-flex ms-auto">
								<li class="me-4"><a href="#">Terms &amp; Conditions</a></li>
								<li><a href="#">Privacy Policy</a></li>
							</ul>
						</div>

					</div>
				</div>

			</div>
		</footer>
		<!-- End Footer Section -->	


		<script src="assets/js/bootstrap.bundle.min.js"></script>
		<script src="assets/js/tiny-slider.js"></script>
		<script src="assets/js/custom.js"></script>
	</body>

</html>