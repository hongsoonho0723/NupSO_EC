package controller;

import java.sql.SQLException;
import java.util.List;

import dto.OrderDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeliveryController {
	private DeliveryService service = new DeliveryServiceImpl();
	
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        // 변경할 주문의 상태값을 받아옴
        int orderSeq = Integer.parseInt(request.getParameter("orderSeq"));
        int orderState = Integer.parseInt(request.getParameter("orderState"));
        
        // service.updateOrderState(orderSeq, orderState); // 주문 상태 업데이트 메서드 호출
        
        // 변경된 상태를 포함한 주문 리스트 다시 불러오기
        List<OrderDTO> list = service.selectAll();
        
        // request에 리스트 설정
        request.setAttribute("list", list);
        
        // ModelAndView 반환
        return new ModelAndView("admin/adminDelivery.jsp");
    }
}