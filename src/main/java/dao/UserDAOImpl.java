package dao;

import util.DbUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

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
}
