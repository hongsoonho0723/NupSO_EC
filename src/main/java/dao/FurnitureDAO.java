package dao;

import dto.ColorDTO;
import dto.FurnitureDTO;
import dto.SizeDTO;

import java.sql.SQLException;
import java.util.List;

public interface FurnitureDAO {
    /*
    상품 상세 보기
     */
	FurnitureDTO selectFurnitureName(String furnitureName) throws SQLException;
	
	FurnitureDTO selectFurnitureByFurnitureSeq(int furnitureSeq) throws SQLException;


	List<FurnitureDTO> selectAll() throws SQLException;

	List<FurnitureDTO> selectFurnitureList() throws SQLException;

	List<ColorDTO> selectColorList(String furnitureName) throws SQLException;

	List<SizeDTO> selectSizeList(String furnitureName) throws SQLException;

	int findReviewSeqByfurnitureSeq(int furnitureSeq) throws SQLException;

	
}
