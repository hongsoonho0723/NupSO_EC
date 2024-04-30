package controller;

import java.sql.SQLException;

import dto.CartDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.CartService;
import service.CartServiceImpl;

public class CartController implements Controller{

	CartService cartService = new CartServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public ModelAndView insertCart(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		HttpSession session = request.getSession();
		int userSeq=(Integer)session.getAttribute("userSeq");
		int furnitureSeq= Integer.parseInt(request.getParameter("furnitureSeq"));
		int quantity =Integer.parseInt(request.getParameter("quantity"));
		String colorName = request.getParameter("colorName");
		String sizeVal = request.getParameter("sizeVal");
		String url= request.getParameter("url");
		System.out.println("url = "+url);
		CartDTO cartDTO = new CartDTO(userSeq,furnitureSeq,quantity,colorName,sizeVal);
		System.out.println("userSeq = " +userSeq);
		System.out.println(furnitureSeq);
		System.out.println(quantity);
		System.out.println(colorName);
		System.out.println(sizeVal);
		
		cartService.insertCart(cartDTO);
		
		
		return new ModelAndView(url,true);
		
	}
	
	
	
	

}
