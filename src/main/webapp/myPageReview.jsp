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
	<jsp:include page="assets/common/user/header.jsp"/>
		
		
	<title>My Review</title>
</head>

<body>
		
		<!-- Start Menu Section -->
		<jsp:include page="assets/common/user/mypageMenu.jsp"/>
		<!-- End Menu Section -->

		<div class="untree_co-section before-footer-section">
            <div class="container">
              <div class="row mb-5">
                <form class="col-md-12" method="post" action="${path}/front">
                  <div class="site-blocks-table">
                  	<div class="intro-excerpt">
						<h1>리뷰 조회</h1>
					</div>
                    <table class="table">
                      <thead>
                        <tr>
                          <th>상품 이미지</th>
                          <th>이름</th>
                          <th>점수</th>
                          <th>리뷰</th>
                          <th>등록일</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                        	<c:forEach items="${list}" var="item">
                        	<tr>
		                          <td class="product-thumbnail"><img src="assets/${item.furniture.furnitureImgSrc}" alt="경로에 이미지가 없음" width="100" height="100"></td>
		                          <td class="user-name">${item.furniture.furnitureName}</td>
		                          <td class="review-score">${item.score}</td>
		                          <td class="review-context">${item.review}</td>
		                          <td class="review-date">${item.regDate}</td>
		                          <td><button class="del-btn">리뷰삭제</button></td>
		                          <td> <input type="hidden" value="${item.reviewSeq}" id="reviewSeq" name="reviewSeq">
		                          		<input type="hidden" value="mypage" id="mypage" name="mypage">
                        				<input type="hidden" value="review" id="key" name="key">
                       					 <input type="hidden" value="delete" id="methodName" name="methodName"></td>
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
