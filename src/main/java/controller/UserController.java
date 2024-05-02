package controller;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;
import service.UserServiceImpl;

public class UserController implements Controller {

	UserService userService = new UserServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println("deleteUser call");
		
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute("userSeq");
		if(obj == null) {
			System.out.println("obj = "+obj);
		}
		
		int userSeq = (int)session.getAttribute("userSeq");
		userService.deleteUser(userSeq);
		
		
		
		return new ModelAndView("index.jsp");
	}
	
	
	
}
