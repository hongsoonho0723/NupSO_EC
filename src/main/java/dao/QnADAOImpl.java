package dao;

import dto.FurnitureDTO;
import dto.QnADTO;
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

public class QnADAOImpl implements QnADAO {
    private Properties proFiles = new Properties();

    public QnADAOImpl() {
        InputStream in = QnADAOImpl.class.getClassLoader().getResourceAsStream("dbQuery.properties");
        try {
            proFiles.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insert(int furnitureSeq, String question,int state,String name, String password) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = proFiles.getProperty("query.insertQna");
        int result;

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, furnitureSeq);
            ps.setString(2, question);
            ps.setInt(3, state);
            ps.setString(4, name);
            ps.setString(5, password);
            result = ps.executeUpdate();
        } finally {
            DbUtil.dbClose(con, ps);
        }
        return result;
    }

    @Override
    public int delete(int qnaSeq) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = proFiles.getProperty("QnA.delete");
        int result;

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, qnaSeq);
            result = ps.executeUpdate();
        } finally {
            DbUtil.dbClose(con, ps);
        }
        return result;
    }

    @Override
    public String getPwd(int qnaSeq) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFiles.getProperty("query.getPwd");
        String pwd = null;

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, qnaSeq);
            rs = ps.executeQuery();
            while (rs.next()) {
                pwd = rs.getString("pwd");
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return pwd;
    }

	@Override
	public List<QnADTO> selectAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFiles.getProperty("QnA.selectAll");
        System.out.println(sql);
        
        List<QnADTO> list = new ArrayList<QnADTO>();
        QnADTO qna = null;

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
            	qna = new QnADTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5) , 
            			rs.getString(6), rs.getString("reg_date"), rs.getString("name"), rs.getString("password"));
            	qna.getFurniture().setFurnitureName(rs.getString(10));
            	list.add(qna);
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        
		return list;
	}

	@Override
	public int update(QnADTO qna) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFiles.getProperty("QnA.update");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, qna.getAnswer());
			ps.setString(2, qna.getState());
			ps.setInt(3, qna.getQnASeq());
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public QnADTO select(int qnaSeq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		QnADTO qna = null;
		String sql = proFiles.getProperty("QnA.select");
		System.out.println("select sql "+ sql);
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qnaSeq);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				qna = new QnADTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5) , 
            			rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}

			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		
		return qna;
	}

	@Override
	public List<QnADTO> selectCount() throws SQLException {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFiles.getProperty("QnA.selectCount");
        System.out.println(sql);
        
        List<QnADTO> list = new ArrayList<QnADTO>();
        QnADTO qna = null;

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
            	qna = new QnADTO();
            	qna.getFurniture().setFurnitureName(rs.getString(1));
            	qna.setQnaCount(rs.getInt(2));
            	list.add(qna);
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        
		return list;
	}
    
    
    
    
}
