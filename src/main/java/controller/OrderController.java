package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import dto.OrderDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.OrderService;
import service.OrderServiceImpl;

public class OrderController implements Controller {
	OrderService orderService = new OrderServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}

	//관리자 main페이지에 사용할 주문 정보가져오기
	public ModelAndView selectOrderFunitureName(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		System.out.println("order controller까지 옴");
		List<OrderDTO> list = orderService.selectOrderFunitureName();
 		request.setAttribute("list", list);
   	
 		return new ModelAndView("admin/adminIndex.jsp");
	}
	
	
	
}
