 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="author" content="Untree.co" />
	<link rel="shortcut icon" href="${path}/assets/images/cow.png">

    <meta name="description" content="" />
    <meta name="keywords" content="bootstrap, bootstrap4" />

    <!-- Bootstrap CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
      rel="stylesheet"
    />
    <link href="assets/css/tiny-slider.css" rel="stylesheet" />
    <link href="assets/css/style.css" rel="stylesheet" />
    <title>장바구니</title>

    <script type="text/javascript" src="${path}/assets/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
	$(function(){
		
		selectAll()
        
        // 쉼표를 추가하여 숫자를 포맷하는 함수
		function numberWithCommas(x) {
			return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
			}
        
        function selectAll(){
    
        	
        	
        	$.ajax({
        		 url: "ajax/cart", //통신할 서버의 주소
				 type: "post", //요청방식(get | post | put | delete | fetch)
				 dataType:"json", //서버가 보내오는 응답데이터타입(text | html | xml | json)
				 data: { key: "cartAjax", methodName: "selectAll" },
				success :function(result , status){
					  //화면갱신
					  console.log(result)
					  if(result.info!=undefined){
						  alert(result.info);
						   location.href="login.jsp"
					  }else{
						  let table="";
						  let str="";
						  let total=0;
						  $.each(result,function(index,item){
							  
					              table += "<tr>";
					              table += "<td><img src="+'${path}/assets/'+item.furnitureDTO.furnitureImgSrc+"></img></td>";
					              table += "<td><h2 class='h5 text-black'>"+item.furnitureDTO.furnitureName+"</h2></td>";
					              table += "<td>" + item.furnitureDTO.price + "</td>"; 
					              table += "<td>" + item.quantity + "</td>";
					              table += "<td>" + item.colorName + "</td>";
					              table += "<td>" + item.sizeVal + "</td>";
					              table += "<td><input type=button value='삭제' data-id="+item.furnitureSeq+"></td>";
					              table += "</tr>";												
					              
					              total += (item.furnitureDTO.price*item.quantity);
					              
					         });
								$("#listTable tr:gt(0)").remove();
					            $("#listTable").append(table);
					            $("#totalInput").val(total);
					            $("#total").text(numberWithCommas(total));

					  }//else end      
				 },
				 error : function(err, status){
					 //통신에 실패하면 해야할 일 
					 alert(err+"발생했어요 status :" + status);
					 
				 }
			 });//ajax end
        	
        }//selectAll end
        
        $(document).on("click","[value=삭제]" , function(){
        	console.log($(this).data('id'));
        	  $.ajax({
 				 url: "ajax", //통신할 서버의 주소
 				 type: "post", //요청방식(get | post | put | delete | fetch)
 				 dataType:"text", //서버가 보내오는 응답데이터타입(text | html | xml | json)
 				 data:{furnitureSeq:$(this).data('id') ,key: "cartAjax", methodName: "delete" }, //서버에게 전달할 데이터 parameter정보
 				 success :function(result , status){
 					 
 					 if(result==1)
 						 alert("삭제성공!")
 					 
 						 selectAll()
 					 
 				 },
 				 error : function(err, status){
 					 //통신에 실패하면 해야할 일 
 					 alert(err+"발생했어요 status :" + status);
 				 }
 			 });//ajax end
        	
        });
        
        //${sessionScope.userName}안되는이유 <script>태그는 자바영역이라서 body태그안인 html영역에 사용해야한다
      
        
      }); //load end
   
      
      </script>
  </head>

  <body>
    <!-- Start Header/Navigation -->
    <jsp:include page="assets/common/user/header.jsp"></jsp:include>


    <div class="untree_co-section before-footer-section">
      <div class="container">
        <div class="row mb-5">
          <form class="col-md-12" method="post">
            <div class="site-blocks-table">
              <table class="table" id="listTable">
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
                 
                </tbody>
              </table>
            </div>
          </form>
        </div>

        <div class="row">
         

          <div class="col-md-12 pl-100">
            <div class="row justify-content-end">
              <div class="col-md-10">
                <div class="row">
                  <div class="col-md-4">
                    <span class="text-black" style="font-weight: 700; font-size:30px;">총가격</span>
                  </div>
                  <div class="col-md-4" style="font-weight: 700; font-size:20px;">
                    <span class="text-black" id="total"></span>
                    <span class="text-black">원</span>
                    
                  </div>
                  
                  
                  <div class="col-md-4">
             		<form action="checkout.jsp">
		       	 	<button type="submit" id="btn" class="btn btn-black btn-lg py-3 btn-block">주문하기</button>
					</form>
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
    <script src="https://cdn.iamport.kr/v1/iamport.js"></script>

  </body>
</html>
