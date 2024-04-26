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
import util.DbUtil;

public class ProdCRUDDAOImpl implements ProdCRUDDAO{
	private Properties proFiles = new Properties();

    public ProdCRUDDAOImpl() {
        InputStream in = ProdCRUDDAOImpl.class.getClassLoader().getResourceAsStream("dbQuery.properties");
        try {
            proFiles.load(in);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    	
    	// 상품 조회
    	@Override
    	public List<FurnitureDTO> selectAll() throws SQLException {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = proFiles.getProperty("prodCRUD.selectAll");
            
            List<FurnitureDTO> list = new ArrayList<FurnitureDTO>();
            FurnitureDTO furniture = null;

            try {
                con = DbUtil.getConnection();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                	furniture = new FurnitureDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
                	        rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7),
                	        rs.getInt(8), rs.getString(9));
                	list.add(furniture);
                }
            }finally {
                DbUtil.dbClose(con, ps, rs);
            }
    		return list;
    	}
    	
    	// 상품 삭제
    	@Override
        public int delete(int furnitureSeq) throws SQLException {
            Connection con = null;
            PreparedStatement ps = null;
            String sql = proFiles.getProperty("prodCRUD.delete");
            System.out.println("sql = "+sql);
            int result;

            try {
                con = DbUtil.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, furnitureSeq);
                result = ps.executeUpdate();
            } finally {
                DbUtil.dbClose(con, ps);
            }
            System.out.println("얘! 다오야 너 지금 일 안 하고 자니?! = " + result);
            return result;
        }

}
