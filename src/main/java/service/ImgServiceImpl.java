package service;

import dao.ImgDAO;
import dao.ImgDAOImpl;
import dto.ImgDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ImgServiceImpl implements ImgService {
    ImgDAO imgDAO = new ImgDAOImpl();

    public ImgServiceImpl() throws IOException {
    }

    @Override
    public List<ImgDTO> selectImg(int furnitureSeq) throws SQLException {
        List<ImgDTO> imgList = imgDAO.selectImg(furnitureSeq);
        if(imgList.isEmpty()) throw new SQLException("해당 상품에는 이미지가 등록되지 않았습니다.");
        return imgList;
    }

    @Override
    public List<ImgDTO> selectDetailImg(int furnitureSeq) throws SQLException {
        List<ImgDTO> imgList = imgDAO.selectDetailImg(furnitureSeq);
        if(imgList.isEmpty()) throw new SQLException("해당 상품에는 상세 이미지가 등록되지 않았습니다.");
        return imgList;
    }
}
