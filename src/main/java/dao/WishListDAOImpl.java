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
import dto.WishListDTO;
import util.DbUtil;


public class WishListDAOImpl implements WishListDAO {
	private Properties proFile = new Properties();
	
	
	
	public WishListDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
        try {
            proFile.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@Override
	public List<WishListDTO> selectAll(int userSeq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<WishListDTO> list = new ArrayList<>();
		String sql = proFile.getProperty("wishList.selectAll");
		WishListDTO wishlistDTO = new WishListDTO();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int furnitureSeq = rs.getInt(1);
				FurnitureDTO furnitureDTO = FurnitureAdd(furnitureSeq);
				
				wishlistDTO = new WishListDTO(rs.getInt(1),rs.getString(2),rs.getString(3),furnitureDTO);
				
				list.add(wishlistDTO);
			}
			
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}

	private FurnitureDTO FurnitureAdd(int furnitureSeq) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("wishList.FurnitureAdd");
		FurnitureDTO furnitureDTO = new FurnitureDTO();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, furnitureSeq);
			rs = ps.executeQuery();
		
			if(rs.next()) {
				furnitureDTO = new FurnitureDTO(rs.getString(1),rs.getString(2),rs.getInt(3));
			}
		
		return furnitureDTO;
	}finally {
		DbUtil.dbClose(con, ps, rs);
		}
	}

	
	@Override
	public int delete(int furintureSeq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result =0;
		String sql = proFile.getProperty("wishList.delete");
		WishListDTO wihsListDTO = new WishListDTO();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, furintureSeq);
			result = ps.executeUpdate();
			
					
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
				
		return result;
	}

}
