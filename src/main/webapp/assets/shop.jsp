<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!Doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="author" content="Untree.co">
  <link rel="shortcut icon" href="${path}/user/images/cow.png">

  <meta name="description" content="" />
  <meta name="keywords" content="bootstrap, bootstrap4" />


		<link href="${path}/user/css/bootstrap.min.css" rel="stylesheet">
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
		<link href="${path}/user/css/tiny-slider.css" rel="stylesheet">
		<link href="${path}/user/css/style.css" rel="stylesheet">
		<title>눕소 상품 더보기</title>
	</head>

	<body>

		<!-- Start Header/Navigation -->
		<jsp:include page="common/header.jsp"></jsp:include>
		<!-- End Header/Navigation -->

		<!-- Start Hero Section -->
			<div class="hero">
				<div class="container">
					<div class="row justify-content-between">
						<div class="col-lg-5">
							<div class="intro-excerpt">
								<h1>Shop</h1>
							</div>
						</div>
						<div class="col-lg-7">	
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
							<a class="product-item" href="$">
								<img src="${path}/user/${item.img.imgSrc}" class="img-fluid product-thumbnail" alt="이미지가 경로에 없습니다.">
								<h3 class="product-title">${item.furnitureName}</h3>
								<strong class="product-price">${item.price}</strong>
								<span class="icon-cross">
									<img src="${path}/user/images/cross.svg" class="img-fluid" alt="이미지가 경로에 없습니다.">
								</span>
							</a>
						</div>
					</c:forEach> 
					<!-- End Column  -->

		      	</div>
		    </div>
		</div>
		<jsp:include page="common/footer.jsp"></jsp:include>
		
		<script src="${path}/user/js/bootstrap.bundle.min.js"></script>
		<script src="${path}/user/js/tiny-slider.js"></script>
		<script src="${path}/user/js/custom.js"></script>
	</body>

</html>