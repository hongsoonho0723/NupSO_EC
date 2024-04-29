package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import service.UserServiceImpl;

public class UserController implements Controller{
	
private UserService userService = new UserServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}
	 public UserController() throws IOException {};
	 
	 //유저 개인정보 조회
		public ModelAndView userSelect(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("UserController.userSelect");
			
			return null;
		}
	 //유저 개인정보 수정
		public ModelAndView userUpdate(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("UserController.userUpdate");
			return null;
		}

		// 유저 회원탈퇴
		public ModelAndView userDelete(HttpServletRequest request, HttpServletResponse response) {
			return null;
		}
		
}
