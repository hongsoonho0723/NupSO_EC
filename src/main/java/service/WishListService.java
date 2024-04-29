package service;

import java.sql.SQLException;
import java.util.List;

import dto.WishListDTO;

public interface WishListService {
List<WishListDTO> selectAll(int userSeq) throws SQLException;

	
	int delete(int furnitureSeq) throws SQLException;
}
