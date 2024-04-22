package dao;

import dto.ColorDTO;
import dto.FurnitureDTO;
import dto.ImgDTO;
import dto.SizeDTO;
import dto.TextureDTO;
import util.DbUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FurnitureDAOImpl implements FurnitureDAO {
    private Properties proFile = new Properties();

    public FurnitureDAOImpl() {
        InputStream input = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
        try {
            proFile.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FurnitureDTO selectByFurnitureByNumber(String furnitureNumber) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        FurnitureDTO furniture = null;
        String sql = proFile.getProperty("query.selectByFurnitureNumber");

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, furnitureNumber);

            rs = ps.executeQuery();
            if(rs.next()){
                int furniture_seq = rs.getInt(1);
                furniture = new FurnitureDTO(furniture_seq,rs.getString(2),rs.getString(3), rs.getString(4),
                rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9));
                furniture.setColorList(this.getColor(con,furniture_seq));
                furniture.setSizeList(this.getSize(con,furniture_seq));
                furniture.setTextureList(this.getTexture(con,furniture_seq));
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return furniture;
    }

    private List<ColorDTO> getColor(Connection con,int furniture_seq) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ColorDTO> list = new ArrayList<ColorDTO>();
        String sql = proFile.getProperty("query.selectColorByFurnitureSeq");
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, furniture_seq);
            rs = ps.executeQuery();
            while(rs.next()){
                ColorDTO color = new ColorDTO(rs.getString(1));
                list.add(color);
            }
        }finally {
            DbUtil.dbClose(null, ps, rs);
        }
        return list;
    }

    private List<SizeDTO> getSize(Connection con,int furniture_seq) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<SizeDTO> list = new ArrayList<SizeDTO>();
        String sql = proFile.getProperty("query.selectSizeByFurnitureSeq");
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, furniture_seq);
            rs = ps.executeQuery();
            while(rs.next()){
                SizeDTO size = new SizeDTO(rs.getString(1));
                list.add(size);
            }
        }finally {
            DbUtil.dbClose(null, ps, rs);
        }
        return list;
    }

    private List<TextureDTO> getTexture(Connection con,int furniture_seq) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TextureDTO> list = new ArrayList<TextureDTO>();
        String sql = proFile.getProperty("query.selectTextureByFurnitureSeq");
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, furniture_seq);
            rs = ps.executeQuery();
            while(rs.next()){
                TextureDTO texture = new TextureDTO(rs.getString(1));
                list.add(texture);
            }
        }finally {
            DbUtil.dbClose(null, ps, rs);
        }
        return list;
    }

    @Override
    public int findFurnitureSeqByNumber(String furnitureNumber) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFile.getProperty("query.findFurnitureSeqByNumber");

        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, furnitureNumber);
            rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

	@Override
	public List<FurnitureDTO> selectAll() throws SQLException {
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 String sql = proFile.getProperty("furniture.selectAll");
		 FurnitureDTO furniture = null;
		 List<FurnitureDTO> list = new ArrayList<FurnitureDTO>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				furniture = new FurnitureDTO(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),
		                rs.getInt(5), rs.getInt(6), rs.getInt("sale_count"), rs.getString("category"), rs.getString(9));
				list.add(furniture);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		 
		return list;
	}


	//isDetail 0: 상품 상세 설명, 1: 상품 대표 이미지
	@Override
	public List<FurnitureDTO> selectFurnitureList() throws SQLException {
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 String sql = proFile.getProperty("furniture.selectFurnitureImg");
		 System.out.println("sql selectFurnitureList"+sql);
		 FurnitureDTO furniture = null;
		 ImgDTO img = null;
		 List<FurnitureDTO> list = new ArrayList<FurnitureDTO>();
		 boolean mainImg = false;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				furniture = new FurnitureDTO(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),
		                rs.getInt(5), rs.getInt(6), rs.getInt("sale_count"), rs.getString("category"), rs.getString(9));
				if(rs.getInt("is_detail") ==1 ) mainImg= true; 
				img = new ImgDTO(rs.getInt("img_seq"),rs.getInt(1),rs.getString("img_src"),rs.getString("img_type"),mainImg);
				if(mainImg) {
					//메인 이미지
					furniture.setImg(img);
				}else {
					// 상세보기 이미지 리스트 저장
					furniture.getImgList().add(img);
				}
				list.add(furniture);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
    
    
    
    
}
