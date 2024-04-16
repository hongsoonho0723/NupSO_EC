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
    public FurnitureDTO selectFurnitureByCode(String FURN_CODE) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        FurnitureDTO furniture = null;
        String sql = proFile.getProperty("query.selectByFurnitureCode");

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                furniture = new FurnitureDTO(rs.getString(2),rs.getString(3), rs.getString(4),
                rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8));
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return furniture;
    }
}
