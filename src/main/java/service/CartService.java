package service;

import java.sql.SQLException;

import java.util.List;

import dto.CartDTO;

public interface CartService {
	
	List<CartDTO> selectAll(int userSeq) throws SQLException;

	
	int delete(int furnitureSeq) throws SQLException;

	int insertCart(CartDTO cartDTO) throws SQLException;
	

}
