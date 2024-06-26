<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<script src="${path}/assets/js/jquery-3.6.0.min.js"></script>

<jsp:include page="assets/common/user/header.jsp"/>


<!-- Start Hero Section -->
<div class="hero">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-lg-5">
                <div class="intro-excerpt">
                    <h1>Q & A</h1>
                    <p class="mb-4">상품에 대한 궁금하신 점을 작성해주세요.</p>
                    <p><a href="javascript:void(0);" class="btn btn-secondary me-2" onclick="history.back();">Shop Now</a>
                    </p>
                </div>
            </div>
            <div class="col-lg-7">
                <div class="hero-img-wrap">
                    <img src="${path}/assets/<%=request.getParameter("furnitureImgSrc") %>" class="img-fluid">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Hero Section -->


<!-- Start Contact Form -->
<div class="untree_co-section">
    <div class="container">

        <div class="block">
            <div class="row justify-content-center">
                <div class="col-md-8 col-lg-8 pb-4">
					<jsp:include page="assets/common/user/contack.jsp"/>
                    <form method="post" action="${path}/front">
                        <input type="hidden" value="<%=request.getParameter("furnitureSeq") %>" id="furnitureSeq" name="furnitureSeq">
                        <input type="hidden" value="qna" id="key" name="key">
                        <input type="hidden" value="insert" id="methodName" name="methodName">
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label class="text-black" for="name">Name</label>
                                    <input type="text" class="form-control" id="name" name="name">
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group">
                                    <label class="text-black" for="password">Password</label>
                                    <input type="text" class="form-control" id="password" name="password">
                                </div>
                            </div>
                        </div>

                        <div class="form-group mb-5">
                            <label class="text-black" for="question">Message</label>
                            <textarea name="question" class="form-control" id="question" cols="30" rows="5" name="question"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary-hover-outline">Send Message</button>
                    </form>

                </div>

            </div>

        </div>

    </div>


</div>

<!-- End Contact Form -->


<jsp:include page="assets/common/user/footer.jsp"/>
