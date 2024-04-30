<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<!doctype html>
		<html lang="en">

		<head>
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<meta name="author" content="Untree.co">
    		<link rel="shortcut icon" href="${path}/assets/images/cow.png">
    
			<meta name="description" content="" />
			<meta name="keywords" content="bootstrap, bootstrap4" />

			<!-- Bootstrap CSS -->
			<link href="${path}/assets/css/bootstrap.min.css" rel="stylesheet">
			<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
				rel="stylesheet">
			<link href="${path}/assets/css/tiny-slider.css" rel="stylesheet">
			<link href="${path}/assets/css/style.css" rel="stylesheet">
			<title>결제하기</title>
		
		<!-- 달력에 필요함 -->
		  <link href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css" rel="stylesheet">
		  <link href="/resources/demos/style.css">
		  <script src="https://code.jquery.com/jquery-3.6.0.js" rel="stylesheet"></script>
		  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
		
		<!-- 결제 api-->
			<!-- iamport.payment.js -->
			<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>


		  <script>
		  $(function(){
			  
			  selectAll()
			  
			  // 쉼표를 추가하여 숫자를 포맷하는 함수
				function numberWithCommas(x) {
				return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
				}
			  
			  
			/* 달력 클릭시 이벤트 */
		    $("#datepicker").datepicker({
		        dateFormat: 'y/mm/dd', // 날짜 형식 설정
		        yearRange: 'c-100:c+10', // 연도 범위 설정 (예: 현재 연도로부터 100년 전부터 10년 후까지)
		        changeMonth: true, // 월 변경 기능 활성화
		        changeYear: true // 연도 변경 기능 활성화
		    });
		    
		    function selectAll(){
	        	$.ajax({
	        		 url: "ajax/checkout", //통신할 서버의 주소
					 type: "post", //요청방식(get | post | put | delete | fetch)
					 dataType:"json", //서버가 보내오는 응답데이터타입(text | html | xml | json)
					 data: { key: "cartAjax", methodName: "selectAll" },
					success :function(result , status){
						  //화면갱신
						  console.log("result = "+result)
						  let table="";
						  let str="";
						  let total=0;
						  $.each(result,function(index,item){
							/*   상품이름 색상 수량 금액 */
					              table += "<tr>";
					              table += "<td><h2 class='h5 text-black'>"+item.furnitureDTO.furnitureName+"</h2></td>";
					              table += "<td>" + item.colorName + "</td>";
					              table += "<td>" + item.quantity + "</td>";
					              table += "<td>" + item.furnitureDTO.price + "</td>";
					              table += "</tr>";												
					              
					              total += (item.furnitureDTO.price*item.quantity);
					              
					         });
								$("#listTable tr:gt(0)").remove();
					            $("#listTable").append(table); 
					            $("#totalInput").val(total);
					            $("#total").text(numberWithCommas(total+" 원"));
					            
					 },
					 error : function(err, status){
						 //통신에 실패하면 해야할 일 
						 alert(err+"발생했어요 status :" + status);
					 }
				 });//ajax end
		    
		    };//selectAll end
			    
		  });//load end
		  </script>


<!-- 주소api script -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
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

		</head>

	<body>
	 <!-- Start Header/Navigation -->
    <jsp:include page="assets/common/user/header.jsp"></jsp:include>

			<div class="untree_co-section">
				<div class="container">

					<div class="row">
						<div class="col-md-6 mb-5 mb-md-0">
							<h2 class="h3 mb-3 text-black">주문서</h2>
						<form id="orderForm" method="post" action="front">
							<div class="p-3 p-lg-5 border bg-white">
								<div class="form-group row">
									<div class="col-md-12">
										<label for="sample6_address" class="text-black">배송지 <span
												class="text-danger">*</span></label>
										<input type="text" class="form-control" id="addr1" name="addr1" placeholder="우편번호 주소" readonly>
									
									</div>
									
									<p>
										<div class="col-md-10">

											
												<input type="text" class="form-control" id="addr2" name="addr2"
													placeholder="상세주소를 입력해주세요">
													
											

										</div>
										<div class="col-md-2" style="margin: auto;">
											<!-- <button style="width: 70px; height: 30px;" value="">변경</button> -->
											<input type="button" onclick="sample6_execDaumPostcode()" value="주소 찾기">
										</div>
										
										
								</div>
								<br>
								<div class="form-group row">
									<div class="col-md-12">
										<label for="c_address" class="text-black">받는분(이름) <span
												class="text-danger">*</span></label>
										<input type="text" class="form-control" id="name" name="name"
											placeholder="">
									</div>
								</div>
								<br>
								<div class="form-group row">
									<div class="col-md-12">
										<label for="c_address" class="text-black">받는분(번호) <span
												class="text-danger">*</span></label>
										<input type="text" class="form-control" id="phone" name="phone"
											placeholder="">
									</div>
								</div>
								<br>
								<p>배송날짜 : <input type="text" id="datepicker" name="date"></p>
								<br>
								<div class="form-group">
									<label for="c_order_notes" class="text-black">배송메모</label>
									<textarea name="memo" id="memo" cols="30" rows="5"
										class="form-control" placeholder="요청사항을 입력해주세요"></textarea>
								</div>

							</div>
							<input type="hidden" name="key" value="order">
							<input type="hidden" name="methodName" value="insertOrder">
							<input type="hidden" id="totalInput" name="totalPrice">
							</form>
							
							
							
						</div>
						<div class="col-md-6">



							<div class="row mb-5">
								<div class="col-md-12">
									<h2 class="h3 mb-3 text-black">주문상세</h2>
									<div class="p-3 p-lg-5 border bg-white">
									
									
									
									<!-- //////////////////////// -->
									
									
								<table class="table site-block-order-table mb-5">
											<thead>
												<th>상품이름</th>
												<th>색상</th>
												<th>수량</th>
												<th>금액</th>
											</thead>
											<tbody id="listTable">
											
											</tbody>
											
											<tfoot>
												<th>총 금액 :</th>
												<th></th>
												<th></th>
												<th id="total"></th>
											</tfoot>
											
											
											
										</table>

							
									
									
									<!-- /////////////////////// -->

										<div class="border p-3 mb-5">
											<h3 class="h6 mb-0"><a class="d-block" data-bs-toggle="collapse"></a>
													

											<!--////////결제수단-->

											<div class="ContentWrapper_article__1qahd">
																						
												<div class="PaymentMethodItem_article__2AASS">
													<div class="PaymentMethodLabel_article__2FrYH">
														<div class="PaymentMethodLabel_section-label__ifCBQ">
														<input type="radio" id="general-payment-item" name="payment"
																class="PaymentMethodLabel_label-input__knOyW"
																disabled="">
																
																
																<label for="general-payment-item"
																class="PaymentMethodLabel_label-text__2YQb8"><span
																	class="PaymentMethodLabel_area-text__2MvU-"><span
																		class="PaymentMethodLabel_icon__3rc0M"><svg
																			width="22" height="22" viewBox="0 0 22 23">
																		
																		</svg></span>
																		
																		<span class="PaymentMethodLabel_text__2n7PP">카카오페이</span></span></label>
														</div>
													</div>
												</div>
											</div>
											
										</div>

										<div class="form-group" align="right">
											<button id="btn" class="btn btn-black btn-lg py-3 btn-block">주문하기</button>
										</div>

									</div>
								</div>
							</div>

						</div>
					</div>
					<!-- </form> -->
				</div>
			</div>

			<script src="${path}/assets/js/bootstrap.bundle.min.js"></script>
			<script src="${path}/assets/js/tiny-slider.js"></script>
			<script src="${path}/assets/js/custom.js"></script>
			
			<!--포트원 결제  -->
			<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
			<script src="${path}/assets/js/main.js"></script>
			
		</body>

		</html>