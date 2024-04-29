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
				
				#inForm input[type="text"] {
				  width: 100%;
				  box-sizing: border-box;
				}
				
				#inForm input[type="hidden"] {
				  display: none;
				}
				
				
  		</style>
  		<script src="${path}/assets/js/jquery-3.6.0.min.js"></script>
		<script type="text/javascript">
 	   //전체검색
 	   $(function(){
 		  /*아이디를 클릭했을때 이벤트 처리 */
 		  $("#furnitureSeq").attr("readonly","readonly");
 		  
 		   $(document).on("click","main .card-body table > tbody td" , function(){
 			  	//text박스에 값넣기 
 				let tr = $(this).closest("tr");
				
 				$("#furnitureSeq").val(tr.find("td:eq(0)").text());
				$("#furnitureNumber").val(tr.find("td:eq(1)").text());
				$("#furnitureName").val(tr.find("td:eq(2)").text());
				$("#furnitureDescription").val(tr.find("td:eq(3)").text());
				$("#price").val(tr.find("td:eq(4)").text());	
				$("#stock").val(tr.find("td:eq(5)").text());
				$("#category").val(tr.find("td:eq(7)").text());
				$("#flag").val(tr.find("td:eq(8)").text());
				$("#furnitureImgSrc").val(tr.find("td:eq(10)").text());

				
				
				if( $("#answer").val()!==""){
 					$("#update").val("상품 수정하기");
 				 }
 			  
 		   });
 		   
 		  $(document).on("click","#update", function(){
				 if($("#furnitureSeq").val()===""){
					 return;
				 }
				 
				 $("#inForm").attr("action","${path}/front?key=product&methodName=update");
				 $("#inForm").submit();
			 })
 			 
 			 $(document).on("click","#delete", function(){
 				 if($("#furnitureSeq").val()===""){
 					 return;
 				 }
 				 $("#inForm").attr("action","${path}/front?key=product&methodName=delete");
				 $("#inForm").submit();
 				 
 			 })
 			 
 			 
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
                        	<h3>수정 및 삭제할 상품 클릭</h3>
                     <form name="inForm" method="post" id="inForm" action="${path}/fron?key=product">
				<table>
					<tr>
                                        	<th>FurnitureSeq</th>
                                        	<th>furnitureNumber</th>
                                            <th>furnitureName</th>
                                            <th>furnitureDescription</th>
                                            <th>price</th>
                                            <th>stock</th>
                                            <th>category</th>
                                            <th>flag</th>
                                            <th>furnitureImgSrc</th>
					</tr>
					<tr>
					     <td><input type="text" id="furnitureSeq" name = "furnitureSeq"></td>
					     <td><input type="text" id="furnitureNumber" name = "furnitureNumber"></td>
					     <td><input type="text" id="furnitureName" name = "furnitureName"></td>
					     <td><input type="text" id="furnitureDescription" name = "furnitureDescription"></td>
					     <td><input type="text" id="price" name = "price"></td>
					     <td><input type="text" id="stock" name = "stock"></td>
					     <td><input type="text" id="category" name = "category"></td>
					     <td><input type="text" id="flag" name = "flag"></td>
					     <td><input type="text" id="furnitureImgSrc" name = "furnitureImgSrc"></td>
				   </tr>
					<tr>
						<td colspan="8" align="center"> 
							<input type="button" value="상품 수정하기"  id="update">
							<input type="button" value="상품 삭제하기"  id="delete">
						</td>
					</tr>
					</table>
				</form>
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
                                        	<th>FurnitureSeq</th>
                                        	<th>furnitureNumber</th>
                                            <th>furnitureName</th>
                                            <th>furnitureDescription</th>
                                            <th>price</th>
                                            <th>stock</th>
                                            <th>saleCount</th>
                                            <th>category</th>
                                            <th>flag</th>
                                            <th>regDate</th>
                                            <th>furnitureImgSrc</th>
                                        </tr>
                                    </thead>
                                     <tbody>
									<c:forEach items="${list}" var="item">
									   <tr>
									     <td class="furnitureSeq">${item.furnitureSeq}</td>
									     <td>${item.furnitureNumber}</td>
									     <td>${item.furnitureName}</td>
									     <td>${item.furnitureDescription}</td>
									     <td>${item.price}</td>
									     <td>${item.stock}</td>
									     <td>${item.saleCount}</td>
									     <td>${item.category}</td>
									     <td>${item.flag}</td>
									     <td>${item.regDate}</td>
									     <td>${item.furnitureImgSrc}</td>
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
