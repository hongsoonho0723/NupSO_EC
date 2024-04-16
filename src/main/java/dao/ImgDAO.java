package dao;

import dto.ImgDTO;

import java.sql.SQLException;
import java.util.List;

public interface ImgDAO {
    /*
    소파 대표 이미지 불러오기
     */
    List<ImgDTO> selectImg(int furnitureSeq) throws SQLException;

    /*
    특정 소파 상품에 대한 상세 설명 이미지 불러오기
     */
    List<ImgDTO> selectDetailImg(int furnitureSeq) throws SQLException;
}
