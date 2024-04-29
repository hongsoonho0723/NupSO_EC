package dao;

import java.sql.SQLException;
import java.util.List;

import dto.WishListDTO;

public interface WishListDAO {
	
	List<WishListDTO> selectAll(int userSeq) throws SQLException ;

	int delete(int furintureSeq) throws SQLException;
}
