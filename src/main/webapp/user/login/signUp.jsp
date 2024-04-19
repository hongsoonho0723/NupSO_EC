<!-- /*
* Bootstrap 5
* Template Name: Furni
* Template Author: Untree.co
* Template URI: https://untree.co/
* License: https://creativecommons.org/licenses/by/3.0/
*/ -->
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
		<title>Furni Free Bootstrap 5 Template for Furniture and Interior Design Websites by Untree.co </title>
	
		<style>
			
			button{

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
	</head>

	<body>

		<div class="container">
			<div class="input-form-backgroud row">
			  <div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">회원가입</h4>
				<form class="validation-form" novalidate>
				  
					<div class="mb-3">
					  <label for="name">아이디</label>
					  <input type="text" class="form-control" id="name" placeholder="" value="" required>
					  <div class="invalid-feedback">
						아이디를 입력해주세요.
					  </div>
					</div>
		
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="nickname">비밀번호</label>
							<input type="text" class="form-control" id="nickname" placeholder="" value="" required>
							<div class="invalid-feedback">
								비밀번호를 입력해주세요
							</div>
						</div>
							<div class="col-md-6 mb-3">
								<label for="nickname">비밀번호 확인</label>
								<input type="text" class="form-control" id="nickname" placeholder="" value="" required>
								<div class="invalid-feedback">
									비밀번호를 입력해주세요
								</div>
							</div>
					</div>
				
		
		
				  <div class="mb-3">
					<label for="email">이름</label>
					<input type="email" class="form-control" id="email" placeholder="" required>
					<div class="invalid-feedback">
					  이름을 입력해주세요.
					</div>
				  </div>
		
				<div class="row">
						<div class="col-md-6 mb-3">
							<label for="jumin1">주민번호</label>
							<input type="text" class="form-control" id="jumin1" placeholder="" required>
							<div class="invalid-feedback">
							주민번호를 입력해주세요.
							</div>
						</div>
						<div class="col-md-2 mb-3">
							<label for="jumin2">앞 1자리 </label>
							<input type="text" class="form-control" id="jumin2" placeholder="" required>
							<div class="invalid-feedback">
							주민번호 입력해주세요.
							</div>
						</div>
					   
		
		
				</div>
		
		
				  <div class="mb-3">
					<label for="address2">주소<span class="text-muted"></span></label>
					<input type="text" class="form-control" id="address2" placeholder="">
					<div class="invalid-feedback">
						주소를 입력해주세요
					  </div>
				  </div>
		
				  
					<div class="mb-3">
					  <label for="root">전화번호</label>
					  <input type="text" class="form-control" id="root" placeholder="" required>
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
				  <button class="btn btn-primary btn-lg btn-block" type="submit">가입 완료</button>
			   
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
		  
		<script src="../js/bootstrap.bundle.min.js"></script>
		<script src="../js/tiny-slider.js"></script>
		<script src="../js/custom.js"></script>
	</body>

</html>
