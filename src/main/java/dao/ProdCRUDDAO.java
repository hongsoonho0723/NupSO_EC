package dao;

import java.sql.SQLException;
import java.util.List;

import dto.FurnitureDTO;

public interface ProdCRUDDAO {
	// 상품 조회
	List<FurnitureDTO> selectAll() throws SQLException;
	
	// 상품 삭제
	int delete(int furnitureSeq) throws SQLException;
	
	// 상품 추가
	int create(FurnitureDTO furniture) throws SQLException;

}