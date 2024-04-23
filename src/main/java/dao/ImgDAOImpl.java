package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.FurnitureDTO;
import dto.ImgDTO;
import util.DbUtil;

public class ImgDAOImpl implements ImgDAO {
    private Properties proFile = new Properties();

    public ImgDAOImpl() {
        InputStream input = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
        try {
            proFile.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //is_detail 이 1이면 상세페이지 설명에 사용하고 아니면 슬라이드 사진으로 사용
    @Override
    public List<ImgDTO> selectImgDetail(FurnitureDTO furnitureDTO) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        FurnitureDTO furniture = furnitureDTO;
        String sql = proFile.getProperty("furniture.selectFurnitureImgDetail");

        System.out.println("selectImgDetail = " +sql);
        List<ImgDTO> imgList = new ArrayList<ImgDTO>();
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,furniture.getFurnitureName());
            rs = ps.executeQuery();
            while (rs.next()) {
            	ImgDTO img = new ImgDTO(rs.getInt("img_seq"),rs.getString("img_src"),rs.getString("img_type"));
            	if(rs.getInt("is_detail") == 1) {
            		imgList.add(img);
            	}
            }
        }finally {
            DbUtil.dbClose(con,ps,rs);
        }
        return imgList;
    }

	@Override
	public List<ImgDTO> selectImg(FurnitureDTO furnitureDTO) throws SQLException {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        FurnitureDTO furniture = furnitureDTO;
        String sql = proFile.getProperty("furniture.selectFurnitureImgDetail");

        System.out.println("selectImg = " +sql);
        List<ImgDTO> imgList = new ArrayList<ImgDTO>();
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,furniture.getFurnitureName());
            rs = ps.executeQuery();
            while (rs.next()) {
            	ImgDTO img = new ImgDTO(rs.getInt("img_seq"),rs.getString("img_src"),rs.getString("img_type"));
            	if(rs.getInt("is_detail") == 0) {
            		imgList.add(img);
            	}
            }
        }finally {
            DbUtil.dbClose(con,ps,rs);
        }
        return imgList;
	}
    
    
    
    
}
