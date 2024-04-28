<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Untree.co">
    <link rel="shortcut icon" href="${path}/assets/images/cow.png">
    <meta name="description" content="" />
    <meta name="keywords" content="bootstrap, bootstrap4" />

    <!-- Bootstrap CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link href="assets/css/tiny-slider.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
    <title>NupSO - HomePage</title>
</head>

<body>

<!-- Start Header/Navigation -->
<%-- 세션에서 사용자 정보 가져오기 --%>
<%
session = request.getSession(false); 
boolean isLoggedIn = (session != null && session.getAttribute("loginUser") != null);
%>
<nav class="custom-navbar navbar navbar navbar-expand-md navbar-dark bg-dark" arial-label="Furni navigation bar">
    <div class="container">
        <a class="navbar-brand" href="${path}/front?key=furniture&methodName=indexPage">NupSO<span>.</span></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsFurni" aria-controls="navbarsFurni" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarsFurni">
            <ul class="custom-navbar-nav navbar-nav ms-auto mb-2 mb-md-0">
                <li class="nav-item">
                    <a class="nav-link" href="${path}/front?key=furniture&methodName=indexPage">Home</a>
                </li>
                <li><a class="nav-link" href="${path}/front?key=furniture&methodName=selectFurnitureList">Shop</a></li>
                <li><a class="nav-link" href="about.jsp">About us</a></li>
                <li><a class="nav-link" href="#">Services</a></li>
                <li><a class="nav-link" href="#">Blog</a></li>
                <li><a class="nav-link" href="#">Contact us</a></li>
            </ul>
            <ul class="custom-navbar-cta navbar-nav mb-2 mb-md-0 ms-5">
               <% if (!isLoggedIn) { %>
                   <li><a class="nav-link" href="login.jsp"><img src="assets/images/login.svg" title ="로그인" alt ="로그인" width="24px" height="24px"></a></li>
               <% } else { %>
                   <li><a class="nav-link" href="#"><img src="assets/images/logout.svg" id = "logoutButton" title ="로그아웃" alt ="로그아웃" width="24px" height="24px"></a></li>
                   <li><a class="nav-link" href="${path}/front?key=order&methodName=selectOrderAll"><img src="assets/images/user.svg" title ="마이페이지" alt="마이페이지" width="24px" height="24px"></a></li>
               <% } %>
               <li><a class="nav-link" href="cart.jsp"><img src="assets/images/cart.svg" title ="장바구니" alt="장바구니"></a></li>
               <li><a class="nav-link" href="admin/adminLogin.jsp"><img src="assets/images/admin.svg" title ="관리자 로그인" alt ="관리자 로그인"></a></li>
            </ul>
        </div>
    </div>
</nav>

<div id = "confirmModal" class="confirmModal">
    <p>로그아웃하시겠습니까?</p>
    <div>
    <button class="btn btn-primary btn-lg btn-block" onclick="logout()">예</button>
    <button class="btn btn-primary btn-lg btn-block" onclick="hideModal()">아니오</button>
    </div>
    
</div>

<script>
// 모달 보여주기
document.getElementById('logoutButton').onclick = function() {
    document.getElementById('confirmModal').style.display = 'flex';
};

// 로그아웃 함수
function logout() {
   
    window.location.href = '${path}/userLogout'; // 서버 로그아웃 경로로 리다이렉트
}

// 모달 숨기기
function hideModal() {
    document.getElementById('confirmModal').style.display = 'none';
}
</script>
<!-- End Header/Navigation -->