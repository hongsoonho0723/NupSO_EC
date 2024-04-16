<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<jsp:include page="../common/header.jsp"/>

<!-- Start Hero Section -->
<div class="hero">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-lg-5">
                <div class="intro-excerpt">
                    <h1>PRODUCT DETAIL</h1>
                    <p class="mb-4">상품 보기</p>
                    <p><a href="" class="btn btn-secondary me-2">전체 상품</a></p>
                </div>
            </div>
            <div class="col-lg-7">
                <div class="hero-img-wrap">
                    <img src="${path}/user/images/couch.png" class="img-fluid">
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
                <h2 class="section-title">${requestScope.furnDTO.FURNITURE_NAME}</h2>
                <p>${requestScope.furnDTO.FURNITURE_DISCRIPTION}</p>

                <div class="row my-5">

                    <%--                    <div class="col-6 col-md-6">--%>
                    <div class="col-md-7 col-sm-12 col-xs-12">
                        <div class="feature">
                            <%--        <div class="p-3 p-lg-5 border bg-white">--%>
                            <table class="table site-block-order-table mb-5">
                                <tr>
                                    <td class="text-black font-weight-bold"><strong>가격</strong></td>
                                    <td class="text-black font-weight-bold"><strong><fmt:formatNumber
                                            value="${requestScope.furnDTO.price}"/>원</strong></td>
                                </tr>
                                <tr>
                                    <td>상품코드</td>
                                    <td>${requestScope.furnDTO.FURNITURE_NUMBER}</td>
                                </tr>
                                <tr>
                                    <td>종류</td>
                                    <td>${requestScope.furnDTO.CATEGORY}</td>
                                </tr>

                                <tr>
                                    <td>재질</td>
                                    <td>${requestScope.textureList}</td>
                                </tr>
                                <tr>
                                    <td>배송비</td>
                                    <td>무료</td>
                                </tr>
                                <tr>
                                    <td>사이즈</td>
                                    <td><select>
                                        <option value="0">사이즈 선택</option>
                                        <c:forEach items="${requestScope.sizeList}" var="size" varStatus="status">
                                            <option value="${status.count}">${status.current}</option>
                                        </c:forEach></select></td>
                                </tr>
                                <tr>
                                    <td>색상</td>
                                    <td><select>
                                        <option value="0">색상 선택</option>
                                        <c:forEach items="${requestScope.colorList}" var="color" varStatus="status">
                                            <option value="${status.count}">${status.current}</option>
                                        </c:forEach></select></td>
                                </tr>
                            </table>

                            <div class="border p-3 mb-5">
                                <h3 class="h6 mb-0"><a class="d-block" data-bs-toggle="collapse" href="#collapsepaypal"
                                                       role="button" aria-expanded="false"
                                                       aria-controls="collapsepaypal">Paypal</a></h3>

                                <div class="collapse" id="collapsepaypal">
                                    <div class="py-2">
                                        <p class="mb-0">
                                            Make your payment directly into our bank account. Please use
                                            your Order ID as the payment reference. Your order won’t be shipped until
                                            the funds have cleared in our account.
                                        </p>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <%--                                <button class="btn btn-black btn-lg py-3 btn-block"--%>
                                <%--                                        onclick="window.location='thankyou.html'">장바구니--%>
                                <%--                                </button>--%>

                                <p>
                                    <%--                                    <a href="" class="btn btn-secondary me-2">장바구니</a>--%>
                                    <%--                                    <a href="#" class="btn btn-white-outline">구매하기</a>--%>
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

                            <%--                            상품 이미지 --%>
                            <div class="testimonial-slider">
                                <c:forEach items="${requestScope.imgList}" var="img">
                                    <div class="item">
                                        <div class="row justify-content-center">
                                            <div class="col-lg-8 mx-auto">
                                                <div class="author-pic">
                                                    <img src="${img.img_src}.${img.img_type}" alt="image furniture"
                                                         class="img-fluid">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                                <!-- END item -->
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
                <c:forEach items="${requestScope.imgDetailList}" var="detail">
                    <img src="${detail.img_src}.${detail.img_type}">
                </c:forEach>
            </div>

            <%--                상품 리뷰 탭 --%>
            <div class="tab_content" id="review_content">
                <div class="customer-review">
                    <h3 class="small-title">Customer review</h3>
                    상품을 구매하신 분들이 작성한 리뷰입니다.<br><br>
                    <ul class="product-comments clearfix">

                        <li class="mb-30">
                            <div class="pro-reviewer">
                                <img src="../images/person-1.jpg" alt="">
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
                                <img src="../images/person_2.jpg" alt="">
                            </div>
                            <div class="pro-reviewer-comment">
                                <div class="fix">
                                    <div class="pull-left mbl-center">
                                        <h5 class="text-uppercase mb-0"><strong>Gerald Barnes</strong></h5>
                                        <p class="reply-date">27 Jun, 2016 at 2:30pm</p>
                                    </div>
                                    <div class="comment-reply pull-right">
                                        ⭐️⭐️⭐️⭐️
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
                    <h3 class="small-title">Q & A</h3>
                    구매하시려는 상품에 대헤 궁금한 점이 있으면 문의해주세요.<br><br>
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
                        <li class="threaded-comments">
                            <div class="pro-reviewer">
                                <img src="../images/person_2.jpg" alt="">
                            </div>
                            <div class="pro-reviewer-comment">
                                <div class="fix">
                                    <div class="pull-left mbl-center">
                                        <h5 class="text-uppercase mb-0"><strong>Gerald Barnes</strong></h5>
                                        <p class="reply-date">27 Jun, 2016 at 2:30pm</p>
                                    </div>
                                    <div class="comment-reply pull-right">
                                        <a href="#"><i class="fa fa-reply"></i></a>
                                        <a href="#"><i class="fa fa-close"></i></a>
                                    </div>
                                </div>
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer accumsan egestas
                                    elese ifend. Phasellus a felis at est bibendum feugiat ut eget eni Praesent et
                                    messages in con sectetur posuere dolor non.
                                </p>
                            </div>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="../common/footer.jsp"/>