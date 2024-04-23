package service;

import java.sql.SQLException;
import java.util.List;

import dto.CartDTO;

public interface CartService {

	List<CartDTO> selectAll() throws SQLException;
}
