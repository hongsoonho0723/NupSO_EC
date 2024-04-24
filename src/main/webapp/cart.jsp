<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="author" content="Untree.co">
  <link rel="shortcut icon" href="${path}/favicon.png">

  <meta name="description" content="" />
  <meta name="keywords" content="bootstrap, bootstrap4" />

		<!-- Bootstrap CSS -->
		<link href="${path}/assets/css/bootstrap.min.css" rel="stylesheet">
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
		<link href="${path}/assets/css/tiny-slider.css" rel="stylesheet">
		<link href="${path}/assets/css/style.css" rel="stylesheet">
		<title>Furni Free Bootstrap 5 Template for Furniture and Interior Design Websites by Untree.co </title>

<script type="text/javascript" src="${path}/assets/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		//alert(1)
		 let userName = '<%= session.getAttribute("userName") %>';
		console.log("userName = "+ userName);
		
		//${sessionScope.userName}안되는이유 <script>태그는 자바영역이라서 body태그안인 html영역에 사용해야한다
		
	})//load end


</script>

	</head>

	<body>
<div>${sessionScope.userId}</div>

		<!-- Start Hero Section -->
			<div class="hero">
				<div class="container">
					<div class="row justify-content-between">
						<div class="col-lg-5">
							<div class="intro-excerpt">
								<h1>Cart</h1>
							</div>
						</div>
						<div class="col-lg-7">
							
						</div>
					</div>
				</div>
			</div>
		<!-- End Hero Section -->

		

		<div class="untree_co-section before-footer-section">
            <div class="container">
              <div class="row mb-5">
                <form class="col-md-12" method="post">
                  <div class="site-blocks-table">
                    <table class="table">
                      <thead>
                        <tr>
                          <th class="product-thumbnail">Image</th>
                          <th class="product-name">상품명</th>
                          <th class="product-price">가격</th>
                          <th class="product-quantity">수량</th>
                          <th class="product-color">색상</th>
                          <th class="product-size">사이즈</th>
                          <th class="product-remove">삭제</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td class="product-thumbnail">
                            <img src="${path}/assets/images/product-1.png" alt="Image" class="img-fluid">
                          </td>
                          <td class="product-name">
                            <h2 class="h5 text-black">Product 1</h2>
                          </td>
                          <td>$49.00</td>
                          <td>
                            <div class="input-group mb-3 d-flex align-items-center quantity-container" style="margin: auto; max-width: 120px;">
                              <div class="input-group-prepend">
                                <button class="btn btn-outline-black decrease" type="button">&minus;</button>
                              </div>
                              <input type="text" class="form-control text-center quantity-amount" value="1" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
                              <div class="input-group-append">
                                <button class="btn btn-outline-black increase" type="button">&plus;</button>
                              </div>
                            </div>
        
                          </td>
                          <td>색상</td>
                          <td>사이즈</td>
                          <td><a href="#" class="btn btn-black btn-sm">삭제</a></td>
                        </tr>
        
                        <tr>
                          <td class="product-thumbnail">
                            <img src="${path}/assets/images/product-2.png" alt="Image" class="img-fluid">
                          </td>
                          <td class="product-name">
                            <h2 class="h5 text-black">Product 2</h2>
                          </td>
                          <td>$49.00</td>
                          <td>
                            <div class="input-group mb-3 d-flex align-items-center quantity-container" style="margin: auto; max-width: 120px;">
                              <div class="input-group-prepend">
                                <button class="btn btn-outline-black decrease" type="button">&minus;</button>
                              </div>
                              <input type="text" class="form-control text-center quantity-amount" value="1" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
                              <div class="input-group-append">
                                <button class="btn btn-outline-black increase" type="button">&plus;</button>
                              </div>
                            </div>
        
                          </td>
                          <td>색상</td>
                          <td>사이즈</td>
                          <td><a href="#" class="btn btn-black btn-sm">삭제</a></td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </form>
              </div>
                 
                </div>

                <div class="col-md-12 pl-100">
                  <div class="row justify-content-end">
                    <div class="col-md-10">

                      
                      <div class="row">
                        <div class="col-md-4">
                          <span class="text-black">total</span>
                        </div>
                        <div class="col-md-4">
                          <span class="text-black">total</span>
                        </div>
                        <div class="col-md-4">
                          <button class="btn btn-black btn-lg py-3 btn-block" onclick="window.location='checkout.jsp'">Proceed To Checkout</button>
                        </div>
                     
                      </div>
                    </div>
                  </div>
                </div>
                
              </div>
            </div>
          </div>

		<script src="${path}/assets/js/bootstrap.bundle.min.js"></script>
		<script src="${path}/assets/js/tiny-slider.js"></script>
		<script src="${path}/assets/js/custom.js"></script>
		<script src="${path}/assets/js/payment.js"></script>
		<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	</body>

</html>
