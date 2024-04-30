package dao;

import java.sql.SQLException;

import java.util.List;

import dto.CartDTO;

public interface CartDAO {
	
	List<CartDTO> selectAll(int userSeq) throws SQLException ;

	int delete(int furintureSeq) throws SQLException;

	
	int insertCart(CartDTO cartDTO) throws SQLException;;
}
