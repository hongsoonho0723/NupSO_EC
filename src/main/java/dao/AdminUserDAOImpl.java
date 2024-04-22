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

import dto.UsersDTO;
import util.DbUtil;

public class AdminUserDAOImpl implements AdminUserDAO {
	private Properties proFiles = new Properties();
	
	
	public AdminUserDAOImpl() {
		InputStream input = AdminUserDAOImpl.class.getClassLoader().getResourceAsStream("dbQuery.properties");
        try {
            proFiles.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@Override
	public List<UsersDTO> selectUserBySeq(int userSeq) throws SQLException {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFiles.getProperty("AdminUser.selectAll");
       
        List<UsersDTO> list = new ArrayList<UsersDTO>();
        UsersDTO user = null;
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
            	user = new UsersDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5) , 
            			rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            	
            	list.add(user);
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        
		return list;
	}
	

	@Override
	public List<UsersDTO> findUserSeqByState(String userState) throws SQLException {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFiles.getProperty("AdminUser.selectByState");
       
        List<UsersDTO> list = new ArrayList<UsersDTO>();
        UsersDTO user = null;
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
            	user = new UsersDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5) , 
            			rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            	
            	list.add(user);
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        
		return list;
	}

	
	@Override
	public int delete(int userSeq) throws SQLException {
		 	Connection con = null;
	        PreparedStatement ps = null;
	        String sql = proFiles.getProperty("AdminUser.delect");
	        int result;
	        
	        try {
	            con = DbUtil.getConnection();
	            ps = con.prepareStatement(sql);
	            result = ps.executeUpdate();
	        } finally {
	            DbUtil.dbClose(con, ps);
	        }
	        return result;
	    }

	

}
