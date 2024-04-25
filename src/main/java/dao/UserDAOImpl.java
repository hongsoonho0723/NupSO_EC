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


public class UserDAOImpl implements UserDAO {
    private Properties proFile = new Properties();

    public UserDAOImpl() {
       InputStream input = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
        try {
            proFile.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String findUserNameBySeq(int userSeq) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFile.getProperty("query.findUserNameBySeq");
        String name = null;

        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, userSeq);
            rs = ps.executeQuery();
            if(rs.next()) name = rs.getString(1);
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }

        return name;
    }

    @Override
    public int findUserSeqById(String userId) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFile.getProperty("query.findUserSeqById");
        int result = 0;

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            if(rs.next()) result = rs.getInt(1);
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }

        return result;
    }

	@Override

	public UsersDTO login(UsersDTO usersDTO) throws SQLException {

		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UsersDTO dbDTO=null;
        String sql = proFile.getProperty("user.login");
        //String sql = "select user_seq,user_id,name from users where user_id=? and password=?";
		
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usersDTO.getUserId());
            ps.setString(2, usersDTO.getPassword());
            rs = ps.executeQuery();
            if(rs.next()) {
            	dbDTO = new UsersDTO(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        System.out.println("dao dbDTO = " +dbDTO);
        return dbDTO;

    }

	@Override
	public boolean idCheck(String userId) throws SQLException {
		 Connection con = null;
	     PreparedStatement ps = null;
	     ResultSet rs = null;
	     String sql = proFile.getProperty("user.idCheck");
	     //String sql = "select user_id from users where user_id = ?";
	     boolean result = true;

	        try {
	            con = DbUtil.getConnection();
	            ps = con.prepareStatement(sql);
	            ps.setString(1, userId);
	            rs = ps.executeQuery();
	            if(rs.next()) 
	            	result=false;
	            
	            
	        }finally {
	            DbUtil.dbClose(con, ps, rs);
	        }
		
		return result;
	}

	@Override
	public int insert(UsersDTO usersDTO) throws SQLException {
		 Connection con = null;
	     PreparedStatement ps = null;
	     String sql = proFile.getProperty("user.insert");
	     //String sql = "insert into users values(user_seq.nextval,?,?,?,?,?,?,?,default,default)";
	     int result = 0;

	        try {
	            con = DbUtil.getConnection();
	            ps = con.prepareStatement(sql);
	            ps.setString(1, usersDTO.getUserId());
	            ps.setString(2, usersDTO.getPassword());
	            ps.setString(3, usersDTO.getAddr());
	            ps.setString(4, usersDTO.getName());
	            ps.setInt(5, usersDTO.getAge());
	            ps.setString(6, usersDTO.getGender());
	            ps.setString(7, usersDTO.getPhone());
	            result = ps.executeUpdate();
	  
	            
	        }finally {
	            DbUtil.dbClose(con, ps);
	        }
		
		return result;
	}


		

	public List<UsersDTO> selectGender() throws SQLException {
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 String sql = proFile.getProperty("user.selectGender");
		 UsersDTO user = null;
		 List<UsersDTO> list = new ArrayList<UsersDTO>();
		 
		 
		 try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				user = new UsersDTO();
				user.setGender(rs.getString(1));
				list.add(user);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<UsersDTO> selectAge() throws SQLException {
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 String sql = proFile.getProperty("user.selectAge");
		 UsersDTO user = null;
		 List<UsersDTO> list = new ArrayList<UsersDTO>();
		 
		 
		 try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				user = new UsersDTO();
				user.setAge(rs.getInt(1));
				list.add(user);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public UsersDTO findUserById(String userId) throws SQLException {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UsersDTO user=null;
        String sql = proFile.getProperty("user.findUserById");

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            if(rs.next()) {
            	user = new UsersDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),
            			rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        System.out.println("dao user = " +user);
        return user;
	}

	
    
}
