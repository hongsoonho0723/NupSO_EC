package controller;

import java.sql.SQLException;
import java.util.List;

import dto.FurnitureDTO;
import dto.OrderDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.DeliveryService;
import service.DeliveryServiceImpl;

public class DeliveryController implements Controller{
	DeliveryService service = new DeliveryServiceImpl();
	
	public DeliveryController() {
	
	}
	
	public ModelAndView selectAll (HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println("controller 오니?");
		List<OrderDTO> list = service.selectAll();

		request.setAttribute("list", list);
		return new ModelAndView("admin/adminDelivery.jsp");
	}
	
	
	// 배송 상태 변경
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ModelAndView update (HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int orderSeq = Integer.parseInt(request.getParameter("orderSeq"));
		int userSeq = Integer.parseInt(request.getParameter("userSeq"));
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
		int orderState = Integer.parseInt(request.getParameter("orderState"));
		String deliveryDate = request.getParameter("deliveryDate");
		String regDate = request.getParameter("regDate");
		System.out.println(orderSeq);
		
		List<OrderDTO> list = service.selectAll();
		for (OrderDTO order : list) {
			if(order.getOrderSeq() == orderSeq) {
				order.setUserSeq(userSeq);
				order.setTotalPrice(totalPrice);
				order.setOrderState(orderState);
				order.setDeliveryDate(deliveryDate);
				order.setRegDate(regDate);
			}
		}
		
		request.setAttribute("list", list);
		
		System.out.println(list);
		
		return new ModelAndView("admin/adminDelivery.jsp");
	}
}