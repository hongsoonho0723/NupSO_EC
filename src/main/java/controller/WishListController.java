package controller;

import java.io.IOException;
import java.sql.SQLException;

import dto.CartDTO;
import dto.UsersDTO;
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
	
public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		System.out.println("확인테스트");
		HttpSession session = request.getSession();
		UsersDTO user = (UsersDTO)session.getAttribute("loginUser");
		int userSeq=user.getUserSeq();
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
		
		FurnitureController controller = new FurnitureController();
		ModelAndView mv = controller.furnitureInfo(request, response,"");
		
		return mv;
		
	}
	
}
