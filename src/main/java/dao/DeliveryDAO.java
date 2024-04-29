package dao;

import java.sql.SQLException;
import java.util.List;

import dto.OrderDTO;

public interface DeliveryDAO {
	// 배송 관리를 위한 주문 현황 조회
		List<OrderDTO> selectAll() throws SQLException;
}