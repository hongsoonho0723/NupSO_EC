package dao;

import dto.ImgDTO;
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

public class ImgDAOImpl implements ImgDAO {
    private Properties proFile = new Properties();

    public ImgDAOImpl() {
        InputStream input = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
        try {
            proFile.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ImgDTO> selectImg(int furnitureSeq) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ImgDTO> imgList = new ArrayList<>();
        String sql = proFile.getProperty("query.selectImg");

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,furnitureSeq);
            rs = ps.executeQuery();
            while (rs.next()) {
                ImgDTO imgDTO = new ImgDTO(rs.getInt(1),rs.getString(2),rs.getString(3));
                imgList.add(imgDTO);
            }
        }finally {
            DbUtil.dbClose(conn,ps,rs);
        }
        return imgList;
    }

    @Override
    public List<ImgDTO> selectDetailImg(int furnitureSeq) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ImgDTO> imgList = new ArrayList<>();
        String sql = proFile.getProperty("query.selectDetailImg");

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,furnitureSeq);
            rs = ps.executeQuery();
            while (rs.next()) {
                ImgDTO imgDTO = new ImgDTO(rs.getInt(1),rs.getString(2),rs.getString(3));
                imgList.add(imgDTO);
            }
        }finally {
            DbUtil.dbClose(conn,ps,rs);
        }
        return imgList;
    }
}
