package service;

import java.sql.SQLException;
import java.util.List;

import dto.FurnitureDTO;

public interface ProdCRUDService {
	List<FurnitureDTO> selectAll() throws SQLException;
	
	void delete(int furnitureSeq) throws SQLException;
}