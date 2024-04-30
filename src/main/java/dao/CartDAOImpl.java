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

import dto.CartDTO;
import dto.FurnitureDTO;
import util.DbUtil;

public class CartDAOImpl implements CartDAO {

	 private Properties proFile = new Properties();

	    public CartDAOImpl() {
	       InputStream input = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
	        try {
	            proFile.load(input);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	@Override
	public List<CartDTO> selectAll(int userSeq) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CartDTO> list = new ArrayList<>();
		String sql = proFile.getProperty("cart.selectAll");
		//select FURNITURE_SEQ,QUANTITY,COLOR_NAME,SIZE_VAL from cart where user_seq=?
		CartDTO cartDTO = new CartDTO();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int furnitureSeq = rs.getInt(1);
				FurnitureDTO furnitureDTO = FurnitureAdd(furnitureSeq);
				int Price = furnitureDTO.getPrice();
				
				cartDTO = new CartDTO(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),Price,furnitureDTO);
				
				list.add(cartDTO);
			}
			
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}

	public FurnitureDTO FurnitureAdd(int furnitureSeq) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("cart.FurnitureAdd");
		//select furniture_name,furniture_img_src,price from  furniture where furniture_seq = ?
		FurnitureDTO furnitureDTO = new FurnitureDTO();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, furnitureSeq);
			rs = ps.executeQuery();
		
			if(rs.next()) {
				furnitureDTO = new FurnitureDTO(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4));
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
		String sql = proFile.getProperty("cart.delete");
		//String sql = "select *from cart where user_seq=?"
		CartDTO cartDTO = new CartDTO();
		
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

	@Override
	public int insertCart(CartDTO cartDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result =0;
		String sql = proFile.getProperty("cart.insertCart");
		//String sql =insert into cart values(cart_seq.nextval,?,?,?,default,?,?)
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cartDTO.getUserSeq());
			ps.setInt(2, cartDTO.getFurnitureSeq());
			ps.setInt(3, cartDTO.getQuantity());
			ps.setString(4, cartDTO.getSizeVal());
			ps.setString(5, cartDTO.getColorName());
			
			result = ps.executeUpdate();
			
					
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
				
		return result;
	}

	

}