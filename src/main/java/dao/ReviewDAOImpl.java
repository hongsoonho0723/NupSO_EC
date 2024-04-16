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

public class ReviewDAOImpl implements ReviewDAO {
    Properties proFile = new Properties();

    public ReviewDAOImpl() throws IOException {
        InputStream in = ReviewDAOImpl.class.getClassLoader().getResourceAsStream("dbQuery.properties");
        proFile.load(in);
    }

    @Override
    public List<ReviewDTO> selectAllReviews(int furnitureSeq) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFile.getProperty("query.getProductReviews");
        List<ReivewDTO> reviews = new ArrayList<ReivewDTO>();

        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, furnitureSeq);
            rs = ps.executeQuery();
            while(rs.next()){
                int rev_seq = rs.getInt(1);
                ReviewDTO review = new ReviewDTO(rev_seq,rs.getInt(2),rs.getInt(3),
                        rs.getString(4),rs.getInt(5),rs.getString(6));
                review.setRevImgList(this.getRimg(con,rev_seq));
                reviews.add(review);
            }
        }finally {
            DbUtil.dbClose(null, ps, rs);
        }
        return reviews;
    }

    private List<RevImgDTO> getRimg(Connection con,int reviewSeq) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFile.getProperty("query.getProductReviewImages");
        List<RevImgDTO> list = new ArrayList<RevImgDTO>();

        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, reviewSeq);
            rs = ps.executeQuery();
            while(rs.next()){
                RevImgDTO revImgDTO = new RevImgDTO(rs.getInt(1),rs.getInt(2),
                        rs.getString(3),rs.getString(4));
                list.add(revImgDTO);
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return list;
    }
}
