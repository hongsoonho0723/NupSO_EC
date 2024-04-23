package service;

import dto.FurnitureDTO;
import dto.ImgDTO;

import java.sql.SQLException;
import java.util.List;

public interface ImgService {


    /*
    특정 소파 상품에 대한 상세 설명 이미지 불러오기
     */
	List<ImgDTO> selectImgDetail(FurnitureDTO furnitureDTO) throws SQLException;
	
	/*
	 * 상세페이지 슬라이드 사진 가져오기
	 * */
	List<ImgDTO> selectImg(FurnitureDTO furnitureDTO) throws SQLException;
}
