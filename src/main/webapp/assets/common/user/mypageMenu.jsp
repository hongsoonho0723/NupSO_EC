<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="hero">
	<div class="container">
		<div class="row justify-content-between">
			<div class="col-lg-8">
				
                   <p>
                   	<a href="${path}/front?key=review&methodName=selectAllByUser" class="btn btn-secondary me-2">내가 쓴 리뷰조회</a>
                   	<a href="javascript:void(0);" class="btn btn-secondary me-2" onclick="history.back();">My Page</a>
                   	<a href="personalInfo.jsp" class="btn btn-secondary me-2">개인정보수정</a>
                   </p>
               	
			</div>
		</div>
	</div>
</div>
</body>
</html>