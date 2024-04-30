package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.OrderDAO;
import dao.OrderDAOImpl;
import dto.OrderDTO;

public class OrderServiceImpl implements OrderService {

	OrderDAO orderDao = new OrderDAOImpl();
	
	@Override
	public List<OrderDTO> selectOrderFunitureName() throws SQLException, IOException {
		List<OrderDTO> list = orderDao.selectOrderFunitureName();

		return list;
	}

	@Override
	public List<OrderDTO> selectOrderAll(int userSeq) throws SQLException, IOException {
		List<OrderDTO> list = orderDao.selectOrderAll(userSeq);

		for (OrderDTO order : list) {
			order.setDeliveryState(setDeliveryStae(order.getOrderState()));
		}
		
		return list;
	}
	
	
	/*
	 * 	0 일때 취소
		1 일때 결제완료
		2 일때 배송중
		3 일때 배송완료
	 * */
	public String setDeliveryStae(int orderState) {
		String deliveryState="";
		System.out.println(orderState);
		switch (orderState) {
			case 0: {
				deliveryState= "주문 취소";
				break;
			}
			case 1: {
				deliveryState= "결제 완료";
				break;
			}
			case 2: {
				deliveryState= "배송중";
				break;
			}
			case 3: {
				deliveryState= "배송 완료";
				break;
			}
		}
		return deliveryState;
	}

	@Override
	public int insertOrder(OrderDTO orderDTO) throws SQLException {

		int rs = orderDao.insertOrder(orderDTO);
		int result=0;
		if(rs==1) {
			result = orderDao.insertOrderInfo(orderDTO);
		}
		
		
		return result;
	}
	
}
