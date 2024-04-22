package dao;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ColorDTO;

public class ColorDAOImpl implements ColorDAO {

    @Override
    public List<ColorDTO> selectAllColor() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ColorDTO> allColorList = new ArrayList<>();

        try {
            con = DbUtil.getConnection();  // DB 연결
            String sql = "SELECT * FROM color";  // 쿼리문
            ps = con.prepareStatement(sql);  // 쿼리 실행 준비
            rs = ps.executeQuery();  // 쿼리 실행 및 결과 저장

            while (rs.next()) {  // 결과를 ColorDTO로 변환
                ColorDTO color = new ColorDTO(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3)
                );
                allColorList.add(color);  // 리스트에 추가
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;  // 오류 발생 시 예외 던지기
        } finally {
            DbUtil.dbClose(con, ps, rs);  // 자원 해제
        }

        return allColorList;
    }
}
