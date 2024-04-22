package service;

import dto.ReviewDTO;

import java.sql.SQLException;
import java.util.List;

public interface ReviewService {
    List<ReviewDTO> selectAllReviews(int furnitureSeq) throws SQLException;

    int findUserSeq(int reviewSeq) throws SQLException;
    
    List<ReviewDTO> selectAll() throws SQLException;

	int delete(int reviewSeq) throws SQLException;

	List<ReviewDTO> selectReviewCount() throws SQLException;

}
