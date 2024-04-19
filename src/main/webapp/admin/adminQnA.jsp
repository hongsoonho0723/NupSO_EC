<%@page import="dto.QnADTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.QnADAOImpl"%>
<%@page import="dao.QnADAO"%>
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
        <link href="../css/styles.css" rel="stylesheet" />
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

  		
    </head>
    <body class="sb-nav-fixed">
       <jsp:include page="../common/admin/header.jsp"></jsp:include>
        <div id="layoutSidenav">
           <jsp:include page="../common/admin/sideNav.jsp"></jsp:include>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">QnA</h1>
                        <ol class="breadcrumb mb-4">
                            
                        </ol>
                     <div>
                            <!--  <div class="card-body">
                                고객의 소리를 듣자!
                            </div>-->
         	 <form name="inForm" method="post" id="inForm">
				<table>
					<tr>
						<th>QuestionSeq</th>
                        <th>Answer</th>
                        <th>State</th>
                        <th>Answer date</th>
                        <th>Name</th>
                        <th>Password</th>
                        <th>RegDate</th>
					</tr>
					<tr>
						<td><span class="questionSeq">QuestionSeq</span></td>
						<td><input type="text" size="50" name="answer" id="answer"></td>
						<td><input type="text" size="5" name="state" id="state"></td>
						<td><input type="text" size="10" name="answerDate" id="answerDate"></td>
						<td><span class="name">Name</span></td>
						<td><span class="password">Password</span></td>
						<td><span class="regDate">RegDate</span></td>
					</tr>
					<tr>
						<td colspan="7" align="center"> 
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
										
									<%
									   QnADAO dao = new QnADAOImpl();
									 List<QnADTO> list = dao.selectAll();
									 request.setAttribute("list", list);
									%>		
									
									
									<c:forEach items="${list}" var="item">
									   <tr>
									     <td>11</td>
									     <td>${item.furniture.FURNITURE_NAME}</td>
									     <td>${item.question}</td>
									     <td>${item.answer}</td>
									     <td>${item.state}</td>
									     <td>${item.answerDate}</td>
									     <td>${item.name}</td>
									     <td>${item.password}</td>
									     <td>${item.regDate}</td>
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
        <script type="text/javascript">
 	   //전체검색
 	   $(function(){
 		   
 		  
 		  /*아이디를 클릭했을때 이벤트 처리 */
 		  
 		   $(document).on("click","main .card-body table > tbody td" , function(){
 			  	//text박스에 값넣기 
 				let tr = $(this).closest("tr");

				$("span.questionSeq").text(tr.find(".QnASeq").text());
				$("#answer").val(tr.find(".answer").text());
				$("#state").val(tr.find(".state").text());
				$("#answerDate").val(tr.find(".answerDate").text());	
				$("span.name").text(tr.find(".name").text());
				$("span.password").text(tr.find(".password").text());
				$("span.regDate").text(tr.find(".regDate").text());

 			   //아이디박스 비활성화(입력불가능) - atrr()이용
 			 	
 			   
 			   //span태그 숨기기 
 			  
 			   //$("span").hide(); -> show로 숨기기 나타나기 제어
 			   //btn의 글씨 수정하기로 변경
 			  
 		   });
 		   
 		  selectAll();
 		
 
 	   })//ready 함수 END
 	   
 	   function selectAll(){
 		  /* $.ajax({  
 				url: "${path}/ajax", // 서버의 주소 (요청주소)
 				type: "post", // 요청방식(method방식 = get | post | put | fetch | delete)
 				dataType:"json", // 서버가 보내온(response) 데이터 타입(text | json | xml | html)
 				data:{key:"QnA",methodName:"selectAll"}, // 서버에게 보낼 params 정보
 				success: function(result){// 성공했을때 callback함수
 					
 					let text ="";

 					$.each(result,function(index,item){
 						text+="<tr>"
 						text+="<td id = 'QnASeq'><a>"+item.QnASeq+"</a></td>";
 						text+="<td id = 'furnitureName'>"+item.furniture.FURNITURE_NAME+"</td>";
 						text+="<td id = 'question'>"+item.question+"</td>";
 						text+="<td id = 'answer'>"+item.answer+"</td>";
 						text+="<td id = 'state'>"+item.state+"</td>";
 						text+="<td id = 'answerDate'>"+item.answerDate+"</td>";
 						text+="<td id = 'name'>"+item.name+"</td>";
 						text+="<td id = 'password'>"+item.password+"</td>";
 						text+="<td id = 'regDate'>"+item.regDate+"</td>";
 						text+="</tr>"
 					})//each End

 					//$("main .card-body table > tbody tr").remove();
 					$("main .card-body table > tbody").append(text);

 					 //src="../js/datatables-simple-demo.js"
 						$("main table").attr("id","datatablesSimple")
 				}, 
 				error: function(err){// 실패했을때 callback함수
 					alert(err + "=> 오류 발생");
 				} 
 			 })*/
 		   
 	   }//selectAll 함수끝
 	   /////////////////////////////////////////////////////////////
  		
  		</script>
  		
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="../js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="../js/datatables-simple-demo.js"></script>
        
        
    </body>
</html>
