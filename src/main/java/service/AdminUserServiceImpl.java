package service;

import dao.ReviewDAO;

import dao.ReviewDAOImpl;
import dto.ReviewDTO;

import java.sql.SQLException;
import java.util.List;

public class AdminUserServiceImpl implements AdminUserService {

    private ReviewDAO reviewDAO = new ReviewDAOImpl();

    @Override
    public List<ReviewDTO> selectAllReviews(int furnitureSeq) throws SQLException {
        List<ReviewDTO> list = reviewDAO.selectAllReviews(furnitureSeq);
        return list;
    }

    @Override
    public int findUserSeq(int reviewSeq) throws SQLException {
        int userSeq = reviewDAO.findUserSeq(reviewSeq);
        if (userSeq == 0) throw new SQLException("리뷰를 작성한 회원번호 조회를 실패하였습니다.");
        return userSeq;
    }

	@Override
	public List<ReviewDTO> selectAll() throws SQLException {
		List<ReviewDTO> list = reviewDAO.selectAll();
		return list;
	}

	@Override
	public int delete(int reviewSeq) throws SQLException {
		int result = reviewDAO.delete(reviewSeq);
		if (result == 0) throw new SQLException("리뷰 삭제에 실패하였습니다.");
		return result;
	}

	@Override
	public List<ReviewDTO> selectReviewCount() throws SQLException {
		List<ReviewDTO> list = reviewDAO.selectReviewCount();
		return list;

	}
    
    
    
    
    
}
