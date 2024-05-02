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
<!-- <script>
	function openPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 검색결과 항목을 클릭했을때 실행할 코드를 작성.
				document.getElementById('addr').value = data.address; // 주소 넣기
				document.getElementById('zonecode').value = data.zonecode; // 우편번호 넣기
			}
		}).open();
	}
</script> -->

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
        	
            oncomplete: function(data) {
            	document.getElementById('addr2').style.display = 'block';
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수
				addr='('+data.zonecode+') ';
                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr += data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr += data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                   // 조합된 참고항목을 해당 필드에 넣는다.
				  	 addr += extraAddr;
                
					} else {
					addr+= '';

					}
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
              	
                document.getElementById("addr1").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("addr2").focus();
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
									<label class="text-black" for="addr1">주소</label> 
									<input type="text" class="form-control" id="addr1" name="addr1" value="" readonly>
									 
									 <input type="text" class="form-control" id="addr2" name="addr2" value="" style="margin-top:10px; display: none;" placeholder="상세주소를 입력해주세요">
									
									<button type="button" onclick="sample6_execDaumPostcode()"
										class="btn btn-secondary mt-2">주소 검색</button>
								</div>
							</div>
							
						</div>
						
					</form>
					
				</div>
				<button type="button" onclick="updateUser()" class="btn btn-primary-hover-outline" style="width: 40%;">정보 수정</button>
				<form action="front" method="post">
				<button type="submit" class="btn btn-primary-hover-outline" style="width: 10%;">회원탈퇴</button>
				<input type="hidden" name="key" value="user" id="">
				<input type="hidden" name="methodName" value="deleteUser" id="deleteUser">
				<input type="hidden" name="userSeq" value="<%=session.getAttribute("userSeq")%>" id="userSeq">
				
				</form>
			</div>
		</div>
	</div>
</div>

<script>
//주소 찾기를 누르기 전에는 addr2(상세주소)를 숨김 처리
window.onload = function() {
    document.getElementById('addr2').style.display = 'none';
}

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
				$('#addr1').val(user.addr);

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
        addr: $('#addr1').val()+ " " +$('#addr2').val()
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
