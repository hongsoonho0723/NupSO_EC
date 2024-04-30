<%@page import="dto.QnADTO"%>
<%@page import="java.util.List"%>
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
        <title>NoopSO Admin QnA</title>
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
 		  <!-- 유효성 검사 코드 추가 -->
          <%
              HttpSession adminSession = request.getSession(false);
              if (adminSession == null || adminSession.getAttribute("adminId") == null) {
                  response.sendRedirect(request.getContextPath() + "/admin/adminLogin.jsp");
                  return;
              }
          %>
          <!-- 유효성 검사 코드 추가 끝 -->
          <%
          // 캐시 관리 헤더 추가
          response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
          response.setHeader("Pragma", "no-cache"); // HTTP 1.0
          response.setDateHeader("Expires", 0); // Proxies
      %>
 		   
 		  /*아이디를 클릭했을때 이벤트 처리 */
 		  $("#questionSeq").attr("readonly","readonly");
 		  
 		   $(document).on("click","main .card-body table > tbody td" , function(){
 			  	//text박스에 값넣기 
 				let tr = $(this).closest("tr");
				
				$("#questionSeq").val(tr.find("td:eq(0)").text());
				$("span.question").text(tr.find("td:eq(2)").text());
				$("#answer").val(tr.find("td:eq(3)").text());
				$("#state").val(tr.find("td:eq(4)").text());
				$("span.answerDate").text(tr.find("td:eq(5)").text());	
				$("span.name").text(tr.find("td:eq(6)").text());
				$("span.password").text(tr.find("td:eq(7)").text());
				$("span.regDate").text(tr.find("td:eq(8)").text());

				
				
				if( $("#answer").val()!==""){
 					$("#update").val("답변 수정하기");
 				 }
 			  
 		   });
 		  
 			 $(document).on("click","#update", function(){
 				 if($("#questionSeq").val()===""){
 					 return;
 				 }
 				 
 				 $("#inForm").attr("action","${path}/front?key=qna&methodName=update");
 				 $("#inForm").submit();
 			 })
 			 
 			 $(document).on("click","#delete", function(){
 				 if($("#questionSeq").val()===""){
 					 return;
 				 }
 				$("#inForm").attr("action","${path}/front?key=qna&methodName=delete");
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
                        <h1 class="mt-4">QnA</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="${path}/front?key=qna&methodName=selectAll">새로고침</a></li>
                            <li class="breadcrumb-item active">QnA</li>
                        </ol>
                     <div>
                            <!--  <div class="card-body">
                                고객의 소리를 듣자!
                            </div>-->
         	 <form name="inForm" method="post" id="inForm" action="${path}/fron?key=qna">
				<table>
					<tr>
						<th>QuestionSeq</th>
						<th>Question</th>
                        <th>Answer</th>
                        <th>State</th>
                        <th>Answer date</th>
                        <th>Name</th>
                        <th>Password</th>
                        <th>RegDate</th>
					</tr>
					<tr>
						<td><input type="text" size="7" name="questionSeq" id="questionSeq"></td>
						<td><span class="question">Question</span></td>
						<td><input type="text" size="50" name="answer" id="answer"></td>
						<td><input type="text" size="5" name="state" id="state"></td>
						<td><span class="answerDate">answerDate</span></td>
						<td><span class="name">Name</span></td>
						<td><span class="password">Password</span></td>
						<td><span class="regDate">RegDate</span></td>
					</tr>
					<tr>
						<td colspan="8" align="center"> 
							<input type="button" value="답변 등록하기"  id="update">
							<input type="button" value="QnA 삭제하기"  id="delete">
						</td>
					</tr>
					</table>
				</form>
                       </div>
                       <br>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                               	QnA조회
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                        	<th>QuestionSeq</th>
                                        	<th>FurnitureName</th>
                                            <th>Question</th>
                                            <th>Answer</th>
                                            <th>State</th>
                                            <th>Answer date</th>
                                            <th>Name</th>
                                            <th>Password</th>
                                            <th>Registration  date</th>
                                        </tr>
                                    </thead>
                                     <tbody>
											<!-- table td  QnA값 등록 -->
											<!-- Question 에 a태크 넣고 눌르면 form으로 이동해서
											수정 삭제를 할 수 있게 함. -->
									<c:forEach items="${list}" var="item">
									   <tr>
									     <td class="qnASeq">${item.qnASeq}</td>
									     <td class="furnitureName">${item.furniture.furnitureName}</td>
									     <td class="question">${item.question}</td>
									     <td class="answer">${item.answer}</td>
									     <td class="state">${item.state}</td>
									     <td class="answerDate">${item.answerDate}</td>
									     <td class="name">${item.name}</td>
									     <td class="password">${item.password}</td>
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
