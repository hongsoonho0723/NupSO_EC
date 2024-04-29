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
        <title>NoopSO Admin CRUDC</title>
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
				
				
  		</style>
  		<script src="${path}/assets/js/jquery-3.6.0.min.js"></script>
		<script type="text/javascript"></script>
  		
    </head>
    <body class="sb-nav-fixed">
       <jsp:include page="../assets/common/admin/header.jsp"></jsp:include>
        <div id="layoutSidenav">
           <jsp:include page="../assets/common/admin/sideNav.jsp"></jsp:include>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">상품 추가</h1>
                        <div>
           <form name="inForm" method="post" id="inForm" action="${path}/front?key=product&methodName=create">
				<table>
            <tr>
                <th>furnitureNumber</th>
                <td><input type="text" name="furnitureNumber" id="furnitureNumber"></td>
            </tr>
            <tr>
                <th>furnitureName</th>
                <td><input type="text" name="furnitureName" id="furnitureName"></td>
            </tr>
            <tr>
    		<th>furnitureDescription</th>
    			<td><textarea name="furnitureDescription" id="furnitureDescription" style="width: 100%; height: 100px;"></textarea></td>
			</tr>
            <tr>
                <th>price</th>
                <td><input type="text" name="price" id="price"></td>
            </tr>
            <tr>
                <th>stock</th>
                <td><input type="text" name="stock" id="stock"></td>
            </tr>
            <tr>
                <th>category</th>
                <td><input type="text" name="category" id="category"></td>
            </tr>
            <tr>
            <th>regDate</th>
    			<td><input type="text" name="regDate" id="regDate" value="<%= new java.util.Date() %>"></td>
			</tr>
            <tr>
                <th>texture</th>
                <td><input type="text" name="texture" id="texture"></td>
            </tr>
            <tr>
			<tr>
                <th>furnitureImgSrc</th>
                <td><input type="file" name="furnitureImgSrc" id="furnitureImgSrc"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
    				<input type="submit" value="등록" onclick="submitForm()">
				</td>

			<script>
    				function submitForm() {
    					
        			// 폼을 submit
        			document.getElementById("inForm").submit();
        			
        			// 알림창 띄우기
        			alert("상품이 등록되었습니다!");
        			
        			// 페이지 이동
        			window.location.href = "${path}/adminCRUD.jsp";
    			}
			</script>
            </tr>
        </table>
		</form>
        </div>
        <br>
                        
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