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

        <title>NupSO Admin Login</title>
        <link href="${path}/assets/css/styles.css" rel="stylesheet" />

        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <script src="${path}/assets/js/jquery-3.6.0.min.js"></script>
        <script>
        function loginForm(event) {
			let inputId = document.getElementById("inputEmail").value;
			let inputPwd = document.getElementById("inputPassword").value;
			let autoIdPwd = document.getElementById("inputRememberPassword").checked;
			
			if(inputId == "" || inputPwd ==""){
				alert("아이디와 비밀번호 모두 입력해주세요.");
				event.preventDefault();
				return false;
			}
			
			// 체크박스가 체크되었을 때만 세션 스코프에 ID와 비밀번호 저장
			  if (autoIdPwd) {
				  session.setAttribute("adminId", inputId);
				  session.setAttribute("adminPassword", inputPwd);
			  } else {
			    // 체크박스가 체크되지 않았을 때 세션 스코프에 저장된 데이터 삭제
				  session.removeAttribute("adminId");
				  session.removeAttribute("adminPassword");
			  }

			  // 세션 스코프에 저장된 ID와 비밀번호를 입력란에 자동으로 입력
			  if (autoIdPwd) {
			    document.getElementById("inputEmail").value = "${sessionScope.adminId}";
			    document.getElementById("inputPassword").value = "${sessionScope.adminPassword}";
			  } else {
			    document.getElementById("inputEmail").value = "";
			    document.getElementById("inputPassword").value = "";
			  }
			  
			}
		
        </script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
                                    <div class="card-body">
                                        <form action="../adminLogin" method="post" onsubmit="return loginForm(event)">
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="inputEmail" name="inputEmail" type="email" value="${adminId}" placeholder="name@example.com" />
                                                <label for="inputEmail">admin ID</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="inputPassword" name="inputPassword" type="password" value="${adminPassword}" placeholder="Password" />
                                                <label for="inputPassword">Password</label>
                                            </div>
                                            <div class="form-check mb-3">
                                                <input class="form-check-input" id="inputRememberPassword" type="checkbox" value="" />
                                                <label class="form-check-label" for="inputRememberPassword">Remember Password</label>
                                            </div>
                                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">

                                               <button class="btn btn-primary" type="submit">Login</button>

                                               <%-- <a class="btn btn-primary" href="${path}/front?key=order&methodName=selectOrderFunitureName">Login</a> --%>

                                            </div>
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
              <jsp:include page="../assets/common/admin/footer.jsp"></jsp:include>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${path}/assets/js/scripts.js"></script>
    </body>
</html>
    