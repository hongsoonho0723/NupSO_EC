package service;

import java.sql.SQLException;
import java.util.List;

import dto.OrderDTO;

public interface DeliveryService {
    List<OrderDTO> selectAll() throws SQLException;
    
    int update(OrderDTO order) throws SQLException;
}
