<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Untree.co">
<link rel="shortcut icon" href="assets/images/cow.png">

<meta name="description" content="" />
<meta name="keywords" content="bootstrap, bootstrap4" />

<!-- Bootstrap CSS -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	rel="stylesheet">
<link href="assets/css/tiny-slider.css" rel="stylesheet">
<link href="assets/css/style.css" rel="stylesheet">
<title>NupSO - Index</title>

<style>
.bold {
	font-weight: 520;
}

</style>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
						<h1>
							눕고 싶은 소파,<br>
							눕소. <span class="d-block"></span>
						</h1>
						<p class="mb-4" style="font-weight: 500; font-size: 1rem;">
							당신의 휴식을 위한 최적의 선택, <br>눕소의 프리미엄 소파와 함께하세요.<br><a
								href="${path}/front?key=furniture&methodName=selectFurnitureList"
								class="btn btn-secondary me-2" style="margin-top: 10px;">Shop
								Now</a>
							<!-- <a href="#" class="btn btn-white-outline">Explore</a> -->
						</p>
					</div>
				</div>
				<div class="col-lg-7">
					<div class="hero-img-wrap">
						<img src="assets/images/couch.png" class="img-fluid">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Hero Section -->

	<!-- Start Product Section -->
	<div class="product-section">
		<div class="container">
			<div class="row" id = "popular-items">

				<!-- Start Column 1 -->
				<div class="col-md-12 col-lg-3 mb-5 mb-lg-0" >
					<h2 class="mb-4 section-title" style="weight: bold">Top Products</h2>
					<p class="mb-4" style="font-weight: 510;">NupSO에서 판매량이 가장 높은 제품들입니다.</p>
					<p>
						<a
							href="${path}/front?key=furniture&methodName=selectFurnitureList"
							class="btn" style="margin-top: 10px;" class="btn">상품 전체 보기</a>
					</p>
					
				</div>
				
				</div>
				</div>
</div>
	
	<!-- End Product Section -->
	<script>
	let rootPath = '${path}'; // JSP에서 JavaScript 변수로 변환
$(document).ready(function() {
    $.ajax({
        url: rootPath + '/ajax?key=furnitureAjax&methodName=selectFurnitureOrderBySales', // 서버 URL
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            let content = '';
            $.each(data, function(i, item) {
            	if(i<3){
                content += '<div class="col-12 col-md-4 col-lg-3 mb-5 mb-md-0">';
                content += '<a class="product-item" href="' + rootPath + '/front?key=furniture&methodName=furnitureInfo&furnitureName=' + item.furnitureName + '">';
                content += '<img src="assets/' + item.furnitureImgSrc + '" class="img-fluid product-thumbnail" alt="이미지가 경로에 없습니다.">';
                content += '<h3 class="product-title">' + item.furnitureName + '</h3>';
                content += '<strong class="product-price">' + Number(item.price).toLocaleString() + '</strong>';
                content += '<span class="icon-cross"><img src="assets/images/cross.svg" class="img-fluid"></span>';
                content += '</a></div>';
            	}
            });
            $('#popular-items').append(content); //판매량 순으로 쇼파 목록 삽입할 dom 요소 설정
        },
        error: function() {
            alert('데이터를 불러오는데 실패했습니다.');
        }
    });
});
</script>

	<!-- Start Why Choose Us Section -->
	<div class="why-choose-section">
		<div class="container">
			<div class="row justify-content-between">
				<div class="col-lg-6">
					<h2 class="section-title" style="font-weight: 600">눕소의 특별함.</h2>
					<p>최고의 휴식을 선사하는 프리미엄 소파, NupSO입니다.<br>누워보면 알 수 있는, 눕고 싶은 순간의 완벽함을 제공합니다.</p>
					<div class="row my-5">
					<div class="col-6 col-md-6">
							<div class="feature">
								<div class="icon">
									<img src="assets/images/return.svg" alt="Image"
										class="imf-fluid">
								</div>
								<h5>완벽한 공간을 위한 맞춤 추천</h5>
								<p>각 소파에 어울리는 인테리어 사진들을 보며, 마음에 쏙 드는 공간을 쉽게 상상하고 고를 수 있어요."</p>
							</div>
						</div>
						
					<div class="col-6 col-md-6">
							<div class="feature">
								<div class="icon">
									<img src="assets/images/bag.svg" alt="Image" class="imf-fluid">
								</div>
								<h5>편리한 결제, 카카오페이</h5>
								<p>결제는 빠르고 편리하게, 카카오페이로! 몇 번의 클릭으로 쉽게 주문하고, 안전한 결제 경험을 즐겨보세요.</p>
							</div>
						</div>
						
						<div class="col-6 col-md-6">
							<div class="feature">
								<div class="icon">
									<img src="assets/images/truck.svg" alt="Image"
										class="img-fluid">
								</div>
								<h5>소파에 특화된 세심한 선택</h5>
								<p>다양한 사이즈와 색상 중에서, 당신의 취향과 집안에 꼭 맞는 그 한 조각을 찾아보세요.</p>
							</div>
						</div>
						
						<div class="col-6 col-md-6">
							<div class="feature">
								<div class="icon">
									<img src="assets/images/support.svg" alt="Image"
										class="imf-fluid">
								</div>
								<h5>맞춤형 상담으로 딱 맞는 소파를</h5>
								<p>상담사가 1시간 이내에 답변드리고, 상세한 조언을 통해 완벽한 소파를 선택할 수 있도록 도와드릴게요.<br>
								다른 고객님들의 리뷰도 꼭 확인해 보세요!</p>
							</div>
						</div>
						
					</div>
				</div>

				<div class="col-lg-5">
					<div class="img-wrap">
						<img src="assets/images/why-choose-us-img.jpg" alt="Image"
							class="img-fluid">
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- End Why Choose Us Section -->

	<!-- Start We Help Section -->
	<div class="we-help-section">
		<div class="container">
			<div class="row justify-content-between">
				<div class="col-lg-7 mb-5 mb-lg-0">
					<div class="imgs-grid">
						<div class="grid grid-1">
							<img src="assets/images/img-grid-1.jpg" alt="Untree.co">
						</div>
						<div class="grid grid-2">
							<img src="assets/images/img-grid-2.jpg" alt="Untree.co">
						</div>
						<div class="grid grid-3">
							<img src="assets/images/img-grid-3.jpg" alt="Untree.co">
						</div>
					</div>
				</div>
				<div class="col-lg-5 ps-lg-5">
					<h2 class="section-title mb-4">We Help You Make Modern
						Interior Design</h2>
					<p>Donec facilisis quam ut purus rutrum lobortis. Donec vitae
						odio quis nisl dapibus malesuada. Nullam ac aliquet velit. Aliquam
						vulputate velit imperdiet dolor tempor tristique. Pellentesque
						habitant morbi tristique senectus et netus et malesuada</p>

					<ul class="list-unstyled custom-list my-4">
						<li>Donec vitae odio quis nisl dapibus malesuada</li>
						<li>Donec vitae odio quis nisl dapibus malesuada</li>
						<li>Donec vitae odio quis nisl dapibus malesuada</li>
						<li>Donec vitae odio quis nisl dapibus malesuada</li>
					</ul>
					<p>
						<a href="#" class="btn">Explore</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- End We Help Section -->

	<!-- Start Popular Product -->
	<div class="popular-product">
		<div class="container">
			<div class="row">

				<div class="col-12 col-md-6 col-lg-4 mb-4 mb-lg-0">
					<div class="product-item-sm d-flex">
						<div class="thumbnail">
							<img src="assets/images/product-1.png" alt="Image"
								class="img-fluid">
						</div>
						<div class="pt-3">
							<h3>Nordic Chair</h3>
							<p>Donec facilisis quam ut purus rutrum lobortis. Donec vitae
								odio</p>
							<p>
								<a href="#">Read More</a>
							</p>
						</div>
					</div>
				</div>

				<div class="col-12 col-md-6 col-lg-4 mb-4 mb-lg-0">
					<div class="product-item-sm d-flex">
						<div class="thumbnail">
							<img src="assets/images/product-2.png" alt="Image"
								class="img-fluid">
						</div>
						<div class="pt-3">
							<h3>Kruzo Aero Chair</h3>
							<p>Donec facilisis quam ut purus rutrum lobortis. Donec vitae
								odio</p>
							<p>
								<a href="#">Read More</a>
							</p>
						</div>
					</div>
				</div>

				<div class="col-12 col-md-6 col-lg-4 mb-4 mb-lg-0">
					<div class="product-item-sm d-flex">
						<div class="thumbnail">
							<img src="assets/images/product-3.png" alt="Image"
								class="img-fluid">
						</div>
						<div class="pt-3">
							<h3>Ergonomic Chair</h3>
							<p>Donec facilisis quam ut purus rutrum lobortis. Donec vitae
								odio</p>
							<p>
								<a href="#">Read More</a>
							</p>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- End Popular Product -->

	<!-- Start Testimonial Slider -->
	<div class="testimonial-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-7 mx-auto text-center">
					<h2 class="section-title">Testimonials</h2>
				</div>
			</div>

			<div class="row justify-content-center">
				<div class="col-lg-12">
					<div class="testimonial-slider-wrap text-center">

						<div id="testimonial-nav">
							<span class="prev" data-controls="prev"><span
								class="fa fa-chevron-left"></span></span> <span class="next"
								data-controls="next"><span class="fa fa-chevron-right"></span></span>
						</div>

						<div class="testimonial-slider">

							<div class="item">
								<div class="row justify-content-center">
									<div class="col-lg-8 mx-auto">

										<div class="testimonial-block text-center">
											<blockquote class="mb-5">
												<p>&ldquo;Donec facilisis quam ut purus rutrum lobortis.
													Donec vitae odio quis nisl dapibus malesuada. Nullam ac
													aliquet velit. Aliquam vulputate velit imperdiet dolor
													tempor tristique. Pellentesque habitant morbi tristique
													senectus et netus et malesuada fames ac turpis egestas.
													Integer convallis volutpat dui quis scelerisque.&rdquo;</p>
											</blockquote>

											<div class="author-info">
												<div class="author-pic">
													<img src="assets/images/person-1.png" alt="Maria Jones"
														class="img-fluid">
												</div>
												<h3 class="font-weight-bold">Maria Jones</h3>
												<span class="position d-block mb-3">CEO, Co-Founder,
													XYZ Inc.</span>
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
												<p>&ldquo;Donec facilisis quam ut purus rutrum lobortis.
													Donec vitae odio quis nisl dapibus malesuada. Nullam ac
													aliquet velit. Aliquam vulputate velit imperdiet dolor
													tempor tristique. Pellentesque habitant morbi tristique
													senectus et netus et malesuada fames ac turpis egestas.
													Integer convallis volutpat dui quis scelerisque.&rdquo;</p>
											</blockquote>

											<div class="author-info">
												<div class="author-pic">
													<img src="images/person-1.png" alt="Maria Jones"
														class="img-fluid">
												</div>
												<h3 class="font-weight-bold">Maria Jones</h3>
												<span class="position d-block mb-3">CEO, Co-Founder,
													XYZ Inc.</span>
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
												<p>&ldquo;Donec facilisis quam ut purus rutrum lobortis.
													Donec vitae odio quis nisl dapibus malesuada. Nullam ac
													aliquet velit. Aliquam vulputate velit imperdiet dolor
													tempor tristique. Pellentesque habitant morbi tristique
													senectus et netus et malesuada fames ac turpis egestas.
													Integer convallis volutpat dui quis scelerisque.&rdquo;</p>
											</blockquote>

											<div class="author-info">
												<div class="author-pic">
													<img src="assets/images/person-1.png" alt="Maria Jones"
														class="img-fluid">
												</div>
												<h3 class="font-weight-bold">Maria Jones</h3>
												<span class="position d-block mb-3">CEO, Co-Founder,
													XYZ Inc.</span>
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

	<!-- Start Blog Section -->
	<div class="blog-section">
		<div class="container">
			<div class="row mb-5">
				<div class="col-md-6">
					<h2 class="section-title">Recent Blog</h2>
				</div>
				<div class="col-md-6 text-start text-md-end">
					<a href="#" class="more">View All Posts</a>
				</div>
			</div>

			<div class="row">

				<div class="col-12 col-sm-6 col-md-4 mb-4 mb-md-0">
					<div class="post-entry">
						<a href="#" class="post-thumbnail"><img
							src="assets/images/post-1.jpg" alt="Image" class="img-fluid"></a>
						<div class="post-content-entry">
							<h3>
								<a href="#">First Time Home Owner Ideas</a>
							</h3>
							<div class="meta">
								<span>by <a href="#">Kristin Watson</a></span> <span>on <a
									href="#">Dec 19, 2021</a></span>
							</div>
						</div>
					</div>
				</div>

				<div class="col-12 col-sm-6 col-md-4 mb-4 mb-md-0">
					<div class="post-entry">
						<a href="#" class="post-thumbnail"><img
							src="assets/images/post-2.jpg" alt="Image" class="img-fluid"></a>
						<div class="post-content-entry">
							<h3>
								<a href="#">How To Keep Your Furniture Clean</a>
							</h3>
							<div class="meta">
								<span>by <a href="#">Robert Fox</a></span> <span>on <a
									href="#">Dec 15, 2021</a></span>
							</div>
						</div>
					</div>
				</div>

				<div class="col-12 col-sm-6 col-md-4 mb-4 mb-md-0">
					<div class="post-entry">
						<a href="#" class="post-thumbnail"><img
							src="assets/images/post-3.jpg" alt="Image" class="img-fluid"></a>
						<div class="post-content-entry">
							<h3>
								<a href="#">Small Space Furniture Apartment Ideas</a>
							</h3>
							<div class="meta">
								<span>by <a href="#">Kristin Watson</a></span> <span>on <a
									href="#">Dec 12, 2021</a></span>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- End Blog Section -->
	<jsp:include page="assets/common/user/footer.jsp"></jsp:include>

	<script src="assets/js/bootstrap.bundle.min.js"></script>
	<script src="assets/js/tiny-slider.js"></script>
	<script src="assets/js/custom.js"></script>
</body>

</html>