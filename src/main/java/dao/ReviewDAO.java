package dao;

import java.sql.SQLException;
import java.util.List;

public interface ReviewDAO {
    /*
    상품에 대한 리뷰 전체 조회
     */
    List<ReviewDTO> selectAllReviews(int furnitureSeq) throws SQLException;
}
