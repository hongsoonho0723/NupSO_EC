package dao;

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

import dto.UsersDTO;

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
    
    
}
