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
import dto.OrderDTO;
import util.DbUtil;

public class OrderDAOImpl implements OrderDAO {
	 private Properties proFile = new Properties();
	 private CartDAO cartDAO = new CartDAOImpl();
	 public OrderDAOImpl() {
	        InputStream input = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
	        try {
	            proFile.load(input);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	@Override
	public List<OrderDTO> selectOrderFurnitureName() throws SQLException {
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

	@Override
	public int insertOrder(OrderDTO orderDTO) throws SQLException {
		 Connection con = null;
		 PreparedStatement ps = null;
		 int result = 0;
		 String sql = proFile.getProperty("order.insertOrder");
		 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderDTO.getUserSeq());
			ps.setInt(2 , orderDTO.getTotalPrice());
			ps.setString(3 ,orderDTO.getDeliveryDate());
			ps.setString(4 ,orderDTO.getDeliveryAddr1());
			ps.setString(5 ,orderDTO.getDeliveryAddr2());
			ps.setString(6 ,orderDTO.getDeliveryName());
			ps.setString(7 ,orderDTO.getDeliveryPhone());
			ps.setString(8 ,orderDTO.getDeliveryMemo());
			result = ps.executeUpdate();

		}finally {
				DbUtil.dbClose(con, ps);
			}
		return result;
	
	}
	
	@Override
	public int insertOrderInfo(OrderDTO orderDTO) throws SQLException{
		
		System.out.println("insertOrderInfo call");
		
		 Connection con = null;
		 PreparedStatement ps = null;
		 String sql = proFile.getProperty("order.insertOrderInfo");
		 //insert into order_info values(order_info_seq.nextval,?,?,?,?,?,?)
		 String sql2 ="update furniture set stock=(select stock from furniture where furniture_seq=?)-? where furniture_seq=?";
		 int result=0;
			  int orderSeq =0; //현재 orderSeq값 
			  String sql1 ="select max(order_seq) from orders";
			  con = DbUtil.getConnection(); 
			  PreparedStatement ps1 = con.prepareStatement(sql1); 
			  ResultSet rs1 = ps1.executeQuery(); 
			  if (rs1.next()) { 
				  orderSeq = (rs1.getInt(1)); // 현재 CART_SEQ 값을 사용 }
			  }
			  System.out.println("현재 orderSeq값 = "+ orderSeq);

			  List<CartDTO> list =cartDAO.selectAll(orderDTO.getUserSeq());
		 
		 for(CartDTO cartDTO : list) {
			 
			 int furnitureSeq = cartDTO.getFurnitureSeq();
			 int quantity = cartDTO.getQuantity();
			 String colorName = cartDTO.getColorName();
			 String sizeVal = cartDTO.getSizeVal();
			 String texture = cartDTO.getFurnitureDTO().getTexture();
		 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderSeq);
			ps.setInt(2, furnitureSeq);
			ps.setInt(3, quantity );
			ps.setString(4,colorName);
			ps.setString(5,sizeVal);
			ps.setString(6,texture);
		
			result= ps.executeUpdate();
		
		}finally {
			DbUtil.dbClose(con, ps);
		}
		 
	
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql2);
			ps.setInt(1, furnitureSeq);
			ps.setInt(2, quantity);
			ps.setInt(3, furnitureSeq);
			
			result= ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
		
		
		
		
		}//for end
		 
		 
		 return result;
	}
	


}