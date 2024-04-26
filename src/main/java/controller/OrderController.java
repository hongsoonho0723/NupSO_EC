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
		// TODO Auto-generated method stub
		return null;
	}

	//관리자 main페이지에 사용할 주문 정보가져오기
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
		
		//test용 코드 로그인이 됬다는 과정하에 로그인 구현되고 user없으면 메시지 출력 -> 다시 로그인해 주세요.
		if(user==null) {
			user = new UsersDTO(45, "bob_jones", "secure789");
		}
		
		int userSeq = user.getUserSeq();
		
		List<OrderDTO> list = orderService.selectOrderAll(userSeq);
		request.setAttribute("list", list);
		
		return new ModelAndView("myPage.jsp");
	}
}
