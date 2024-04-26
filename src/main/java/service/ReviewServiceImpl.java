package service;

import dao.ReviewDAO;
import dao.ReviewDAOImpl;
import dto.ReviewDTO;
import dto.ReviewImgDTO;

import java.sql.SQLException;
import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    private ReviewDAO reviewDAO = new ReviewDAOImpl();


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

	@Override
	public List<ReviewDTO> selectAll(int furnitureSeq) throws SQLException {
		List<ReviewDTO> list = reviewDAO.selectAll(furnitureSeq);
		return list;
	}

	@Override
	public List<ReviewImgDTO> selectReviewImgByReviewSeq(int reviewSeq) throws SQLException{
		List<ReviewImgDTO> list = reviewDAO.selectReviewImgByReviewSeq(reviewSeq);
		return list;
	}

	@Override
	public List<ReviewDTO> selectReviewUser(int reviewSeq, int furnitureSeq) throws SQLException {
		List<ReviewDTO> list = reviewDAO.selectReviewUser(reviewSeq,furnitureSeq);
		return list;
	}

	@Override
	public int insert(int furnitureSeq, int userSeq, String review, int score, String imgName, String type)
			throws SQLException {
		int result = reviewDAO.insert(furnitureSeq,userSeq,review,score);
		int reviewSeq = 0;
		if (result == 0) throw new SQLException("리뷰 등록에 실패하였습니다.");
		List<ReviewDTO> list = reviewDAO.selectReviewByUserSeq(userSeq);
		for (ReviewDTO r : list) {
			if(r.getFurnitureSeq()==furnitureSeq && r.getReview().equals(review)) {
				reviewSeq = r.getReviewSeq();
			}
		}
		if(reviewSeq != 0) {
			reviewDAO.insertImg(reviewSeq,imgName,type);
		}
		return result;
		
	}
	
	
	

	
	
    
    
    
    
    
}
