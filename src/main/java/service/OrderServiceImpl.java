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
	
}
