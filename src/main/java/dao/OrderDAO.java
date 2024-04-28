package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dto.OrderDTO;

public interface OrderDAO {

	List<OrderDTO> selectOrderFunitureName() throws SQLException;

	List<OrderDTO> selectOrderAll(int userSeq) throws SQLException;

	int insertOrder(OrderDTO orderDTO) throws SQLException;
	
	int insertOrderInfo(OrderDTO orderDTO) throws SQLException;
}
