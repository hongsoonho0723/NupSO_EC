package controller;

import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import dto.CartDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.CartService;
import service.CartServiceImpl;

public class CartAjaxController implements RestController {

	CartService cartService = new CartServiceImpl();
	
	
	public void selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("111111111111");
		HttpSession session = request.getSession();
		int userSeq = (Integer) session.getAttribute("userSeq");

		System.out.println("session userSeq = "+userSeq);
		
		List<CartDTO> list =cartService.selectAll(userSeq);
		
		
		Gson gson = new Gson();
		String jsonArr = gson.toJson(list);
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
	
		
	}
	
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("delete메서드 call");
		int furnitureSeq =  Integer.parseInt(request.getParameter("furnitureSeq"));
		
		System.out.println("furnitureSeq = "+furnitureSeq);
		
		
		
		int result =  cartService.delete(furnitureSeq);
	    PrintWriter out = response.getWriter();
	    out.print(result);
	}
	
	
	public void checkout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("checkout메서드 call");
		HttpSession session = request.getSession();
		System.out.println(request.getParameter("furnitureList"));
		
		session.setAttribute("furnitureList", request.getParameter("furnitureList"));
		
		
	}
	
}
