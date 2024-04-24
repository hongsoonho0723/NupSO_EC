package dao;

import dto.ReviewDTO;
import dto.ReviewImgDTO;
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
    private Properties proFile = new Properties();

    public ReviewDAOImpl() {
        InputStream input = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
        try {
            proFile.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int findUserSeq(int reviewSeq) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFile.getProperty("query.findUserReviews");
        int userSeq = 0;

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, reviewSeq);
            rs = ps.executeQuery();
            if(rs.next()) userSeq = rs.getInt(1);
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return userSeq;
    }



	@Override
	public List<ReviewDTO> selectAll() throws SQLException {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFile.getProperty("review.selectAll");
        List<ReviewDTO> list = new ArrayList<ReviewDTO>();
        ReviewDTO review = null;

        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                review = new ReviewDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3),
                        rs.getString(4),rs.getInt(5),rs.getString(6));
                review.getFurniture().setFurnitureName(rs.getString(7));
                review.getUser().setName(rs.getString(8));
                list.add(review);
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return list;
	}
	
	

	@Override
	public List<ReviewDTO> selectAll(int furnitureSeq) throws SQLException {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFile.getProperty("review.selectAllByfurnitureSeq");
        List<ReviewDTO> list = new ArrayList<ReviewDTO>();
        ReviewDTO review = null;

        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, furnitureSeq);
            rs = ps.executeQuery();
            while(rs.next()){
                review = new ReviewDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3),
                        rs.getString(4),rs.getInt(5),rs.getString(6));
                review.getUser().setName(rs.getString(8));
                list.add(review);
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return list;
	}

	@Override
	public int delete(int reviewSeq) throws SQLException {
		Connection con = null;
        PreparedStatement ps = null;
        String sql = proFile.getProperty("review.delete");
        int result = 0;
        
        try {
        	con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, reviewSeq);
            result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public List<ReviewDTO> selectReviewCount() throws SQLException {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFile.getProperty("review.selectReviewCount");
        List<ReviewDTO> list = new ArrayList<ReviewDTO>();
        ReviewDTO review = null;

        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	review = new ReviewDTO();
            	review.getFurniture().setFurnitureName(rs.getString(1));
            	review.setCount(rs.getInt(2));
                list.add(review);
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return list;
	}

	@Override
	public List<ReviewImgDTO> selectReviewImgByReviewSeq(int reviewSeq) throws SQLException {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFile.getProperty("review.selectReviewImgByReviewSeq");
        List<ReviewImgDTO> list = new ArrayList<ReviewImgDTO>();
        ReviewImgDTO reviewImg = null;

        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, reviewSeq);
            rs = ps.executeQuery();
            while(rs.next()){
            	reviewImg = new ReviewImgDTO(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4), rs.getString(5));
                list.add(reviewImg);
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return list;
	}

	@Override
	public List<ReviewDTO> selectReviewUser(int reviewSeq, int furnitureSeq) throws SQLException {
		List<ReviewDTO> list = this.selectAll(furnitureSeq);

			for (ReviewDTO reviewDTO : list) {
				String userName = reviewDTO.getUser().getName();
				reviewDTO.setReviewImgs(this.selectReviewImgByReviewSeq(reviewSeq,furnitureSeq,userName));
			}
		return list;
	}

	private List<ReviewImgDTO> selectReviewImgByReviewSeq(int reviewSeq,int furnitureSeq,String userName) throws SQLException {
        Connection con = null;
		PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFile.getProperty("review.selectReviewDetailImg");
        List<ReviewImgDTO> list = new ArrayList<ReviewImgDTO>();
        ReviewImgDTO reviewImg = null;

        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, reviewSeq);
            ps.setInt(2, furnitureSeq);
            rs = ps.executeQuery();
            while(rs.next()){
            	reviewImg = new ReviewImgDTO();
            	reviewImg.setImgSrc(rs.getString("img_src"));
            	reviewImg.setImgType(rs.getString("img_type"));
            	if(rs.getString("user_name").equals(userName)) {
            		System.out.println("이미지 추가됨");
            		list.add(reviewImg);
            	}
            }
        }finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return list;
	}
    
    
    
    
    
}
