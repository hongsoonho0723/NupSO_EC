<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../common/header.jsp"/>

<!-- Start Hero Section -->
<div class="hero">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-lg-5">
                <div class="intro-excerpt">
                    <h1>PRODUCT DETAIL</h1>
                    <p class="mb-4">{CATEGORY}</p>
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
                <h2 class="section-title">마일드소파</h2>
                <p>패브릭쇼파 안락 1인소파 카페의자</p>

                <div class="row my-5">

                    <%--                    <div class="col-6 col-md-6">--%>
                    <div class="col-md-6 col-sm-12 col-xs-12">
                        <div class="feature">
                            <%--        <div class="p-3 p-lg-5 border bg-white">--%>
                            <table class="table site-block-order-table mb-5">
                                <tr>
                                    <td class="text-black font-weight-bold"><strong>가격</strong></td>
                                    <td class="text-black font-weight-bold"><strong>$10000</strong></td>
                                </tr>
                                <tr>
                                    <td>상품코드</td>
                                    <td>LJD-2835</td>
                                </tr>
                                <tr>
                                    <td>카테고리</td>
                                    <td>1인용 소파</td>
                                </tr>

                                <tr>
                                    <td>재질</td>
                                    <td>fabric, wood</td>
                                </tr>
                                <tr>
                                    <td>배송비</td>
                                    <td>무료</td>
                                </tr>
                                <tr>
                                    <td>사이즈</td>
                                    <td>{옵션 토글}</td>
                                </tr>
                                <tr>
                                    <td>색상</td>
                                    <td>{옵션 토글}</td>
                                </tr>
                            </table>

                            <div class="border p-3 mb-5">
                                <h3 class="h6 mb-0"><a class="d-block" data-bs-toggle="collapse" href="#collapsepaypal"
                                                       role="button" aria-expanded="false"
                                                       aria-controls="collapsepaypal">Paypal</a></h3>

                                <div class="collapse" id="collapsepaypal">
                                    <div class="py-2">
                                        <p class="mb-0">Make your payment directly into our bank account. Please use
                                            your Order ID as the payment reference. Your order won’t be shipped until
                                            the funds have cleared in our account.</p>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
<%--                                <button class="btn btn-black btn-lg py-3 btn-block"--%>
<%--                                        onclick="window.location='thankyou.html'">장바구니--%>
<%--                                </button>--%>

                                <p>
                                    .btn.btn-white.btn-lg.py-3.btn-block
<%--                                    <a href="" class="btn btn-secondary me-2">장바구니</a>--%>
<%--                                    <a href="#" class="btn btn-white-outline">구매하기</a>--%>
                                    <button class="btn btn-white btn-lg py-3 btn-block"
                                            onclick="window.location='thankyou.html'">장바구니
                                    </button>
                                    <button class="btn btn-black btn-lg py-3 btn-block"
                                            onclick="window.location='thankyou.html'">구매하기
                                    </button>
                                </p>

                            </div>

                        </div>
                    </div>
                </div>


            </div>

            <div class="col-md-6 col-sm-12 col-xs-12">
                <div class="img-wrap">
                    <img src="../images/images/img_bg_3.jpg" alt="Image" class="img-fluid">
                </div>
            </div>
        </div>

    </div>


</div>


<!-- End Why Choose Us Section -->


<!-- Start Testimonial Slider -->
<div class="testimonial-section before-footer-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-7 mx-auto text-center">
                <h2 class="section-title">More Pictures</h2>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-lg-12 w-50 h-50">
                <div class="testimonial-slider-wrap text-center">

                    <div id="testimonial-nav">
                        <span class="prev" data-controls="prev"><span class="fa fa-chevron-left"></span></span>
                        <span class="next" data-controls="next"><span class="fa fa-chevron-right"></span></span>
                    </div>

                    <div class="testimonial-slider">

                        <div class="item">
                            <div class="row justify-content-center">
                                <div class="col-lg-8 mx-auto">
                                    <div class="author-pic">
                                        <img src="../images/img-grid-1.jpg" alt="image furniture" class="img-fluid">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- END item -->

                        <div class="item">
                            <div class="row justify-content-center">
                                <div class="col-lg-8 mx-auto">
                                    <div class="author-pic">
                                        <img src="../images/img-grid-2.jpg" alt="image furniture" class="img-fluid">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- END item -->
                        <div class="item">
                            <div class="row justify-content-center">
                                <div class="col-lg-8 mx-auto">
                                    <div class="author-pic">
                                        <img src="../images/img-grid-3.jpg" alt="image furniture" class="img-fluid">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- END item -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Testimonial Slider -->


<jsp:include page="../common/footer.jsp"/>