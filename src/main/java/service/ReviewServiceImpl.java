package service;

import dao.ReviewDAO;
import dao.ReviewDAOImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    ReviewDAO reviewDAO = new ReviewDAOImpl();

    public ReviewServiceImpl() throws IOException {
    }

    @Override
    public List<ReviewDTO> selectAllReviews(int furnitureSeq) throws SQLException {
        List<ReviewDTO> list = reviewDAO.selectAllReviews(furnitureSeq);
        return list;
    }
}
