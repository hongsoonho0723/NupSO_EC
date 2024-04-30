package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ModelAndView checkout(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("checkout call");
		
		
		
		
		
		return new ModelAndView("checkout2.jsp");
	}
	
}
