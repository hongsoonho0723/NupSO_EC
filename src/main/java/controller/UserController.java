package controller;

<<<<<<< HEAD
import dto.UsersDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;
import service.UserServiceImpl;
=======
import service.QnAService;
import service.QnAServiceImpl;
>>>>>>> 5b20651b9b4ce63e1b467e86863590c83e0e3ae7

public class UserController {

	
	/*
	 * 로그인
	 * */
	  UserService userService = new UserServiceImpl();
	  
	  public ModelAndView login(HttpServletRequest request, HttpServletResponse
	  response) throws Exception {
	  
	  //두개의 전송되는 값을 받는다. 
	  String userId =request.getParameter("userId"); 
	  String password=request.getParameter("password");
	  
	  //서비스 호출 
	  UsersDTO dbDTO = userService.loginCheck(new UsersDTO(userId,password));
		
	  //로그인성공하면 세션에 정보를 저장 - ${loginUser} / ${loginName}
	  HttpSession session = request.getSession();
	  
	  //session.setAttribute("login", ); session.setAttribute("");
	  
	  //index.jsp이동 - redirect방식
	  
	  return new ModelAndView("", true); }
	 

	
}
