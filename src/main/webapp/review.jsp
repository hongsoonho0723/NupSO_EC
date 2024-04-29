<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<script src="${path}/assets/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function checkValid() {
    var f = window.document.writeForm;
		
	if ( f.score.value == "") {
	    alert( "점수를 입력하셔야 합니다." );
	    f.score.focus();
		return false;
    }
	if (isNaN(f.score.value)) {
	    alert("점수는 숫자로 입력해야 합니다.");
	    f.score.focus();
	    return false;
	}
	if ( f.img.value == "" ) {
		alert( "사진 첨부를해야 리뷰를 등록가능 합니다." );
		f.img.focus();
		return false;
	}
	if ( f.review.value == "" ) {
		alert( "리뷰를 입력해 주세요." );
		f.review.focus();
		return false;
	}
	
    return true;
}
</script>

<jsp:include page="assets/common/user/header.jsp"/>

<!-- Start Hero Section -->
<div class="hero">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-lg-5">
                <div class="intro-excerpt">
                    <h1>Review</h1>
                    <p class="mb-4">상품에 대한 리뷰를 작성해주세요.</p>
                    <p><a href="javascript:void(0);" class="btn btn-secondary me-2" onclick="history.back();">My Page</a>
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
                    <form name="writeForm" method="post" action="${path}/front"  onSubmit='return checkValid()'
                     enctype="multipart/form-data">
                        <input type="hidden" value="<%=request.getParameter("furnitureSeq") %>" id="furnitureSeq" name="furnitureSeq">
                        <input type="hidden" value="review" id="key" name="key">
                        <input type="hidden" value="insert" id="methodName" name="methodName">
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label class="text-black" for="score">평점 (1~5)</label>
                                    <input type="text" class="form-control" id="score" name="score">
                                    <label class="text-black" for="img">사진 첨부 (.jpg .png .svg 만 가능합니다)</label>
                                    <input type="file" class="form-control" id="img" name="img">
                                </div>
                            </div>
                        </div>
                        <div class="form-group mb-5">
                            <label class="text-black" for="review">리뷰 내용</label>
                            <textarea class="form-control" id="review" cols="30" rows="5" name="review"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary-hover-outline">등록하기</button>
                    </form>

                </div>

            </div>

        </div>

    </div>


</div>

<!-- End Contact Form -->


<jsp:include page="assets/common/user/footer.jsp"/>
