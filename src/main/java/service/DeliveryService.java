package service;

import java.sql.SQLException;
import java.util.List;

import dto.OrderDTO;

public interface DeliveryService {
    void updateOrderState(int orderState) throws SQLException;
    List<OrderDTO> selectAll() throws SQLException;
}
