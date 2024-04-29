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
    public FurnitureDTO selectFurnitureName(String furnitureName) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        FurnitureDTO furniture = null;
        String sql = proFile.getProperty("furniture.selectFurnitureByName");

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);           
            ps.setString(1, furnitureName);
            rs = ps.executeQuery();
            if(rs.next()){
            	furniture = new FurnitureDTO(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),
		                rs.getInt(5), rs.getInt(6), rs.getInt("sale_count"), rs.getString("category"), rs.getString(9));
            	furniture.setFurnitureImgSrc(rs.getString("furniture_img_src"));
            	furniture.setTexture(rs.getString("texture"));
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return furniture;
    }
    
    @Override
    public List<ColorDTO> selectColorList(String furnitureName) throws SQLException{
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ColorDTO color = null;
        List<ColorDTO> list = new ArrayList<ColorDTO>();
        String sql = proFile.getProperty("color.selectAllByFurniutreName");
        try{
        	con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, furnitureName);
            rs = ps.executeQuery();
            while(rs.next()){
                color = new ColorDTO(rs.getString("color_name"));
                list.add(color);
            }
        }finally {
            DbUtil.dbClose(null, ps, rs);
        }
        return list;
    }

   

    @Override
	public List<SizeDTO> selectSizeList(String furnitureName) throws SQLException {
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<SizeDTO> list = new ArrayList<SizeDTO>();
        SizeDTO size = null;
        String sql = proFile.getProperty("size.selectAllByFurnitureName");
        try{
        	con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, furnitureName);
            rs = ps.executeQuery();
            while(rs.next()){
            	size=new SizeDTO(rs.getString("size_val"));
                list.add(size);
            }
        }finally {
            DbUtil.dbClose(null, ps, rs);
        }
        return list;
	}

    

	@Override
	public int findReviewSeqByfurnitureSeq(int furnitureSeq) throws SQLException {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int reviewSeq= 0;
        String sql = proFile.getProperty("review.findReviewSeqByfurnitureSeq");
        try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, furnitureSeq);
			rs = ps.executeQuery();
			if(rs.next()) {
				reviewSeq=rs.getInt(1);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
        
		return reviewSeq;
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



	@Override
	public List<FurnitureDTO> selectFurnitureList() throws SQLException {
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 String sql = proFile.getProperty("furniture.selectAll");
		 FurnitureDTO furniture = null;
		 List<FurnitureDTO> list = new ArrayList<FurnitureDTO>();
		 int deletFalg =1;

		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				furniture = new FurnitureDTO(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),
		                rs.getInt(5), rs.getInt(6), rs.getInt("sale_count"), rs.getString("category"), rs.getString(9));
				furniture.setFurnitureImgSrc(rs.getString("furniture_img_src"));
				furniture.setFlag(rs.getInt("flag"));
				
				if(furniture.getFlag() != deletFalg) {
					list.add(furniture);
				}
				
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public FurnitureDTO selectFurnitureByFurnitureSeq(int furnitureSeq) throws SQLException {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        FurnitureDTO furniture = null;
        String sql = proFile.getProperty("furniture.selectFurnitureBySeq");

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);           
            ps.setInt(1, furnitureSeq);
            rs = ps.executeQuery();
            if(rs.next()){
            	furniture = new FurnitureDTO(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),
		                rs.getInt(5), rs.getInt(6), rs.getInt("sale_count"), rs.getString("category"), rs.getString(9));
            	furniture.setFurnitureImgSrc(rs.getString("furniture_img_src"));
            	furniture.setTexture(rs.getString("texture"));
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return furniture;
	}
    
	@Override
	public List<FurnitureDTO> selectFurnitureOrderBySales() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FurnitureDTO> list = new ArrayList<FurnitureDTO>();
		String sql = proFile.getProperty("furniture.selectFurnitureOrderBySales");
		FurnitureDTO furniture = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				furniture = new FurnitureDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getInt(6), rs.getInt("sale_count"), rs.getString("category"), rs.getString(9));
				furniture.setFurnitureImgSrc(rs.getString("furniture_img_src"));
				list.add(furniture);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
    
    
    
}