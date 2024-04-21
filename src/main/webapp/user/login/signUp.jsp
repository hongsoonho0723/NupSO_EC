<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="author" content="Untree.co">
  <link rel="shortcut icon" href="favicon.png">

  <meta name="description" content="" />
  <meta name="keywords" content="bootstrap, bootstrap4" />

		<!-- Bootstrap CSS -->
		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
		<link href="../css/tiny-slider.css" rel="stylesheet">
		<link href="../css/style.css" rel="stylesheet">
		<title>회원가입</title>
	
		<style>
			
			#btn{

				width : 620px;

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
		  
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
 $(function(){

	 
	 $("#userId").keyup(function(){
		
		 $.ajax({
			 url: "${path}/ajax?key=user&methodName=idCheck", //통신할 서버의 주소
			 type: "post", //요청방식(get | post | put | delete | fetch)
			 dataType:"json", //서버가 보내오는 응답데이터타입(text | html | xml | json)
			 data:"userId="+$("#userId").val(), //서버에게 전달할 데이터 parameter정보
			 success :function(result , status){
				  //화면갱신
				  console.log("result = "+result)
				 
				  if(result)
					  $("#span1").text("사용가능");
					  
				  else{
					  $("#span1").text("아이디중복");
					} 
			 },
			 error : function(err, status){
				 //통신에 실패하면 해야할 일 
				 alert(err+"발생했어요 status :" + status);
			 }
		 }); //ajax end
		 
		})	//userId keyup end
		 
	$("#btn").click(function(){
		 $.ajax({
			 url: "${path}/ajax?key=user&methodName=insert", //통신할 서버의 주소
			 type: "post", //요청방식(get | post | put | delete | fetch)
			 dataType:"json", //서버가 보내오는 응답데이터타입(text | html | xml | json)
			 data:$("#inForm").serialize(), //서버에게 전달할 데이터 parameter정보
			 success :function(result , status){
				  //화면갱신
				  console.log("result = "+result)
				 
				  if(result){
					  alert("회원가입 성공!");
					window.location.href = "login.jsp";					  
				  }else{
					  alert("회원가입 실패!");
					} 
			 },
			 error : function(err, status){
				 //통신에 실패하면 해야할 일 
				 alert(err+"발생했어요 status :" + status);
			 }
		 }); //ajax end
		
		
	})//click end
		
	$("#password2").keyup(function(){
		
		
		let password1 = $("#password1").val();
		let password2 = $("#password2").val();
		
		
		if(password1 != password2){
			$("#span2").text("비밀번호 불일치");
		}else{
			$("#span2").text("비밀번호 일치");
		}
		
		/*  $.ajax({
			 url: "${path}/ajax?key=user&methodName=passwordCheck", //통신할 서버의 주소
			 type: "post", //요청방식(get | post | put | delete | fetch)
			 dataType:"json", //서버가 보내오는 응답데이터타입(text | html | xml | json)
			 data:"password="+$("#password1").val(), //서버에게 전달할 데이터 parameter정보
			 success :function(result , status){
				  //화면갱신
				  console.log("result = "+result)
				 
				  if(result)
					  $("span").text("사용가능");
					  
				  else{
					  $("span").text("아이디중복");
					} 
			 },
			 error : function(err, status){
				 //통신에 실패하면 해야할 일 
				 alert(err+"발생했어요 status :" + status);
			 }
		 }); //ajax end */
		 
		})	//password keyup end
		
		
		
 })//load end 




</script>
		  
		  
	</head>

	<body>

		<div class="container">
			<div class="input-form-backgroud row">
			  <div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">회원가입</h4>
				<form class="validation-form" novalidate id="inForm">
				  
					<div class="mb-3">
					  <label for="userId">아이디</label>
					  <input type="text" class="form-control" id="userId" name="userId" placeholder="" value="" required>
					  <span id="span1"></span>
					  <div class="invalid-feedback">
						아이디를 입력해주세요.
					  </div>
					</div>
		
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="password">비밀번호</label>
							<input type="text" class="form-control" id="password1" name="password1" placeholder="" value="" required>
								<span id="span2"></span>
							<div class="invalid-feedback">
								비밀번호를 입력해주세요
							</div>
						</div>
							<div class="col-md-6 mb-3">
								<label for="password2">비밀번호 확인</label>
								<input type="password" class="form-control" id="password2" name="password2" placeholder="" value="" required>
								<div class="invalid-feedback">
									비밀번호를 입력해주세요
								</div>
							</div>
					</div>
				
		
		
				  <div class="mb-3">
					<label for="name">이름</label>
					<input type=text class="form-control" id="name" name="name"  placeholder="" required>
					<div class="invalid-feedback">
					  이름을 입력해주세요.
					</div>
				  </div>
		
				<div class="row">
						<div class="col-md-6 mb-3">
							<label for="jumin1">주민번호 (8자리 입력)</label>
							<input type="text" class="form-control" id="jumin1" name="jumin1"  placeholder="ex) 19990101 " required>
							<div class="invalid-feedback">
							주민번호를 입력해주세요.
							</div>
						</div>
						<div class="col-md-2 mb-3">
							<label for="jumin2">앞 1자리 </label>
							<input type="text" class="form-control" id="jumin2" name="jumin2"  placeholder="" required>
							<div class="invalid-feedback">
							주민번호 입력해주세요.
							</div>
						</div>
					   
		
		
				</div>
		
		
				  <div class="mb-3">
					<label for="addr">주소</label>
					<input type="text" class="form-control" id="addr" name="addr" placeholder="">
					<div class="invalid-feedback">
						주소를 입력해주세요
					  </div>
				  </div>
		
				  
					<div class="mb-3">
					  <label for="phone">전화번호</label>
					  <input type="text" class="form-control" id="phone" name="phone" placeholder="" required>
					  <div class="invalid-feedback">
						전화번호를 입력해주세요
					  </div>
					</div>
								   
				  
				  <hr class="mb-4">
				  <div class="custom-control custom-checkbox">
					<input type="checkbox" class="custom-control-input" id="aggrement" required>
					<label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
				  </div>
				  <div class="mb-4"></div>
				 <!--  <button class="btn btn-primary btn-lg btn-block" type="submit">가입 완료</button> -->
			   		<input type="button" value="가입 완료" id="btn">
				</form>
			  </div>
			</div>
		  
		  </div>
		  <script>
			window.addEventListener('load', () => {
			  const forms = document.getElementsByClassName('validation-form');
		
			  Array.prototype.filter.call(forms, (form) => {
				form.addEventListener('submit', function (event) {
				  if (form.checkValidity() === false) {
					event.preventDefault();
					event.stopPropagation();
				  }
		
				  form.classList.add('was-validated');
				}, false);
			  });
			}, false);
		  </script>
	</body>

</html>
