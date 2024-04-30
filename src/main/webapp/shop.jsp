<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!Doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="author" content="Untree.co">
  <link rel="shortcut icon" href="assets/images/cow.png">

  <meta name="description" content="" />
  <meta name="keywords" content="bootstrap, bootstrap4" />
<style type="text/css">
h2 {
    color: white;
}

</style>

		<link href="assets/css/bootstrap.min.css" rel="stylesheet">
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
		<link href="assets/css/tiny-slider.css" rel="stylesheet">
		<link href="assets/css/style.css" rel="stylesheet">
		<title>눕소 상품 더보기</title>
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
							Shop<span class="d-block"></span>
						</h1>
						<h2>하루종일<br> 눕고 싶고,<br>자고 싶은 쇼파.</h2>
								<p class="mb-4">하루종일 누워있고만 싶어라</p>
						<p class="mb-4" style="font-weight: 500; font-size: 1rem;">
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
						</p>
						
					</div>
				</div>
				<div class="col-lg-7">
					<div class="hero-img-wrap">
						<img src="assets/images/shop.png" class="img-fluid">
					</div>
				</div>
			</div>
		</div>
	</div>
		<!-- End Hero Section -->
		
		<div class="untree_co-section product-section before-footer-section">
		    <div class="container">
		      	<div class="row">
		      		<!-- Start Column  -->
		      		<c:forEach items="${list}" var="item">
						<div class="col-12 col-md-4 col-lg-3 mb-5">
							<a class="product-item" href="${path}/front?key=furniture&methodName=furnitureInfo&furnitureName=${item.furnitureName}">
								<img src="assets/${item.furnitureImgSrc}" class="img-fluid product-thumbnail" alt="이미지가 경로에 없습니다.">
								<h3 class="product-title">${item.furnitureName}</h3>			
								<strong class="product-price"><fmt:formatNumber value ="${item.price}"/></strong>
								<span class="icon-cross">
									<img src="assets/images/cross.svg" class="img-fluid" alt="이미지가 경로에 없습니다.">
								</span>
							</a>
						</div>
					</c:forEach> 
					<!-- End Column  -->
		      	</div>
		    </div>
		</div>
		<jsp:include page="assets/common/user/footer.jsp"></jsp:include>
		
		<script src="assets/js/bootstrap.bundle.min.js"></script>
		<script src="assets/js/tiny-slider.js"></script>
		<script src="assets/js/custom.js"></script>
	</body>

</html>