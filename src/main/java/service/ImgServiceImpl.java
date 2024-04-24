package service;

import dao.ImgDAO;
import dao.ImgDAOImpl;
import dto.FurnitureDTO;
import dto.ImgDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ImgServiceImpl implements ImgService {
    private ImgDAO imgDAO = new ImgDAOImpl();


    @Override
    public List<ImgDTO> selectImgDetail(FurnitureDTO furnitureDTO) throws SQLException {
    	List<ImgDTO> list = imgDAO.selectImgDetail(furnitureDTO);
        
        return list;
    }


	@Override
	public List<ImgDTO> selectImg(FurnitureDTO furnitureDTO) throws SQLException {
		List<ImgDTO> list = imgDAO.selectImg(furnitureDTO);
        
        return list;
	}
    
    
    
}
