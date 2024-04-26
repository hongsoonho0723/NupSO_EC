package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dto.OrderDTO;

public interface OrderService {

	List<OrderDTO> selectOrderFunitureName() throws SQLException, IOException;

	List<OrderDTO> selectOrderAll(int userSeq) throws SQLException, IOException;

}
