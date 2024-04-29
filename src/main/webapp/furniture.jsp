<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<jsp:include page="assets/common/user/header.jsp"/>
<script src="${path}/assets/js/jquery-3.6.0.min.js"></script>
<style>
	#qna_content > div > ul > li > div > div.pull-left.mbl-center.answer-section{display:none;}
	.pull-left.mbl-center>h6{display:none;}
</style>
<script>
    //Q&A 삭제 버튼 눌렀을 경우
    
    $(function(){
    	
        $(document).on("click", ".delete-button", function () {
        	event.preventDefault(); // 기본 동작 방지
        	let reviewerComment = $(this).closest(".pro-reviewer-comment");
        	let qnaSeq = reviewerComment.find(".mbl-center h6>strong.qnASeq").text();
        	let qnaPassword = reviewerComment.find(".mbl-center h6>strong.password").text();
        	
            if (confirm("삭제하시겠습니까?")) {
                const password = prompt("Q&A 등록 시 설정했던 비밀번호를 입력해주세요.");
                if(qnaPassword===password){
                    $.ajax({
                        url: "${path}/ajax",
                        type: "post",
                        dataType: "text",
                        data: {key: "qnaAjax", methodName: "delete", qnaSeq: qnaSeq,password:password},
                        success: function (result) {
                        	event.preventDefault(); // 기본 동작 방지
                            alert("삭제에 성공했습니다.");
                        	location.reload();
                        }, 
                        error: function(err) {
                        	console.log(err)
                           alert(err);
                        }
                    });
                    
                }else{
                	alert("비밀 번호가 일치하지 않습니다.")
                }
         
            }
        });//삭제 이벤트 end
        
        $(document).on("click",".reply-button",function(){
        	 event.preventDefault(); // 기본 동작 방지
        	 let reviewerComment = $(this).closest(".pro-reviewer-comment");
        	 
        	 let answerText = reviewerComment.find(".answer-section h5>strong").text();
        	 
        	 if(answerText.trim()!==""){
        		 reviewerComment.find(".answer-section").toggle();
        	 }else{
        		 alert("답변내용이 없습니다! 관리자에게 문의해주세요");
        	 }
        	
        });//답변 이벤트 end
        
        
        
    	
    });// ready end

</script>
<!-- Start Hero Section -->
<div class="hero">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-lg-5">
                <div class="intro-excerpt">
                    <h1>${furnitureDTO.furnitureName}</h1>
                    <p class="mb-4">쇼파에 맞는 눕소의 추천 인테리어</p>
                    <form method="get" action="${path}/showRoom.jsp">
                        <input type="hidden" value="${furnitureDTO.texture}" name="texture">
                        <input type="hidden" value="${furnitureDTO.category}" name="category">
                        <input type="hidden" value="${furnitureDTO.furnitureName}" name="sofaName">
                        <input type="hidden" value="${furnitureDTO.furnitureDescription}" name="description">
                        <p><button type="submit" class="btn btn-secondary me-2">Show Room으로 확인하기</button></p>
                    </form>
                </div>
            </div>
            <div class="col-lg-7">
                <div class="hero-img-wrap">
                    <img src="${path}/assets/${furnitureDTO.furnitureImgSrc}" class="img-fluid">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Hero Section -->


<!-- Start Why Choose Us Section -->
<div class="why-choose-section">
    <div class="container">
        <div class="row justify-content-between align-items-center">
            <div class="col-lg-6">
                <h2 class="section-title">${furnitureDTO.furnitureName}</h2>
                <p>${furnitureDTO.furnitureDescription}</p>

                <div class="row my-5">
                    <div class="col-md-7 col-sm-12 col-xs-12">
                        <div class="feature">
                            <table class="table site-block-order-table mb-5">
                                <tr>
                                    <td class="text-black font-weight-bold"><strong>가격</strong></td>
                                    <td class="text-black font-weight-bold"><strong><fmt:formatNumber value ="${furnitureDTO.price}"/></strong></td>
                                </tr>
                                <tr>
                                    <td>상품코드</td>
                                    <td>${furnitureDTO.furnitureNumber}</td>
                                </tr>
                                <tr>
                                    <td>종류</td>
                                    <td>${furnitureDTO.category}</td>
                                </tr>

                                <tr>
                                    <td>재질</td>
                                    <td>${furnitureDTO.texture}</td>
                                </tr>
                                <tr>
                                    <td>배송비</td>
                                    <td>무료</td>
                                </tr>
                                <tr>
                                    <td>사이즈</td>
                                    <td><select>
                                        <option value="0">사이즈 선택</option>
                                        <c:forEach items="${furnitureDTO.sizeList}" var="item" varStatus="state">
                                        	<option value="${state.index}">${item.sizeVal}</option>
                                         </c:forEach>
                                    </select></td>
                                </tr>
                                <tr>
                                    <td>색상</td>
                                    <td><select>
                                    		<option value="0">색상 선택</option>
                                    	<c:forEach items="${furnitureDTO.colorList}" var="item" varStatus="state">
                                        	<option value="${state.index}">${item.colorName}</option>
                                         </c:forEach>
                                    </select></td>
                                </tr>      	
                                <tr>
                                    <td>수량</td>
                                    <td><select>
                                    		<option value="0">수량 선택</option>
                                    	<c:forEach begin="1" end="${furnitureDTO.stock}" var="index">
    										<option value="${index}">${index}</option>
										</c:forEach>
                                    </select></td>
                                </tr>
                            </table>

                            <div class="form-group">
                                <p>
                                    <a href="" class="btn btn-secondary me-2">♥️</a>
                                    <a href="" class="btn btn-secondary me-2">🛍️</a>
                                    <button class="btn btn-black btn-lg py-3 btn-block"
                                            onclick="window.location='thankyou.html'">구매하기
                                    </button>
                                </p>

                            </div>

                        </div>
                    </div>
                </div>


            </div>

            <%--            상품 슬라이드 이미지 출력  --%>
            <div class="col-md-6 col-sm-12 col-xs-12">
                <div class="img-wrap">

                    <div class="row justify-content-center">
                        <div class="testimonial-slider-wrap text-center">

                            <div id="testimonial-nav">
                                <span class="prev" data-controls="prev"><span class="fa fa-chevron-left"></span></span>
                                <span class="next" data-controls="next"><span class="fa fa-chevron-right"></span></span>
                            </div>

                            <div class="testimonial-slider">
								<c:forEach items="${furnitureDTO.imgList}" var="item">
	                                <div class="item">
	                                    <div class="row justify-content-center">
	                                        <div class="col-lg-8 mx-auto">
	                                            <div class="author-pic">
	                                                <img src="${path}/assets/${item.imgSrc}" alt="image furniture"
	                                                     class="img-fluid">
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
								</c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Why Choose Us Section -->


        <div class="tabs">
            <input id="detail" type="radio" name="tab_item" checked>
            <label class="tab_item" for="detail">Product Detail</label>
            <input id="review" type="radio" name="tab_item">
            <label class="tab_item" for="review">Review</label>
            <input id="qna" type="radio" name="tab_item">
            <label class="tab_item" for="qna">Q & A</label>

            <%--                상품 상세 설명 탭 --%>
            <div class="tab_content" id="detail_content">
            	<c:forEach items="${furnitureDTO.imgDetailList}" var="item">
               	 	<img src="${path}/assets/${item.imgSrc}">
                </c:forEach>
            </div>

            <%--                상품 리뷰 탭 --%>
            <div class="tab_content" id="review_content">

                <div class="customer-review">
                    <h3 class="small-title">Customer review</h3>
                    상품을 구매하신 분들이 작성한 리뷰입니다.<br><br>
                   <c:forEach items="${furnitureDTO.reviewList}" var="item">
                    <ul class="product-comments clearfix">
	                        <li class="mb-30">
	                            <div class="pro-reviewer-comment">
	                              <div class="pro-reviewer">
		                             <c:forEach items="${item.reviewImgs}" var="reviewImg">   
		                                <img src="assets/img/${reviewImg.imgSrc}" alt="이미지" width="150" height="150">
	                                 </c:forEach>
	                            	</div>
	                                <div class="fix">
	                                    <div class="pull-left mbl-center">
	                                        <h5><strong>${item.user.name}</strong></h5>
	                                        <c:forEach var="i" begin="1" end="${item.score}">
	                                       		 ⭐
	                                    	</c:forEach>
	                                        <p class="reply-date">${item.regDate}</p>
	                                    </div>             
	                                    <div class="comment-reply pull-right">
	                                    	<br>
	                                	</div>
	                                	 <div>
		                                	<p>${item.review}</p>
		                                </div>
                                	</div>
	                            </div>
	                        </li>
                    </ul>
               	 </c:forEach>
                </div>
                
            </div>

            <%--                상품에 대한 Q&A 탭 --%>
            <div class="tab_content" id="qna_content">

                <div class="customer-review">
                    <div class="row">
                        <h3 class="small-title">Q & A</h3>
                        구매하시려는 상품에 대헤 궁금한 점이 있으면 문의해주세요.
                        <a href="qna.jsp?furnitureSeq=${furnitureDTO.furnitureSeq}&furnitureImgSrc=${furnitureDTO.furnitureImgSrc}" class="btn btn-secondary me-2">Go to Q&A</a>
                    </div>
                    <br><br>
                   	<c:forEach items="${furnitureDTO.qnaList}" var="item">
                    <ul class="product-comments clearfix">
                        <li class="mb-30">
                            <div class="pro-reviewer-comment">
                                <div class="fix">
                                    <div class="pull-left mbl-center">
                                    	<h6><strong class="qnASeq">${item.qnASeq}</strong></h6>
                                    	<h6><strong class="password">${item.password}</strong></h6>
                                        <h5><strong>${item.name}</strong></h5>
                                        <p class="reply-date">${item.regDate}</p>
                                    </div>
                                    <div class="comment-reply pull-right">
                                        <a href="#" class="reply-button"><i class="fa fa-reply"></i></a>
                                        <a href="#" class="delete-button"><i class="fa fa-close"></i></a>
                                    </div>
                                </div>
                                <p>${item.question}</p>
                                 <div class="pull-left mbl-center answer-section" >
                                      <h5><strong>${item.answer}</strong></h5>
                                       <p class="answer-date">${item.answerDate}</p>
                                 </div>
                            </div>
                        </li>
                    </ul>
                  	</c:forEach>
                </div>
            </div>
        </div>
    </div>

</div>
<jsp:include page="assets/common/user/footer.jsp"/>