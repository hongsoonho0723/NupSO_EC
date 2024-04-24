package dao;

import dto.ReviewDTO;
import dto.ReviewImgDTO;

import java.sql.SQLException;
import java.util.List;

public interface ReviewDAO {
    /*
    상품에 대한 리뷰 전체 조회
     */
	List<ReviewDTO> selectAll(int furnitureSeq) throws SQLException;
    /*
    리뷰를 작성한 회원번호 조회
     */
    int findUserSeq(int reviewSeq) throws SQLException;
    
    List<ReviewDTO> selectAll() throws SQLException;

	int delete(int reviewSeq) throws SQLException;

	List<ReviewDTO> selectReviewCount() throws SQLException;

	List<ReviewImgDTO> selectReviewImgByReviewSeq(int reviewSeq) throws SQLException;
	
	//해당 유저가 작성한 리뷰이미지와 리뷰를 가져오단
	List<ReviewDTO> selectReviewUser(int reviewSeq, int furnitureSeq) throws SQLException;

	
	
}
