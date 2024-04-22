package service;

import dto.FurnitureDTO;

import java.sql.SQLException;
import java.util.List;

public interface FurnitureService {
    /*
    상품 상세 정보
     */
    FurnitureDTO selectFurnitureNumber(String furnitureNumber) throws SQLException;

    /*
    상품 코드로 상품 sequence 찾기
     */
    int findFurnitureSeqByNumber(String furnitureNumber) throws SQLException;

	List<FurnitureDTO> selectAll() throws SQLException;
}
