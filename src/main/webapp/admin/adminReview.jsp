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
        <title>NoopSO Admin Review</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="${path}/css/styles.css" rel="stylesheet" />
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
  		<script src="${path}/js/jquery-3.6.0.min.js"></script>
		<script type="text/javascript">
 	   //전체검색
 	   $(function(){
 		  /*아이디를 클릭했을때 이벤트 처리 */
 		  $("#questionSeq").attr("readonly","readonly");
 		  
 		   $(document).on("click","main .card-body table > tbody td" , function(){
 			  	//text박스에 값넣기 
 				let tr = $(this).closest("tr");			  	
				
				$("#reviewSeq").val(tr.find("td:eq(0)").text());
				$("span.furnitureName").text(tr.find("td:eq(1)").text());
				$("span.name").val(tr.find("td:eq(2)").text());
				$("span.review").val(tr.find("td:eq(3)").text());
				$("span.score").text(tr.find("td:eq(4)").text());	
				$("span.regDate").text(tr.find("td:eq(5)").text());


				
				
				if( $("#answer").val()!==""){
 					$("#update").val("답변 수정하기");
 				 }
 			  
 		   });
 		  	 
 			 $(document).on("click","#delete", function(){
 				 if($("#reviewSeq").val()===""){
 					 return;
 				 }
 				$("#inForm").attr("action","${path}/front?key=review&methodName=delete");
				 $("#inForm").submit();
 				 
 			 })
 			
 	
 	   })//ready 함수 END
 	   /////////////////////////////////////////////////////////////
  		</script>
  		
    </head>
    <body class="sb-nav-fixed">
       <jsp:include page="../common/admin/header.jsp"></jsp:include>
        <div id="layoutSidenav">
           <jsp:include page="../common/admin/sideNav.jsp"></jsp:include>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Review</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="${path}/front?key=review&methodName=selectAll">새로고침</a></li>
                            <li class="breadcrumb-item active">Review</li>
                        </ol>
                     <div>
                            <!--  <div class="card-body">
                                고객의 소리를 듣자!
                            </div>-->
         	 <form name="inForm" method="post" id="inForm" action="${path}/front?key=review">
				<table>
					<tr>
                    	<th>ReviewSeq</th>
                    	<th>FurnitureName</th>
                        <th>Name</th>
                        <th>Review</th>
                        <th>Score</th>
                        <th>Registration  Date</th>
					</tr>
					<tr>
						<td><input type="text" size="7" name="reviewSeq" id="reviewSeq"></td>
						<td><span class="furnitureName">FurnitureName</span></td>
						<td><span class="name">Name</span></td>
						<td><span class="review">Review</span></td>
						<td><span class="score">Score</span></td>
						<td><span class="regDate">RegDate</span></td>
					</tr>
					<tr>
						<td colspan="6" align="center"> 
							<input type="button" value="리뷰 삭제하기"  id="delete">
						</td>
					</tr>
					</table>
				</form>
                       </div>
                       <br>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                               	Review조회
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                        	<th>ReviewSeq</th>
                                        	<th>FurnitureName</th>
                                            <th>Name</th>
                                            <th>Review</th>
                                            <th>Score</th>
                                            <th>Registration  Date</th>
                                        </tr>
                                    </thead>
                                     <tbody>
											<!-- table td  review값 등록 -->
											<!-- Question 에 a태크 넣고 눌르면 form으로 이동해서
											수정 삭제를 할 수 있게 함. -->
									<c:forEach items="${list}" var="item">
									   <tr>
									     <td class="reviewSeq">${item.reviewSeq}</td>
									     <td class="furnitureName">${item.furniture.furnitureName}</td>
									     <td class="userName">${item.user.name}</td>
									     <td class="review">${item.review}</td>
									     <td class="score">${item.score}</td>
									     <td class="regDate">${item.regDate}</td>
									   </tr>
									</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>
                <jsp:include page="../common/admin/footer.jsp"></jsp:include>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${path}/js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="${path}/js/datatables-simple-demo.js"></script>
    </body>
</html>
