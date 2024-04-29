package service;

import java.sql.SQLException;
import java.util.List;

import dao.OrderDAO;
import dto.OrderDTO;

public class DeliveryServiceImpl implements DeliveryService {
    private OrderDAO orderDAO;

    public DeliveryServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void updateOrderState(int orderSeq, int orderState) throws SQLException {
        orderDAO.updateOrderState(orderSeq, orderState);
    }

    @Override
    public List<OrderDTO> selectAll() throws SQLException {
        return orderDAO.selectAll();
    }
}