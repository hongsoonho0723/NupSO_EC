package service;

import java.sql.SQLException;
import java.util.List;

public interface ReviewService {
    List<ReviewDTO> selectAllReviews(int furnitureSeq) throws SQLException;
}
