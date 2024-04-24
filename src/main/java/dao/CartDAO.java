package dao;

import java.sql.SQLException;
import java.util.List;

import dto.CartDTO;

public interface CartDAO {
	
	public List<CartDTO> selectAll() throws SQLException ;

}
