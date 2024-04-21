<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Untree.co">
<link rel="shortcut icon" href="favicon.png">

<meta name="description" content="" />
<meta name="keywords" content="bootstrap, bootstrap4" />

<!-- Bootstrap CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	rel="stylesheet">
<link href="../css/tiny-slider.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<title>로그인</title>

<style>
button {
	width: 620px;
}

.input-form {
	max-width: 680px;
	margin-top: 80px;
	padding: 32px;
	background: #fff;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	-webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
}
</style>
</head>

<body>



	<!-- Start Contact Form -->
	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-8 mx-auto">
				<h4 class="mb-3">로그인</h4>
				<form class="login-form" method="post" action="${path}/ajax">
					<input type="hidden" name="key" value="user" />
					<!-- Controller를 찾는 정보 -->
					<input type="hidden" name="methodName" value="login" />
					<!-- 메소드이름 -->
					<div class="mb-3">
						<label for="name">아이디</label> 
						<input type="text" class="form-control" id="userId" placeholder="" value="" required name="userId">
						<div class="invalid-feedback">아이디를 입력해주세요.</div>
					</div>


					<div class="mb-3">
						<label for="nickname">비밀번호</label> 
						<input type="text" class="form-control" id="nickname" placeholder="" value="" required name="password">
						<div class="invalid-feedback">비밀번호를 입력해주세요</div>



						<hr class="mb-4">

						<div class="mb-4"></div>
						<button class="btn btn-primary btn-lg btn-block" type="submit">로그인</button>
				</form>
			</div>
		</div>

	</div>

	<!-- End Contact Form -->






	<script src="../js/bootstrap.bundle.min.js"></script>
	<script src="../js/tiny-slider.js"></script>
	<script src="../js/custom.js"></script>
</body>

</html>
