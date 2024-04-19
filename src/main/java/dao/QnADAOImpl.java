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
        String sql = proFiles.getProperty("query.deleteQna");
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
        FurnitureDTO furniture = new FurnitureDTO();

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
            	qna = new QnADTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5) , 
            			rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            	furniture.setFURNITURE_NAME(rs.getString(10));
            	qna.setFurniture(furniture);
            	list.add(qna);
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        
		return list;
	}
    
    
    
    
}
