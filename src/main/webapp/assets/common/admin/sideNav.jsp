<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
$(document).ready(function(){
    // 각 토글링할 항목에 대한 클릭 이벤트 처리 
    $(".nav-link.collapsed").click(function(){
        // 해당 항목의 다음 요소를 토글 (보이기/감추기)
        $(this).next(".collapse").toggle();
        // 토글 화살표 아이콘 변경
        $(this).find(".sb-sidenav-collapse-arrow i").toggleClass("fa-angle-down fa-angle-up");
    });
});
</script>
</head>
<body>
<div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">메인</div>
                            <a class="nav-link" href="${path}/front?key=order&methodName=selectOrderFurnitureName">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                HOME
                            </a>
                            <div class="sb-sidenav-menu-heading">관리</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                회원 관리
                                  <!-- <i class="fas fa-angle-down"></i> 책 닫힌 이모지 -->
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts1" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="${path}/front?key=adminuser&methodName=selectAll">회원 조회</a>
                                </nav>
                            </div>
                             <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                상품 관리
                                  <!-- <i class="fas fa-angle-down"></i> 책 닫힌 이모지 -->
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts2" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                	<a class="nav-link" href="${path}/admin/adminCRUDC.jsp">상품 등록</a>
                                    <a class="nav-link" href="${path}/front?key=product&methodName=selectAll">상품 조회</a>
                                </nav>
                            </div>
                             <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                배송 관리
                                  <!-- <i class="fas fa-angle-down"></i> 책 닫힌 이모지 -->
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts3" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="${path}/front?key=delivery&methodName=selectAll">배송 조회</a>
                                </nav>
                            </div>
                                     <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                리뷰 관리
                                  <!-- <i class="fas fa-angle-down"></i> 책 닫힌 이모지 -->
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts4" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="${path}/front?key=review&methodName=selectAll">리뷰 조회</a>
                                </nav>
                            </div>
                                     <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                QnA 관리
                                  <!-- <i class="fas fa-angle-down"></i> 책 닫힌 이모지 -->
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts5" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="${path}/front?key=qna&methodName=selectAll">QnA 조회</a>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">분석</div>
                            <a class="nav-link" href="${path}/admin/adminCharts.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                데이터 분석
                            </a>
                            <!-- 나중에 추가할지 고민 -->
                            <!--  <a class="nav-link" href="adminTables.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                가입자 분석
                            </a>-->
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as: 관리자</div>
                        Made by NupSo
                    </div>
                </nav>
            </div>

</body>
</html>