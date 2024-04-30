<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<style>
input[type="text"], input[type="number"] {
    background-color: #DCDCDC; /* 기본 배경색은 회색 */
}

input[type="text"]:focus, input[type="number"]:focus {
    background-color: #fff; /* 입력 필드에 포커스가 있을 때는 흰색으로 변경 */
}

.text-black{
	font-weight: bold;
	margin-bottom: 5px;
	margin-top: 5px;
}

</style>
<script src="${path}/assets/js/jquery-3.6.0.min.js"></script>
<!-- 다음 주소 API 스크립트 추가 -->
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script>
	function openPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 검색결과 항목을 클릭했을때 실행할 코드를 작성.
				document.getElementById('addr').value = data.address; // 주소 넣기
				document.getElementById('zonecode').value = data.zonecode; // 우편번호 넣기
			}
		}).open();
	}
</script>
<jsp:include page="assets/common/user/header.jsp" />
<jsp:include page="assets/common/user/mypageMenu.jsp" />


<!-- Start Edit Profile Form -->
<div class="untree_co-section">
	<div class="container">
		<div class="block">
			<div class="intro-excerpt">
				<h1>개인 정보 수정</h1>
				<p class="mb-4">회원님의 정보를 수정해주세요.</p>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-8 col-lg-8 pb-4">
					<form method="post" action="updateProfile.jsp">
						<!-- Form action 경로 수정 필요 -->
						<div class="row">
							<div class="col-6">
								<div class="form-group">
									<label class="text-black" for="name">이름</label> <input
										type="text" class="form-control" id="name" name="name"
										value="">
								</div>
							</div>
							<div class="col-6">
								<div class="form-group">
									<label class="text-black" for="password">패스워드</label> <input
										type="text" class="form-control" id="password" name="password"
										value="">
								</div>
							</div>
							<div class="col-6">
								<div class="form-group">
									<label class="text-black" for="age">나이</label> <input
										type="number" class="form-control" id="age" name="age"
										value="">
								</div>
							</div>
							<div class="col-6">
								<div class="form-group">
									<label class="text-black" for="phone">전화번호</label> <input
										type="text" class="form-control" id="phone" name="phone"
										value="">
								</div>
							</div>
							<div class="col-6">
								<div class="form-group">
									<label class="text-black" for="addr">주소</label> <input
										type="text" class="form-control" id="addr" name="addr"
										value="" readonly> <input type="hidden"
										id="zonecode" name="zonecode">
									<button type="button" onclick="openPostcode()"
										class="btn btn-secondary mt-2">주소 검색</button>
								</div>
							</div>
							
						</div>
						
					</form>
					
				</div>
				<button type="button" onclick="updateUser()" class="btn btn-primary-hover-outline" style="width: 40%;">정보 수정</button>
			</div>
		</div>
	</div>
</div>

<script>
$(document).ready(function() {
	let rootPath = '${path}';
	 
	  $.ajax({
	    url: rootPath + '/ajax?key=userAjax&methodName=selectUserBySeq',
	    type: 'GET',
			dataType : 'json',
			success : function(user) {
				// 서버로부터 받은 데이터로 폼의 입력 값 설정
				console.log(user);
				$('#name').val(user.name);
				$('#password').val(user.password);
				$('#age').val(user.age);
				$('#phone').val(user.phone);
				$('#addr').val(user.addr);

			},
			error : function() {
				alert('정보 로딩 실패');
			}
		});
	});

function updateUser() {
    let rootPath = '${path}';
    let formData = {
        name: $('#name').val(),
        password: $('#password').val(),
        age: $('#age').val(),
        phone: $('#phone').val(),
        addr: $('#addr').val()
    };

    $.ajax({
        url: rootPath + '/ajax?key=userAjax&methodName=updateUserBySeq',
        type: 'POST',
        data: formData,
        success: function(result) {
            alert("수정 완료");
        },
        error: function() {
            alert('수정 실패');
        }
    });
}
</script>

<!-- End Edit Profile Form -->

<jsp:include page="assets/common/user/footer.jsp" />
