package service;

import java.sql.SQLException;
import java.util.List;

import dao.DeliveryDAO;
import dao.DeliveryDAOImpl;
import dto.OrderDTO;

public class DeliveryServiceImpl implements DeliveryService {
private DeliveryDAO deliveryDAO = new DeliveryDAOImpl();
	
	@Override
	public List<OrderDTO> selectAll() throws SQLException {
		List<OrderDTO> list = deliveryDAO.selectAll();
		System.out.println("Service에서 DAO로부터 받은 데이터: " + list); 
		return list;
	}

	@Override
	public int update(OrderDTO order) throws SQLException {
		int result = deliveryDAO.update(order);
		return result;
	}
	
	
}