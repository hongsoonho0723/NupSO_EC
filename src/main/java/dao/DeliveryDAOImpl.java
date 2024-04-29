package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.OrderDTO;

public class OrderDAOImpl implements OrderDAO {
    private Connection conn;

    public OrderDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void updateOrderState(int orderSeq, int orderState) throws SQLException {
        String sql = "UPDATE Orders SET order_state = ? WHERE order_seq = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, orderState);
            pstmt.setInt(2, orderSeq);
            pstmt.executeUpdate();
        }
    }

    @Override
    public List<OrderDTO> selectAll() throws SQLException {
        List<OrderDTO> list = new ArrayList<>();
        String sql = "SELECT order_seq, user_seq, furniture_seq, furniture_number, furniture_name, color_name, size_val, category, quantity, delivery_date, order_state FROM Orders";
        try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setOrderSeq(rs.getInt("order_seq"));
                orderDTO.setUserSeq(rs.getInt("user_seq"));
                orderDTO.setFurnitureSeq(rs.getInt("furniture_seq"));
                orderDTO.setFurnitureNumber(rs.getString("furniture_number"));
                orderDTO.setFurnitureName(rs.getString("furniture_name"));
                orderDTO.setColorName(rs.getString("color_name"));
                orderDTO.setSizeVal(rs.getString("size_val"));
                orderDTO.setCategory(rs.getString("category"));
                orderDTO.setQuantity(rs.getInt("quantity"));
                orderDTO.setDeliveryDate(rs.getString("delivery_date"));
                orderDTO.setOrderState(rs.getInt("order_state"));
                list.add(orderDTO);
            }
        }
        return list;
    }
}
