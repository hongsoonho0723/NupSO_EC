package dao;

import dto.FurnitureDTO;
import util.DbUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class FurnitureDAOImpl implements FurnitureDAO {
    Properties proFile = new Properties();

    public FurnitureDAOImpl() throws IOException {
        InputStream input = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
        proFile.load(input);
    }
    @Override
    public FurnitureDTO selectByFurnitureByNumber(String furnitureNumber) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        FurnitureDTO furniture = null;
        String sql = proFile.getProperty("query.selectByFurnitureNumber");

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, furnitureNumber);

            rs = ps.executeQuery();
            if(rs.next()){
                furniture = new FurnitureDTO(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),
                rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9));
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return furniture;
    }

    @Override
    public int findFurnitureSeqByNumber(String furnitureNumber) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFile.getProperty("query.findFurnitureSeqByNumber");

        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, furnitureNumber);
            rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
}
