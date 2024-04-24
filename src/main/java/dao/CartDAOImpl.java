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
	public List<CartDTO> selectAll() throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CartDTO> list = new ArrayList<>();
		String sql = proFile.getProperty("cart.selectAll");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				
				
				
			}
			
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		
		
		return list;
	}

}
