package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dto.OrderDTO;

public interface OrderService {

	List<OrderDTO> selectOrderFurnitureName() throws SQLException, IOException;

	List<OrderDTO> selectOrderAll(int userSeq) throws SQLException, IOException;

	int insertOrder(OrderDTO orderDTO) throws SQLException;

}