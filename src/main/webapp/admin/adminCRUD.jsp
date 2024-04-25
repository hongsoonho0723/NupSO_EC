<%@page import="dto.FurnitureDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProdCRUDDAOImpl"%>
<%@page import="dao.ProdCRUDDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>NoopSO Admin CRUD</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="${path}/assets/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
  		<style type="text/css">
		  		#inForm {
				  width: 100%;
				  border-collapse: collapse;
				}
				
				#inForm th, #inForm td {
				  border: 1px solid #dddddd;
				  padding: 8px;
				  text-align: left;
				}
				
				#inForm th {
				  background-color: #f2f2f2;
				}
				
				#inForm tr:nth-child(even) {
				  background-color: #f2f2f2;
				}
				
				#inForm tr:hover {
				  background-color: #dddddd;
				}
				
				
  		</style>
  		<script src="${path}/assets/js/jquery-3.6.0.min.js"></script>
		<script type="text/javascript">
 	   //전체검색
 	   /* $(function(){
 		  $(".furnitureSeq").attr("readonly", true);
 		  
 		   $(document).on("click","main.card-body table > tbody td" , function(){
 			  	 
 				let tr = $(this).closest("tr");
				
 				$("span.furnitureSeq").text(tr.find("td:eq(0)").text());
 		        $("span.furnitureNumber").text(tr.find("td:eq(1)").text());
 		        $("span.furnitureName").text(tr.find("td:eq(2)").text());
 		        $("span.furnitureDescription").text(tr.find("td:eq(3)").text());
 		        $("span.price").text(tr.find("td:eq(4)").text());    
 		        $("span.stock").text(tr.find("td:eq(5)").text());
 		        $("span.saleCount").text(tr.find("td:eq(6)").text());
 		        $("span.category").text(tr.find("td:eq(7)").text());
 		        $("span.regDate").text(tr.find("td:eq(8)").text()); */

				
				// 상품 수정
				/* if( $("#answer").val()!==""){
 					$("#update").val("상품 수정하기");
 				 }
 			  
 		   });
 		  
 			 $(document).on("click","#update", function(){
 				 if($("#furnitureSeq").val()===""){
 					 return;
 				 }
 				 
 				 $("#inForm").attr("action","${path}/front?key=furniture&methodName=update");
 				 $("#inForm").submit();
 			 }) */
 			 
 			 
 			 // 상품 삭제
 			 /* $(document).on("click","#delete", function(){
 				 if($(".furnitureSeq").val()===""){
 					 return;
 				 }
 				$("#inForm").attr("action","${path}/front?key=product&methodName=delete");
				$("#inForm").submit();
 				 
 			 }) */
 			 
 			 
 	   })//ready 함수 END
 	   /////////////////////////////////////////////////////////////
  		</script>
  		
    </head>
    <body class="sb-nav-fixed">
       <jsp:include page="../assets/common/admin/header.jsp"></jsp:include>
        <div id="layoutSidenav">
           <jsp:include page="../assets/common/admin/sideNav.jsp"></jsp:include>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">상품 CRUD</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="${path}/front?key=product&methodName=selectAll">새로고침</a></li>
                            <li class="breadcrumb-item active">상품 생성, 조회, 갱신, 삭제</li>
                        </ol>
                     <div>
                       </div>
                       <br>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                               	상품 조회
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                        	<th>furnitureSeq</th>
                                        	<th>furnitureNumber</th>
                                            <th>furnitureName</th>
                                            <th>furnitureDescription</th>
                                            <th>price</th>
                                            <th>stock</th>
                                            <th>saleCount</th>
                                            <th>category</th>
                                            <th>regDate</th>
                                        </tr>
                                    </thead>
                                     <tbody>
									<c:forEach items="${list}" var="item">
									   <tr>
									     <td>${item.furnitureSeq}</td>
									     <td>${item.furnitureNumber}</td>
									     <td>${item.furnitureName}</td>
									     <td>${item.furnitureDescription}</td>
									     <td>${item.price}</td>
									     <td>${item.stock}</td>
									     <td>${item.saleCount}</td>
									     <td>${item.category}</td>
									     <td>${item.regDate}</td>
									   </tr>
									</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>
                <jsp:include page="../assets/common/admin/footer.jsp"></jsp:include>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${path}/assets/js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="${path}/assets/js/datatables-simple-demo.js"></script>
    </body>
</html>
