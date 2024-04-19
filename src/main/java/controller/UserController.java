package controller;

import dto.UsersDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;
import service.UserServiceImpl;

public class UserController implements Controller{
	
	UserService userService = new UserServiceImpl();
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	  
		
	/*
	 * 로그인
	 * */
	  
	  public ModelAndView login(HttpServletRequest request, HttpServletResponse
	  response) throws Exception {
	  
	  //두개의 전송되는 값을 받는다. 
	  String userId =request.getParameter("userId"); 
	  String password=request.getParameter("password");

	  UsersDTO dbDTO = userService.login(new UsersDTO(userId,password));
		
	  System.out.println("dbname="+dbDTO.getName());
	 
	  //로그인성공하면 세션에 정보를 저장 - ${loginUser} / ${loginName}
	  HttpSession session = request.getSession();
	  
	  session.setAttribute("loginUser",dbDTO); 
	  
	  return new ModelAndView("login/login.jsp", true); 
	
	  }

	

}
