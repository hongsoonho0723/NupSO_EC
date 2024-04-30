package controller;

import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import dto.WishListDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.WishListService;
import service.WishListServiceImpl;

public class WishListAjaxController implements RestController {
	
	WishListService wishListService = new WishListServiceImpl();
	
	public void selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int userSeq = (Integer) session.getAttribute("userSeq");

		System.out.println("Wish List session userSeq = "+userSeq);
		
		List<WishListDTO> list =wishListService.selectAll(userSeq);
		
		
		Gson gson = new Gson();
		String jsonArr = gson.toJson(list);
		PrintWriter out = response.getWriter();
		out.print(jsonArr);	
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("delete메서드 call");
		int furnitureSeq =  Integer.parseInt(request.getParameter("furnitureSeq"));
		
		System.out.println("Wish List furnitureSeq = "+furnitureSeq);
		
		int result = wishListService.delete(furnitureSeq);
	    PrintWriter out = response.getWriter();
	    out.print(result);
	}
}
