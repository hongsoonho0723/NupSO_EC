<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>


<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="author" content="Untree.co">
  <meta name="description" content="" />
  <meta name="keywords" content="bootstrap, bootstrap4" />

		
	<link href="assets/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
	<link href="assets/css/tiny-slider.css" rel="stylesheet">
	<link href="assets/css/style.css" rel="stylesheet">
		
	<script src="assets/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		
	$(function(){
		$(document).on("click",".product-review-btn",function(){
			
			if($(".product-order-state").text().trim() !== "배송 완료"){
				event.preventDefault();
				alert("배송 완료된 후 리뷰를 작성할 수 있습니다.");
				return;
			}
			
		})// 클릭 이벤트 끝		
		
		
		 	if("${message}"!== ""){
				alert("${message}");
			}
	})



	</script>
	<jsp:include page="assets/common/user/header.jsp"/>
		
		
	<title>MyPage</title>
</head>

<body>
		
		<!-- Start Menu Section -->
		<jsp:include page="assets/common/user/mypageMenu.jsp"/>
		<!-- End Menu Section -->

		<div class="untree_co-section before-footer-section">
            <div class="container">
              <div class="row mb-5">
                <form class="col-md-12" method="post" action="${path}/review.jsp">
                  <div class="site-blocks-table">
                  	<div class="intro-excerpt">
						<h1>주문 내역</h1>
					</div>
                    <table class="table">
                      <thead>
                        <tr>
                          <th>상품 이미지</th>
                          <th>이름</th>
                          <th>재질</th>
                          <th>색상</th>
                          <th>사이즈</th>
                          <th>수량</th>
                          <th>총 가격</th>
                          <th>배송 상태</th>
                          <th>리뷰</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                        	<c:forEach items="${list}" var="item">
                        	<tr>
		                          <td class="product-thumbnail"><img src="assets/${item.furniture.furnitureImgSrc}" alt="경로에 이미지가 없음" width="100" height="100"></td>
		                          <td class="product-name">${item.furniture.furnitureName}</td>
		                          <td class="product-texture">${item.furniture.texture}</td>
		                          <td class="product-color">${item.orderInfo.colorName}</td>
		                          <td class="product-size">${item.orderInfo.sizeVal}</td>
		                          <td class="product-quantity">${item.orderInfo.quantity}</td>
		                          <td class="product-total">${item.totalPrice}</td>
		                          <td class="product-order-state">${item.deliveryState}</td>
		                          <td><button class="product-review-btn">리뷰작성</button></td>
		                          <td> <input type="hidden" value="${item.furniture.furnitureSeq}" id="furnitureSeq" name="furnitureSeq">
                        				<input type="hidden" value="${item.furniture.furnitureImgSrc}" id="furnitureImgSrc" name="furnitureImgSrc"></td>
                       		 </tr>
                        	</c:forEach>  
                        </tr>
                      </tbody>
                    </table>
                    <br>
                    <br>
                  </div>
                </form>
              </div>
             </div>
            </div>
        <br>
		<jsp:include page="assets/common/user/footer.jsp"/>
		


		<script src="assets/js/bootstrap.bundle.min.js"></script>
		<script src="assets/js/tiny-slider.js"></script>
		<script src="assets/js/custom.js"></script>
	</body>

</html>
