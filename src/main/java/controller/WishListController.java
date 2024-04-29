package controller;

import java.sql.SQLException;

import dto.CartDTO;
import dto.WishListDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.WishListService;
import service.WishListServiceImpl;

public class WishListController implements Controller {
	
	WishListService wishListService = new WishListServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	
public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		HttpSession session = request.getSession();
		int userSeq=(Integer)session.getAttribute("userSeq");
		int furnitureSeq= Integer.parseInt(request.getParameter("furnitureSeq"));
		String colorName = request.getParameter("colorName");
		String sizeVal = request.getParameter("sizeVal");
		String url= request.getParameter("url");
		System.out.println("url = "+url);
		WishListDTO wishListDTO = new WishListDTO(userSeq, furnitureSeq, colorName, sizeVal);
		System.out.println("userSeq = " +userSeq);
		System.out.println(furnitureSeq);
		System.out.println(colorName);
		System.out.println(sizeVal);
		
		wishListService.insert(wishListDTO);
		
		
		return new ModelAndView(url,true);
		
	}
	
}
