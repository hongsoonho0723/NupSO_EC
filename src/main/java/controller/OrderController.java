package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import dto.OrderDTO;
import dto.UsersDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.OrderService;
import service.OrderServiceImpl;

public class OrderController implements Controller {
	OrderService orderService = new OrderServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}
	
	public ModelAndView selectOrderFunitureName(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		System.out.println("order controller까지 옴");
		List<OrderDTO> list = orderService.selectOrderFunitureName();
 		request.setAttribute("list", list);

 		return new ModelAndView("admin/adminIndex.jsp");
	}
	

	//마이페이지에서 사용할 주문 정보 가져오기
	public ModelAndView selectOrderAll(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
		HttpSession session = request.getSession();

		UsersDTO user = (UsersDTO)session.getAttribute("loginUser");
		
		int userSeq = user.getUserSeq();
		
		List<OrderDTO> list = orderService.selectOrderAll(userSeq);
		request.setAttribute("list", list);
		
		return new ModelAndView("myPage.jsp");
	}

}
