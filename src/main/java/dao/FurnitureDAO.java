package dao;

import dto.FurnitureDTO;

import java.sql.SQLException;

public interface FurnitureDAO {
    /*
    상품 상세 보기
     */
    FurnitureDTO selectFurnitureByCode(String FURN_CODE) throws SQLException;
}
