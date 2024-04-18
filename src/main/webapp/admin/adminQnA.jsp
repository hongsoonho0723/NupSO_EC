<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>NoopSO Admin Table</title>
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
  		<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
  		<script type="text/javascript">
 	   //전체검색
 	   $(function(){
 		   
 	   })//ready 함수 END
 	   
 	   function selectAll(){
 		   $.ajax({  
 				url: "ajax", // 서버의 주소 (요청주소)
 				type: "post", // 요청방식(method방식 = get | post | put | fetch | delete)
 				dataType:"json", // 서버가 보내온(response) 데이터 타입(text | json | xml | html)
 				data:{key:"QnA",methodName:"selectAll"}, // 서버에게 보낼 params 정보
 				success: function(result){// 성공했을때 callback함수
 					
 					let text ="";

 					$.each(result,function(index,item){
 						text+="<tr>"
 						text+="<td class = 'QnASeq'><a>"+item.QnASeq+"</a></td>";
 						text+="<td class = 'furnitureName'>"+item.furniture.name+"</td>";
 						text+="<td class = 'question'>"+item.question+"</td>";
 						text+="<td class = 'answer'>"+item.answer+"</td>";
 						text+="<td class = 'state'>"+item.state+"</td>";
 						text+="<td class = 'answerDate'>"+item.answerDate+"</td>";
 						text+="<td class = 'name'>"+item.name+"</td>";
 						text+="<td class = 'password'>"+item.password+"</td>";
 						text+="<td class = 'regDate'>"+item.regDate+"</td>";
 						text+="</tr>"
 					})//each End
 					$("#datatablesSimple tr:gt(0)").remove();
 					$("#datatablesSimple").append(text);
 					
 				}, 
 				error: function(err){// 실패했을때 callback함수
 					alert(err + "=> 오류 발생");
 				} 
 			 })
 		   
 	   }//selectAll 함수끝
 	   /////////////////////////////////////////////////////////////
  		
  		//로딩됬을때 전체 검색
  		 //selectAll();
  		</script>
        
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
					</tr>
					<tr>
						<td>QuestionSeq</td>
						<td><input type="text" size="30" name="answer" id="answer"></td>
						<td>Y</td>
						<td>AnswerDate</td>
						<td>Name</td>
						<td>Password</td>
					</tr>
					<tr>
						<td colspan="6" align="center"> 
			    			<input type="hidden" size="30" name="furnitureSeq" id="furnitureSeq">
			    			<input type="hidden" size="30" name="question" id="question">
			    			<input type="hidden" size="30" name="registrationDate" id="registrationDate">
							<input type="button" value="등록하기"  id="update">
							<input type="button" value="삭제하기"  id="delete">
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
                                    <tfoot>
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
                                    </tfoot>
                                    <tbody>
											<!-- table td  QnA값 등록 -->
											<!-- Question 에 a태크 넣고 눌르면 form으로 이동해서
											수정 삭제를 할 수 있게 함. -->
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
        <script src="../js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="../js/datatables-simple-demo.js"></script>
    </body>
</html>
