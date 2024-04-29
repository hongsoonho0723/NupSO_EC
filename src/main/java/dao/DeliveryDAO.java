package dao;

import java.sql.SQLException;
import java.util.List;

import dto.OrderDTO;

public interface OrderDAO {
    void updateOrderState(int orderSeq, int orderState) throws SQLException;
    List<OrderDTO> selectAll() throws SQLException;
}