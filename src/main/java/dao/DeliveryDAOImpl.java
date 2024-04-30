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

import dto.OrderDTO;
import util.DbUtil;

public class DeliveryDAOImpl implements DeliveryDAO{
	private Properties proFiles = new Properties();

    public DeliveryDAOImpl() {
        InputStream in = DeliveryDAOImpl.class.getClassLoader().getResourceAsStream("dbQuery.properties");
        try {
            proFiles.load(in);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 // 상품 조회
	@Override
	public List<OrderDTO> selectAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFiles.getProperty("delivery.selectAll");
        
        List<OrderDTO> list = new ArrayList<OrderDTO>();
        OrderDTO order = null;

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
            	order = new OrderDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3),
            	        rs.getInt(4), rs.getString(5), rs.getString(6));
            	list.add(order);
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
		return list;
    }

	@Override
	public int update(OrderDTO order) throws SQLException {
		 Connection con = null;
	     PreparedStatement ps = null;
	     String sql = proFiles.getProperty("order.update");
	     int result=0;
	     
	     try {
	            con = DbUtil.getConnection();
	            ps = con.prepareStatement(sql);
	            ps.setInt(1, order.getOrderState());
	            ps.setInt(2, order.getOrderSeq());
	            result = ps.executeUpdate();
	            
	        }finally {
	            DbUtil.dbClose(con, ps, null);
	        }
		return result;
	}
	
	
	
}
