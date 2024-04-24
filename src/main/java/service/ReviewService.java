package service;

import dto.ReviewDTO;
import dto.ReviewImgDTO;

import java.sql.SQLException;
import java.util.List;

public interface ReviewService {
    

    int findUserSeq(int reviewSeq) throws SQLException;
    
    List<ReviewDTO> selectAll() throws SQLException;

	int delete(int reviewSeq) throws SQLException;

	List<ReviewDTO> selectReviewCount() throws SQLException;

	List<ReviewDTO> selectAll(int furnitureSeq) throws SQLException;

	List<ReviewImgDTO> selectReviewImgByReviewSeq(int reviewSeq) throws SQLException;

	List<ReviewDTO> selectReviewUser(int reviewSeq, int furnitureSeq) throws SQLException;

}
