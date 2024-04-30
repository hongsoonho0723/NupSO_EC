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
		System.out.println("DAO 호출테스트");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<WishListDTO> list = new ArrayList<>();
		System.out.println("DAO 호출테스트2");
		String sql = proFile.getProperty("wishList.selectAll");
		WishListDTO wishlistDTO = new WishListDTO();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);
			rs = ps.executeQuery();
			System.out.println("DAO 호출테스트3");
			while(rs.next()) {
				System.out.println("DAO 호출테스트8");
				int furnitureSeq = rs.getInt(1);
				System.out.println("DAO 호출테스트7");
				FurnitureDTO furnitureDTO = FurnitureAdd(furnitureSeq);
				System.out.println("DAO 호출테스트4");
				wishlistDTO = new WishListDTO(rs.getInt(1),rs.getString(2),rs.getString(3),furnitureDTO);
				System.out.println("DAO 호출테스트5");
				list.add(wishlistDTO);
			}
			
			System.out.println("DAO 호출테스트6");
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		System.out.println("DAO 호출테스트1");
		return list;
		
	}

	private FurnitureDTO FurnitureAdd(int furnitureSeq) throws SQLException{
		System.out.println("furnitureTEST1");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("wishList.FurnitureAdd");
		FurnitureDTO furnitureDTO = new FurnitureDTO();
		System.out.println("furnitureTEST2");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, furnitureSeq);
			rs = ps.executeQuery();
			System.out.println("furnitureTEST3");
			if(rs.next()) {
				furnitureDTO = new FurnitureDTO(rs.getString(1),rs.getString(2),rs.getInt(3));
			}
			System.out.println("furnitureTEST4");
		return furnitureDTO;
	}finally {
		System.out.println("furnitureTEST5");
		DbUtil.dbClose(con, ps, rs);
		}
	}

	
	@Override
	public int insert(WishListDTO wishlistDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result =0;
		String sql = proFile.getProperty("wishList.insert");
		
		System.out.println(wishlistDTO);
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, wishlistDTO.getUserSeq());
			ps.setInt(2, wishlistDTO.getFurnitureSeq());
			ps.setString(3, wishlistDTO.getColorName());
			ps.setString(4, wishlistDTO.getSizeVal());
			
			result = ps.executeUpdate();
			
					
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
				
		return result;
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
