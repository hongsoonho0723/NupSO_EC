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
   
   public ModelAndView selectOrderFurnitureName(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
      System.out.println("order controller까지 옴");
      List<OrderDTO> list = orderService.selectOrderFurnitureName();
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
   //주문성공시 주문내역 저장
   public ModelAndView insertOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
	   System.out.println("insertOrder call");
	   
	   HttpSession session = request.getSession();
	   int userSeq = (int) session.getAttribute("userSeq");
	   
	   String deliveryDate = request.getParameter("date");
	   String deliveryAddr1 = request.getParameter("addr1");
	   String deliveryAddr2 = request.getParameter("addr2");
	   String deliveryName = request.getParameter("name");
	   String deliveryPhone = request.getParameter("phone");
	   String deliveryMemo = request.getParameter("memo");
	   int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
	   
	   OrderDTO orderDTO = new OrderDTO(userSeq,totalPrice,deliveryDate,deliveryAddr1,deliveryAddr2,deliveryName,deliveryPhone,deliveryMemo);
	   
	   
	   orderService.insertOrder(orderDTO);
	   
	   List<OrderDTO> list = orderService.selectOrderAll(userSeq);
	   request.setAttribute("list", list);
      
      return new ModelAndView("myPage.jsp");
   }
   

   //개별주문시 주문내역 저장
   public ModelAndView insertOrderInof(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
	   
	   HttpSession session = request.getSession();
	   int userSeq = (int) session.getAttribute("userSeq");
	   
	   String deliveryDate = request.getParameter("date");
	   String deliveryAddr1 = request.getParameter("addr1");
	   String deliveryAddr2 = request.getParameter("addr2");
	   String deliveryName = request.getParameter("name");
	   String deliveryPhone = request.getParameter("phone");
	   String deliveryMemo = request.getParameter("memo");
	   int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
	   
	   int furnitureSeq = Integer.parseInt(request.getParameter("furnitureSeq"));
	   int quantity = Integer.parseInt(request.getParameter("quantity"));
	   String colorName = request.getParameter("colorName");
	   String sizeVal = request.getParameter("sizeVal");
	   String texture = request.getParameter("texture");

	   
	   OrderDTO orderDTO = new OrderDTO(userSeq,totalPrice,deliveryDate,deliveryAddr1,deliveryAddr2,deliveryName,
			   deliveryPhone,deliveryMemo,furnitureSeq,quantity,colorName,sizeVal);
	  
	   //orderService.insertOrderInof(orderDTO);
	   
	   List<OrderDTO> list = orderService.selectOrderAll(userSeq);
	   request.setAttribute("list", list);
	   
	   return new ModelAndView("myPage.jsp");
   }

	   
   
   
}