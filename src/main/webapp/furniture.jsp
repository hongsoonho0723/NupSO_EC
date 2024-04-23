<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<jsp:include page="assets/common/user/header.jsp"/>
<script src="${path}/assets/js/jquery-3.6.0.min.js"></script>
<script>
    //Q&A 삭제 버튼 눌렀을 경우
    $(document).on("click", "#delete", function () {
        if (confirm("삭제하시겠습니까?")) {
            const password = prompt("Q&A 등록 시 설정했던 비밀번호를 입력해주세요.");
            $.ajax({
                url: "${path}/ajax",
                type: "post",
                dataType: "text",
                data: {key: "qna", methodName: "delete", qnaSeq: ('#qnaSeq').val(),password:password},
                success: function (result) {
                    if (result === 0) alert("삭제에 실패했습니다.");
                    else location.reload();
                }
            });
        }
    });
</script>
<!-- Start Hero Section -->
<div class="hero">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-lg-5">
                <div class="intro-excerpt">
                    <h1>${furnitureDTO.furnitureName}</h1>
                    <p class="mb-4">가구 보기</p>
                    <form method="get" action="showRoom.jsp">
                        <input type="hidden" value="[Fabric,Wood]" name="texture">
                        <input type="hidden" value="single sofa" name="category">
                        <input type="hidden" value="Mild Sofa" name="sofaName">
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
                                        <option value="1">25*50*100</option>
                                        <option value="2">50*75*200</option>
                                        <option value="3">80*90*700</option>
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

            <%--            상품 이미지 출력  --%>
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
                <img src="${path}/assets/images/img-grid-1.jpg">
                <img src="${path}/assets/images/img-grid-1.jpg">
                <img src="${path}/assets/images/img-grid-1.jpg">
            </div>

            <%--                상품 리뷰 탭 --%>
            <div class="tab_content" id="review_content">

                <div class="customer-review">
                    <h3 class="small-title">Customer review</h3>
                    상품을 구매하신 분들이 작성한 리뷰입니다.<br><br>
                    <ul class="product-comments clearfix">
                        <li class="mb-30">
                            <div class="pro-reviewer">
                                <img src="${path}/assets/images/person-1.jpg" alt="">
                            </div>
                            <div class="pro-reviewer-comment">
                                <div class="fix">
                                    <div class="pull-left mbl-center">
                                        <h5><strong>Gerald Barnes</strong></h5>
                                        <p class="reply-date">27 Jun, 2016 at 2:30pm</p>
                                    </div>
                                    <div class="comment-reply pull-right">
                                        ⭐️
                                    </div>
                                </div>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer accumsan egestas
                                    elese ifend. Phasellus a felis at est bibendum feugiat ut eget eni Praesent et
                                    messages in con sectetur posuere dolor non.</p>
                            </div>
                        </li>
                        <li class="threaded-comments">
                            <div class="pro-reviewer">
                                <img src="${path}/assets/images/person_2.jpg" alt="">
                            </div>
                            <div class="pro-reviewer-comment">
                                <div class="fix">
                                    <div class="pull-left mbl-center">
                                        <h5 class="text-uppercase mb-0"><strong>Gerald Barnes</strong></h5>
                                        <p class="reply-date">27 Jun, 2016 at 2:30pm</p>
                                    </div>
                                    <div class="comment-reply pull-right">
                                        <c:forEach begin="1" end="3">
                                            ⭐
                                        </c:forEach>
                                    </div>
                                </div>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer accumsan egestas
                                    elese ifend. Phasellus a felis at est bibendum feugiat ut eget eni Praesent et
                                    messages in con sectetur posuere dolor non.</p>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>

            <%--                상품에 대한 Q&A 탭 --%>
            <div class="tab_content" id="qna_content">

                <div class="customer-review">
                    <div class="row">
                        <h3 class="small-title">Q & A</h3>
                        구매하시려는 상품에 대헤 궁금한 점이 있으면 문의해주세요.
                        <a href="qna/qna.jsp" class="btn btn-secondary me-2">Go to Q&A</a>
                    </div>
                    <br><br>
                    <ul class="product-comments clearfix">
                        <li class="mb-30">
                            <div class="pro-reviewer-comment">
                                <div class="fix">
                                    <div class="pull-left mbl-center">
                                        <h5><strong>Gerald Barnes</strong></h5>
                                        <p class="reply-date">27 Jun, 2016 at 2:30pm</p>
                                    </div>
                                    <div class="comment-reply pull-right">
                                        <a href="#"><i class="fa fa-reply"></i></a>
                                        <a href="#"><i class="fa fa-close"></i></a>
                                    </div>
                                </div>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer accumsan egestas
                                    elese ifend. Phasellus a felis at est bibendum feugiat ut eget eni Praesent et
                                    messages in con sectetur posuere dolor non.</p>
                            </div>
                        </li>

                        <li class="mb-30 col-lg-12">
                            <div class="pro-reviewer-comment">
                                <div class="fix">
                                    <div class="pull-left mbl-center">
                                        <h5><strong>Gerald Barnes</strong></h5>
                                        <p class="reply-date">27 Jun, 2016 at 2:30pm</p>
                                    </div>
                                    <div class="comment-reply pull-right">
<%--                                        Q&A 답변 페이지--%>
                                        <a href="#"><i class="fa fa-reply"></i></a>
                                        <form method="post">
                                            <span id="delete">
                                            <i class="fa fa-close"></i>
                                            <input type="hidden" name="key" value="qna">
                                            <input type="hidden" name="methodName" value="delete">
<%--                                                <input type="hidden" id="qnaSeq" value="${q.qnaSeq}">--%>
                                                </span>
                                        </form>
                                    </div>
                                </div>
                                <p>TESTTESTESTSTETSTSETSETTE</p>
                            </div>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
<jsp:include page="assets/common/user/footer.jsp"/>