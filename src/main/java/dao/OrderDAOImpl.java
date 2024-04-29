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
import dto.OrderDTO;
import util.DbUtil;

public class OrderDAOImpl implements OrderDAO {
	 private Properties proFile = new Properties();
	 
	 public OrderDAOImpl() {
	        InputStream input = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
	        try {
	            proFile.load(input);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	@Override
	public List<OrderDTO> selectOrderFunitureName() throws SQLException {
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 String sql = proFile.getProperty("order.selectFurnitureName");

		 OrderDTO order = null;
		 List<OrderDTO> list = new ArrayList<OrderDTO>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				order = new OrderDTO();
				order.setOrderSeq(rs.getInt(1));
				order.getFurniture().setFurnitureNumber(rs.getString(2));
				order.getFurniture().setFurnitureName(rs.getString(3));
				order.getOrderInfo().setColorName(rs.getString(4));
				order.getOrderInfo().setSizeVal(rs.getString(5));
				order.setDeliveryDate(rs.getString(6));
				
				list.add(order);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		 
		return list;
	}

	@Override
	public List<OrderDTO> selectOrderAll(int userSeq) throws SQLException {
		Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 String sql = proFile.getProperty("order.selectOrderAll");

		 OrderDTO order = null;
		 List<OrderDTO> list = new ArrayList<OrderDTO>();

		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				order = new OrderDTO();
				order.getFurniture().setFurnitureSeq(rs.getInt(1));
				order.getFurniture().setFurnitureImgSrc(rs.getString(2));
				order.getFurniture().setFurnitureName(rs.getString(3));
				order.setTotalPrice(rs.getInt(4));
				order.getFurniture().setCategory(rs.getString(5));
				order.getFurniture().setTexture(rs.getString(6));
				order.setOrderState(rs.getInt(7));
				order.setDeliveryDate(rs.getString(8));
				order.getOrderInfo().setColorName(rs.getString(9));
				order.getOrderInfo().setSizeVal(rs.getString(10));
				order.getOrderInfo().setQuantity(rs.getInt(11));
				list.add(order);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		 
		return list;
	}

	
	
}
