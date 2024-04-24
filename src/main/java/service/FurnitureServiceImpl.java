package service;

import dao.FurnitureDAO;
import dao.FurnitureDAOImpl;
import dto.ColorDTO;
import dto.FurnitureDTO;
import dto.SizeDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class FurnitureServiceImpl implements FurnitureService {
    private FurnitureDAO furnitureDAO = new FurnitureDAOImpl();

	@Override
	public FurnitureDTO selectFurnitureName(String furnitureName) throws SQLException {
		 FurnitureDTO furnitureDTO = furnitureDAO.selectFurnitureName(furnitureName);
	        if (furnitureDTO == null) throw new SQLException("해당 모델 번호에 해당하는 정보가 없습니다.");
	        return furnitureDTO;
	}


	@Override
	public List<FurnitureDTO> selectAll() throws SQLException {
		List<FurnitureDTO> list = furnitureDAO.selectAll();
		if(list.isEmpty()) throw new SQLException("정보 검색에 실패했습니다.");
		return list;
	}

	@Override
	public List<FurnitureDTO> selectFurnitureList() throws SQLException {
		List<FurnitureDTO> list = furnitureDAO.selectFurnitureList();
		if(list.isEmpty()) throw new SQLException("정보 검색에 실패했습니다.");
		return list;
	}


	@Override
	public List<ColorDTO> selectColorList(String furnitureName) throws SQLException {
		List<ColorDTO> list = furnitureDAO.selectColorList(furnitureName);
		if(list.isEmpty()) throw new SQLException("정보 검색에 실패했습니다.");
		return list;
	}


	@Override
	public List<SizeDTO> selectSizeList(String furnitureName) throws SQLException {
		List<SizeDTO> list = furnitureDAO.selectSizeList(furnitureName);
		if(list.isEmpty()) throw new SQLException("정보 검색에 실패했습니다.");
		return list;
	}


	@Override
	public int findReviewSeqByfurnitureSeq(int furnitureSeq) throws SQLException {
		int reviewSeq = furnitureDAO.findReviewSeqByfurnitureSeq(furnitureSeq);
		return reviewSeq;
	}

	
	
	
    
    
}
