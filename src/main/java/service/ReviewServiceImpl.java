package service;

import dao.ReviewDAO;
import dao.ReviewDAOImpl;
import dto.ReviewDTO;

import java.sql.SQLException;
import java.util.List;

public class ReviewServiceImpl implements ReviewService {

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
}
