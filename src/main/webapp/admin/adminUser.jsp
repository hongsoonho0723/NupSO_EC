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
        <title>NupSO Admin UserManagement</title>
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
 		  $("#questionSeq").attr("readonly","readonly");
 		  
 		   $(document).on("click","main .card-body table > tbody td" , function(){
 			  	//text박스에 값넣기 
 				let tr = $(this).closest("tr");			  	
				
				$("#userSeq").val(tr.find("td:eq(0)").text());
				$("span.userId").text(tr.find("td:eq(1)").text());
				$("span.name").val(tr.find("td:eq(2)").text());
				$("span.age").val(tr.find("td:eq(3)").text());
				$("span.gender").text(tr.find("td:eq(4)").text());
				$("span.userState").text(tr.find("td:eq(5)").text());	
				$("span.regDate").text(tr.find("td:eq(6)").text());


				
				
				if( $("#answer").val()!==""){
 					$("#update").val("답변 수정하기");
 				 }
 			  
 		   });
 		  	 
 			 $(document).on("click","#delete", function(){
 				 if($("#userState").val()===""){
 					 return;
 				 }
 				$("#inForm").attr("action","${path}/front?key=adminUser&methodName=delete");
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
                        <h1 class="mt-4">회원조회</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="${path}/front?key=adminUser&methodName=selectAll">새로고침</a></li>
                            <li class="breadcrumb-item active">회원조회</li>
                        </ol>
                     <div>
                            <!--  <div class="card-body">
                                고객의 소리를 듣자!
                            </div>-->
         	 <form name="inForm" method="post" id="inForm" action="${path}/front?key=adminUser">
				<table>
					<tr>
                    	<th>UserSeq</th>
                    	<th>UserID</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Gender</th>
                        <th>State</th>
                        <th>Registration  Date</th>
					</tr>
					<tr>
						<td><input type="text" size="7" name="userSeq" id="userSeq"></td>
						<td><span class="userId">UserID</span></td>
						<td><span class="name">Name</span></td>
						<td><span class="age">Age</span></td>
						<td><span class="gender">Gender</span></td>
						<td><span class="userState">State</span></td>
						<td><span class="regDate">RegDate</span></td>
					</tr>
					<tr>
						<td colspan="8" align="center"> 
							<input type="button" value="회원정보 삭제하기"  id="delete">
						</td>
					</tr>
					</table>
				</form>
                       </div>
                       <br>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                               	회원정보조회
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                        	<th>UserSeq</th>
                                        	<th>UserID</th>
                                            <th>Name</th>
                                            <th>Age</th>
                                            <th>Gender</th>
                                            <th>State</th>
                                            <th>Registration  Date</th>
                                        </tr>
                                    </thead>
                                     <tbody>
											<!-- table td  review값 등록 -->
											<!-- Question 에 a태크 넣고 눌르면 form으로 이동해서
											수정 삭제를 할 수 있게 함. -->
									<c:forEach items="${list}" var="item">
									   <tr>
									     <td class="userSeq">${item.userSeq}</td>
									     <td class="userId">${item.userId}</td>
									     <td class="name">${item.name}</td>
									     <td class="age">${item.age}</td>
									     <td class="gender">${item.gender}</td>
									     <td class="userState">${item.userState}</td>
									     <td class="regDate">${item.regDate}</td>
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
