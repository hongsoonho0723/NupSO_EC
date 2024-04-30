<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Untree.co">

<meta name="description" content="" />
<meta name="keywords" content="bootstrap, bootstrap4" />

<!-- Bootstrap CSS -->
<link rel="shortcut icon" href="${path}/assets/images/cow.png">

<link href="${path}/assets/css/bootstrap.min.css" rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	rel="stylesheet">
<link href="${path}/assets/css/tiny-slider.css" rel="stylesheet">
<link href="${path}/assets/css/style.css" rel="stylesheet">
<title>로그인</title>

<style>
#btn {
	width: 100%;
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

<script type="text/javascript" src="${path}/assets/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {

		//로그인 ajax
		$("#btn").click(function() {

			$.ajax({
				url : "${path}/ajax?key=userAjax&methodName=login", //통신할 서버의 주소
				type : "post", //요청방식(get | post | put | delete | fetch)
				dataType : "json", //서버가 보내오는 응답데이터타입(text | html | xml | json)
				data : {
					userId : $("#userId").val(),
					password : $("#password").val()
				},
				success : function(result, status) {
					//화면갱신
					console.log("result = " + result)
					if (result && result.name) {
						alert("로그인 성공");
						window.location.href = "index.jsp";
						//window.history.back();
						
					} else {

						alert("아이디 불일치");
						$("#span1").text("아이디와 비밀번호를 확인해주세요");
					}
				},
				error : function(err, status) {
					//통신에 실패하면 해야할 일 
					alert("정보를 확인해주세요");
				}
			});//ajax end

		})

	})//load end
</script>

</head>

<body>



	<!-- Start Contact Form -->
	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-8 mx-auto">

				<h4 class="mb-3">로그인</h4>
				<span id ="span1"></span>
				<form class="login-form" method="post" action="${path}/ajax">
					<!-- <input type="hidden" name="key" value="user" /> -->
					<!-- Controller를 찾는 정보 -->
					<!-- <input type="hidden" name="methodName" value="login" /> -->
					<!-- 메소드이름 -->
					<div class="mb-3">
						<label for="name">아이디</label> 
						<input type="text"	class="form-control" id="userId" name="userId" placeholder="" value="" required>
						<div class="invalid-feedback">아이디를 입력해주세요.</div>
					</div>


					<div class="mb-3">
						<label for="nickname">비밀번호</label> 
						<input type="password" class="form-control" id="password" name="password" placeholder="" value="" required>
						<div class="invalid-feedback">비밀번호를 입력해주세요</div>



						<hr class="mb-4">

						<div class="mb-4" ></div>
						<input type="button" class="btn btn-primary btn-lg btn-block" value="로그인" id="btn">
						<!-- <button class="btn btn-primary btn-lg btn-block" id = "btn" type="submit">로그인</button> -->
				</form>

			</div>
			<p>
				<a href="signUp.jsp">회원가입</a>
		</div>

	</div>

	<!-- End Contact Form -->






	<script src="${path}/assets/js/bootstrap.bundle.min.js"></script>
	<script src="${path}/assets/js/tiny-slider.js"></script>
	<script src="${path}/assets/js/custom.js"></script>
</body>

</html>
