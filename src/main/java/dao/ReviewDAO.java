package dao;

import dto.ReviewDTO;

import java.sql.SQLException;
import java.util.List;

public interface ReviewDAO {
    /*
    상품에 대한 리뷰 전체 조회
     */
    List<ReviewDTO> selectAllReviews(int furnitureSeq) throws SQLException;

    /*
    리뷰를 작성한 회원번호 조회
     */
    int findUserSeq(int reviewSeq) throws SQLException;
    
    List<ReviewDTO> selectAll() throws SQLException;

	int delete(int reviewSeq) throws SQLException;

	List<ReviewDTO> selectReviewCount() throws SQLException;
}
